package sgh.mansilla.modelo.dao.facturacion;

import org.springframework.stereotype.Repository;

import sgh.mansilla.modelo.dao.AbstractDao;
import sgh.mansilla.modelo.datos.facturacion.ItemPreTicket;

@Repository("itemPreTicketDao")
public class HItemPreTicketDao extends AbstractDao<Integer, ItemPreTicket> implements ItemPreTicketDao {


}
