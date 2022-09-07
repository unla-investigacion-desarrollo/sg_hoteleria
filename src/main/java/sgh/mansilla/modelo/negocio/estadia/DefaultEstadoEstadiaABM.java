package sgh.mansilla.modelo.negocio.estadia;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import sgh.mansilla.modelo.dao.DaoGenerico;
import sgh.mansilla.modelo.dao.AbstractDao.OrderType;
import sgh.mansilla.modelo.datos.estadia.EstadoEstadia;
import sgh.mansilla.modelo.negocio.ABMGenerico;

@Service("estadoEstadiaABM")
@Transactional
public class DefaultEstadoEstadiaABM extends ABMGenerico<Integer, EstadoEstadia> implements EstadoEstadiaABM {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	@Autowired
	@Qualifier("estadoEstadiaDao")
	public void setDao(DaoGenerico<Integer, EstadoEstadia> dao) {
		super.setDao(dao);
	}


	@Override
	protected void actualizarEntidad(EstadoEstadia entidadPersistida, EstadoEstadia entidadActualizada) {
		entidadPersistida.setEstado(entidadActualizada.getEstado());
		entidadPersistida.setColor(entidadActualizada.getColor());
	}

	@Override
	public List<EstadoEstadia> listar() {
		return dao.list(true, OrderType.ASCENDING, "idEstadoEstadia");
	}
}
