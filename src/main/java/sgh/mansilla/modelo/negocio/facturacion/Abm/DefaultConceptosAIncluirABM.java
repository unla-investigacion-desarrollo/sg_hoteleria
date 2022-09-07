package sgh.mansilla.modelo.negocio.facturacion.Abm;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import sgh.mansilla.modelo.dao.DaoGenerico;
import sgh.mansilla.modelo.dao.AbstractDao.OrderType;
import sgh.mansilla.modelo.datos.facturacion.ConceptosAIncluir;
import sgh.mansilla.modelo.negocio.ABMGenerico;

@Service("conceptosAIncluirABM")
@Transactional
public class DefaultConceptosAIncluirABM extends ABMGenerico<Integer, ConceptosAIncluir> implements ConceptosAIncluirABM {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	@Autowired
	@Qualifier("conceptosAIncluirDao")
	public void setDao(DaoGenerico<Integer, ConceptosAIncluir> dao) {
		super.setDao(dao);
	}

	@Override
	public void guardar(ConceptosAIncluir entidad) {
		super.guardar(entidad);
	}

	@Override
	protected void actualizarEntidad(ConceptosAIncluir entidadPersistida, ConceptosAIncluir entidadActualizada) {
		BeanUtils.copyProperties(entidadActualizada, entidadPersistida, "idConceptosAIncluir");
	}

	@Override
	public List<ConceptosAIncluir> listar() {
		return dao.list(true, OrderType.ASCENDING, "idConceptosAIncluir");
	}
}
