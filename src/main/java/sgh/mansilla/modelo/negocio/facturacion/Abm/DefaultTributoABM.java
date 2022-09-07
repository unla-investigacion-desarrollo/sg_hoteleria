package sgh.mansilla.modelo.negocio.facturacion.Abm;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import sgh.mansilla.modelo.dao.DaoGenerico;
import sgh.mansilla.modelo.dao.AbstractDao.OrderType;
import sgh.mansilla.modelo.datos.facturacion.Tributo;
import sgh.mansilla.modelo.negocio.ABMGenerico;

@Service("tributoABM")
@Transactional
public class DefaultTributoABM extends ABMGenerico<Integer, Tributo> implements TributoABM {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	@Autowired
	@Qualifier("tributoDao")
	public void setDao(DaoGenerico<Integer, Tributo> dao) {
		super.setDao(dao);
	}

	@Override
	public void guardar(Tributo entidad) {
		super.guardar(entidad);
	}

	@Override
	protected void actualizarEntidad(Tributo entidadPersistida, Tributo entidadActualizada) {

	}

	@Override
	public List<Tributo> listar() {
		return dao.list(true, OrderType.ASCENDING, "idTributo");
	}
}