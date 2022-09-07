package sgh.mansilla.modelo.negocio.hotel;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import sgh.mansilla.modelo.dao.AbstractDao.OrderType;
import sgh.mansilla.modelo.dao.DaoGenerico;
import sgh.mansilla.modelo.datos.hotel.TipoServicio;
import sgh.mansilla.modelo.datos.hotel.Servicio;
import sgh.mansilla.modelo.negocio.ABMGenerico;

@Service("servicioABM")
@Transactional
public class DefaultServicioABM extends ABMGenerico<Integer, Servicio> implements ServicioABM {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	TipoServicioABM tipoServicioABM;

	@Override
	@Autowired
	@Qualifier("servicioDao")
	public void setDao(DaoGenerico<Integer, Servicio> dao) {
		super.setDao(dao);
	}

	@Override
	public void guardar(Servicio entidad) {

		TipoServicio attachedTipoServicio = tipoServicioABM.buscarPorId(entidad.getTipoServicio().getId());
		entidad.setTipoServicio(attachedTipoServicio);

		super.guardar(entidad);
	}

	@Override
	protected void actualizarEntidad(Servicio entidadPersistida, Servicio entidadActualizada) {
		TipoServicio attachedTipoServicio = tipoServicioABM.buscarPorId(entidadActualizada.getTipoServicio().getId());
		entidadPersistida.setTipoServicio(attachedTipoServicio);

		entidadPersistida.setDescripcion(entidadActualizada.getDescripcion());
		entidadPersistida.setPrecio(entidadActualizada.getPrecio());

	}


	@Override
	public List<Servicio> listar() {
		return dao.list(true, OrderType.ASCENDING, "idServicio");
	}
}
