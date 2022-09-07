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
import sgh.mansilla.modelo.datos.hotel.TipoHabitacion;
import sgh.mansilla.modelo.negocio.ABMGenerico;

@Service("tipoHabitacionABM")
@Transactional
public class DefaultTipoHabitacionABM extends ABMGenerico<Integer, TipoHabitacion> implements TipoHabitacionABM {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	@Autowired
	@Qualifier("tipoHabitacionDao")
	public void setDao(DaoGenerico<Integer, TipoHabitacion> dao) {
		super.setDao(dao);
	}

	@Override
	public void guardar(TipoHabitacion entidad) {
		super.guardar(entidad);
	}

	@Override
	protected void actualizarEntidad(TipoHabitacion entidadPersistida, TipoHabitacion entidadActualizada) {
		entidadPersistida.setDescripcion(entidadActualizada.getDescripcion());
		entidadPersistida.setNombreTipoHabitacion(entidadActualizada.getNombreTipoHabitacion());
		entidadPersistida.setCapacidad(entidadActualizada.getCapacidad());
	}

	@Override
	public List<TipoHabitacion> listar() {
		return dao.list(true, OrderType.ASCENDING, "idTipoHabitacion");
	}
}
