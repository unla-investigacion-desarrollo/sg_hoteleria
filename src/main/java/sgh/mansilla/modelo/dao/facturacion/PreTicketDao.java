package sgh.mansilla.modelo.dao.facturacion;

import java.util.List;

import sgh.mansilla.modelo.dao.DaoGenerico;

import sgh.mansilla.modelo.datos.facturacion.PreTicket;

public interface PreTicketDao extends DaoGenerico<Integer, PreTicket>{

	public List<PreTicket> PreTicketsPorCliente(int idCliente);
}
