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
import sgh.mansilla.modelo.datos.facturacion.FormaDePago;
import sgh.mansilla.modelo.negocio.ABMGenerico;

@Service("formaDePagoABM")
@Transactional
public class DefaultFormaDePagoABM extends ABMGenerico<Integer, FormaDePago> implements FormaDePagoABM {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	@Autowired
	@Qualifier("formaDePagoDao")
	public void setDao(DaoGenerico<Integer, FormaDePago> dao) {
		super.setDao(dao);
	}

	@Override
	public void guardar(FormaDePago entidad) {
		super.guardar(entidad);
	}

	@Override
	protected void actualizarEntidad(FormaDePago entidadPersistida, FormaDePago entidadActualizada) {
		BeanUtils.copyProperties(entidadActualizada, entidadPersistida, "idFormaDePago");
	}

	@Override
	public List<FormaDePago> listar() {
		return dao.list(true, OrderType.ASCENDING, "idFormaDePago");
	}
}