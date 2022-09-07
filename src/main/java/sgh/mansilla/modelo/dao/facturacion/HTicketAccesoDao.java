package sgh.mansilla.modelo.dao.facturacion;

import org.springframework.stereotype.Repository;

import sgh.mansilla.modelo.dao.AbstractDao;
import sgh.mansilla.modelo.dto.facturacion.TicketAcceso;

@Repository("ticketAccesoDao")
public class HTicketAccesoDao extends AbstractDao<Integer, TicketAcceso> implements TicketAccesoDao {

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<PreTicket> PreTicketsPorCliente(int idCliente) {
//		Criteria criteria = createEntityCriteria();
//		criteria.add(Restrictions.eq("clientePreTicket.idClienteComprobante", idCliente));
//		return (List<PreTicket>)criteria.list();
//	}


}
