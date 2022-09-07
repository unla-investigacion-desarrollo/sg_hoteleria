package sgh.mansilla.modelo.negocio.persona;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import sgh.mansilla.modelo.dao.AbstractDao.OrderType;
import sgh.mansilla.modelo.dao.DaoGenerico;
import sgh.mansilla.modelo.datos.persona.TipoDocumento;
import sgh.mansilla.modelo.datos.hotel.CaracteristicaHabitacion;
import sgh.mansilla.modelo.datos.persona.CaracteristicaPasajero;
import sgh.mansilla.modelo.datos.persona.Pasajero;
import sgh.mansilla.modelo.negocio.ABMGenerico;
import sgh.mansilla.modelo.negocio.persona.TipoDocumentoABM;

@Service("pasajeroABM")
@Transactional
public class DefaultPasajeroABM extends ABMGenerico<Integer, Pasajero> implements PasajeroABM {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	TipoDocumentoABM tipoDocumentoABM;

	@Autowired
	CaracteristicaPasajeroABM caracteristicaPasajeroABM;

	@Override
	@Autowired
	@Qualifier("pasajeroDao")
	public void setDao(DaoGenerico<Integer, Pasajero> dao) {
		super.setDao(dao);
	}

	@Override
	public void guardar(Pasajero entidad) {
		TipoDocumento attachedTipoDocumento = tipoDocumentoABM.buscarPorId(entidad.getTipoDocumento().getId());
		entidad.setTipoDocumento(attachedTipoDocumento);
		super.guardar(entidad);
	}

	@Override
	protected void actualizarEntidad(Pasajero entidadPersistida, Pasajero entidadActualizada) {
		entidadPersistida.setTelefono(entidadActualizada.getTelefono());
		entidadPersistida.setEmail(entidadActualizada.getEmail());
		entidadPersistida.setNombre(entidadActualizada.getNombre());
		entidadPersistida.setApellido(entidadActualizada.getApellido());
		TipoDocumento attachedTipoDocumento = tipoDocumentoABM.buscarPorId(entidadActualizada.getTipoDocumento().getId());
		entidadPersistida.setTipoDocumento(attachedTipoDocumento);

		Set<CaracteristicaPasajero> caracteristicas = entidadActualizada.getCaracteristicas();
		if (!CollectionUtils.isEmpty(caracteristicas)) {
			Set<CaracteristicaPasajero> attachedCaracteristicaPasajero = new LinkedHashSet<CaracteristicaPasajero>();
			for (CaracteristicaPasajero cp : entidadActualizada.getCaracteristicas()) {
				attachedCaracteristicaPasajero.add(caracteristicaPasajeroABM.buscarPorId(cp.getId()));
			}
			entidadPersistida.setCaracteristicas(attachedCaracteristicaPasajero);
		}
		entidadPersistida.setDocumento(entidadActualizada.getDocumento());
		entidadPersistida.setFechaDeNacimiento(entidadActualizada.getFechaDeNacimiento());
	}

	@Override
	public List<Pasajero> listar() {
		return dao.list(true, OrderType.ASCENDING, "idContacto");
	}
}
