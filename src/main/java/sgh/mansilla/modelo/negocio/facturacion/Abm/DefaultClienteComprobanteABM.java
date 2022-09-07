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
import sgh.mansilla.modelo.datos.facturacion.ClienteComprobante;
import sgh.mansilla.modelo.negocio.ABMGenerico;

@Service("clienteComprobanteABM")
@Transactional
public class DefaultClienteComprobanteABM extends ABMGenerico<Integer, ClienteComprobante> implements ClienteComprobanteABM {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	@Autowired
	@Qualifier("clienteComprobanteDao")
	public void setDao(DaoGenerico<Integer, ClienteComprobante> dao) {
		super.setDao(dao);
	}

	@Override
	public void guardar(ClienteComprobante entidad) {
		super.guardar(entidad);
	}

	@Override
	protected void actualizarEntidad(ClienteComprobante entidadPersistida, ClienteComprobante entidadActualizada) {
		BeanUtils.copyProperties(entidadActualizada, entidadPersistida, "idClienteComprobante");
	}

	@Override
	public List<ClienteComprobante> listar() {
		return dao.list(true, OrderType.ASCENDING, "idClienteComprobante");
	}
}
