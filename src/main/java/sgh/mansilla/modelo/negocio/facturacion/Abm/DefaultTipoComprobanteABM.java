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
import sgh.mansilla.modelo.datos.facturacion.TipoComprobante;
import sgh.mansilla.modelo.negocio.ABMGenerico;

@Service("tipoComprobanteABM")
@Transactional
public class DefaultTipoComprobanteABM extends ABMGenerico<Integer, TipoComprobante> implements TipoComprobanteABM {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	@Autowired
	@Qualifier("tipoComprobanteDao")
	public void setDao(DaoGenerico<Integer, TipoComprobante> dao) {
		super.setDao(dao);
	}

	@Override
	public void guardar(TipoComprobante entidad) {
		super.guardar(entidad);
	}

	@Override
	protected void actualizarEntidad(TipoComprobante entidadPersistida, TipoComprobante entidadActualizada) {
		BeanUtils.copyProperties(entidadActualizada, entidadPersistida, "idTipoComprobante");
	}

	@Override
	public List<TipoComprobante> listar() {
		return dao.list(true, OrderType.ASCENDING, "idTipoComprobante");
	}
}