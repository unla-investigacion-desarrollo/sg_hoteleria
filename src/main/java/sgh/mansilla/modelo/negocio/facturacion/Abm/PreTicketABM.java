package sgh.mansilla.modelo.negocio.facturacion.Abm;

import java.util.List;

import sgh.mansilla.modelo.datos.facturacion.PreTicket;
import sgh.mansilla.modelo.negocio.ABM;

public interface PreTicketABM  extends ABM<Integer, PreTicket>{
	public List<PreTicket> TraerPorCliente(int idCliente);
}
