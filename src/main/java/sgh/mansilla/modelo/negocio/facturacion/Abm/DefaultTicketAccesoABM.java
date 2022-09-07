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
import sgh.mansilla.modelo.dto.facturacion.TicketAcceso;
import sgh.mansilla.modelo.negocio.ABMGenerico;

@Service("ticketAccesoABM")
@Transactional
public class DefaultTicketAccesoABM extends ABMGenerico<Integer, TicketAcceso> implements TicketAccesoABM {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	@Autowired
	@Qualifier("ticketAccesoDao")
	public void setDao(DaoGenerico<Integer, TicketAcceso> dao) {
		super.setDao(dao);
	}

	@Override
	public void guardar(TicketAcceso entidad) {
		super.guardar(entidad);
	}

	@Override
	protected void actualizarEntidad(TicketAcceso entidadPersistida, TicketAcceso entidadActualizada) {
		BeanUtils.copyProperties(entidadActualizada, entidadPersistida, "idTicketAcceso");
	}

	@Override
	public List<TicketAcceso> listar() {
		
		return dao.list(true, OrderType.ASCENDING, "idTicketAcceso");
	}
	
	//public List<PreTicket> TraerPorCliente(int idCliente){
	//	return ((TicketAccesoDao)dao).PreTicketsPorCliente(idCliente);
	//}
	
	
}