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
import sgh.mansilla.modelo.datos.facturacion.ItemPreTicket;
import sgh.mansilla.modelo.negocio.ABMGenerico;

@Service("itemPreTicketABM")
@Transactional
public class DefaultItemPreTicketABM extends ABMGenerico<Integer, ItemPreTicket> implements ItemPreTicketABM {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	@Autowired
	@Qualifier("itemPreTicketDao")
	public void setDao(DaoGenerico<Integer, ItemPreTicket> dao) {
		super.setDao(dao);
	}

	@Override
	public void guardar(ItemPreTicket entidad) {
		super.guardar(entidad);
	}

	@Override
	protected void actualizarEntidad(ItemPreTicket entidadPersistida, ItemPreTicket entidadActualizada) {
		BeanUtils.copyProperties(entidadActualizada, entidadPersistida, "idItemPreTicket");
	}

	@Override
	public List<ItemPreTicket> listar() {
		return dao.list(true, OrderType.ASCENDING, "idItemPreTicket");
	}
}
