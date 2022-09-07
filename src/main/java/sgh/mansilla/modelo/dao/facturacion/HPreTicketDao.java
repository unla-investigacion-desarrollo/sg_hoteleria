package sgh.mansilla.modelo.dao.facturacion;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sgh.mansilla.modelo.dao.AbstractDao;
import sgh.mansilla.modelo.datos.facturacion.PreTicket;

@Repository("preTicketDao")
public class HPreTicketDao extends AbstractDao<Integer, PreTicket> implements PreTicketDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<PreTicket> PreTicketsPorCliente(int idCliente) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("clientePreTicket.idClienteComprobante", idCliente));
		return (List<PreTicket>)criteria.list();
	}


}
