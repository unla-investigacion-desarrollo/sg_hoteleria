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
import sgh.mansilla.modelo.datos.hotel.EstadoHabitacion;
import sgh.mansilla.modelo.negocio.ABMGenerico;

@Service("estadoHabitacionABM")
@Transactional
public class DefaultEstadoHabitacionABM extends ABMGenerico<Integer, EstadoHabitacion> implements EstadoHabitacionABM {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	@Autowired
	@Qualifier("estadoHabitacionDao")
	public void setDao(DaoGenerico<Integer, EstadoHabitacion> dao) {
		super.setDao(dao);
	}

	@Override
	public void guardar(EstadoHabitacion entidad) {
		super.guardar(entidad);
	}

	@Override
	protected void actualizarEntidad(EstadoHabitacion entidadPersistida, EstadoHabitacion entidadActualizada) {
		entidadPersistida.setDescripcion(entidadActualizada.getDescripcion());
	}

	@Override
	public List<EstadoHabitacion> listar() {
		return dao.list(true, OrderType.ASCENDING, "idEstadoHabitacion");
	}
}
