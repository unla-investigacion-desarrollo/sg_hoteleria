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
import sgh.mansilla.modelo.datos.facturacion.Concepto;
import sgh.mansilla.modelo.negocio.ABMGenerico;

@Service("conceptoABM")
@Transactional
public class DefaultConceptoABM extends ABMGenerico<Integer, Concepto> implements ConceptoABM {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	@Autowired
	@Qualifier("conceptoDao")
	public void setDao(DaoGenerico<Integer, Concepto> dao) {
		super.setDao(dao);
	}

	@Override
	public void guardar(Concepto entidad) {
		super.guardar(entidad);
	}

	@Override
	protected void actualizarEntidad(Concepto entidadPersistida, Concepto entidadActualizada) {
		BeanUtils.copyProperties(entidadActualizada, entidadPersistida, "idConcepto");
	}

	@Override
	public List<Concepto> listar() {
		return dao.list(true, OrderType.ASCENDING, "idConcepto");
	}
}
