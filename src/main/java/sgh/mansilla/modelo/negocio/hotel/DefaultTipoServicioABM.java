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
import sgh.mansilla.modelo.negocio.ABMGenerico;

@Service("tipoServicioABM")
@Transactional
public class DefaultTipoServicioABM extends ABMGenerico<Integer, TipoServicio> implements TipoServicioABM {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	@Autowired
	@Qualifier("tipoServicioDao")
	public void setDao(DaoGenerico<Integer, TipoServicio> dao) {
		super.setDao(dao);
	}

	@Override
	public void guardar(TipoServicio entidad) {
		super.guardar(entidad);
	}

	@Override
	protected void actualizarEntidad(TipoServicio entidadPersistida, TipoServicio entidadActualizada) {
		entidadPersistida.setDescripcion(entidadActualizada.getDescripcion());
	}

	@Override
	public List<TipoServicio> listar() {
		return dao.list(true, OrderType.ASCENDING, "idTipoServicio");
	}
}
