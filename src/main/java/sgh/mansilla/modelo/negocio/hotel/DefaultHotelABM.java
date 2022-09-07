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
import sgh.mansilla.modelo.datos.hotel.Hotel;
import sgh.mansilla.modelo.datos.hotel.Habitacion;
import sgh.mansilla.modelo.negocio.ABMGenerico;

@Service("hotelABM")
@Transactional
public class DefaultHotelABM extends ABMGenerico<Integer, Hotel> implements HotelABM {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	HabitacionABM habitacionABM;

	@Override
	@Autowired
	@Qualifier("hotelDao")
	public void setDao(DaoGenerico<Integer, Hotel> dao) {
		super.setDao(dao);
	}

	@Override
	public void guardar(Hotel entidad, int idHabitacion) {
		Habitacion attachedHabitacion =
				habitacionABM.buscarPorId(idHabitacion);
		entidad.addHabitacion(attachedHabitacion);

		super.guardar(entidad);
	}

	@Override
	protected void actualizarEntidad(Hotel entidadPersistida, Hotel entidadActualizada) {
		entidadPersistida.setDireccion(entidadActualizada.getDireccion());
		entidadPersistida.setEmail(entidadActualizada.getEmail());
		entidadPersistida.setNombreHotel(entidadActualizada.getNombreHotel());
		entidadPersistida.setPaginaWeb(entidadActualizada.getPaginaWeb());
		entidadPersistida.setTelefono(entidadActualizada.getTelefono());
	}

	// VER DE AGREGAR METODOS PARA ADD ITEM CONSUMO

	@Override
	public List<Hotel> listar() {
		return dao.list(true, OrderType.ASCENDING, "idHotel");
	}
}
