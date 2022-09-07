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
import sgh.mansilla.modelo.dao.facturacion.PreTicketDao;
import sgh.mansilla.modelo.dao.AbstractDao.OrderType;
import sgh.mansilla.modelo.dao.usuario.UsuarioDAO;
import sgh.mansilla.modelo.datos.facturacion.PreTicket;
import sgh.mansilla.modelo.negocio.ABMGenerico;

@Service("preTicketABM")
@Transactional
public class DefaultPreTicketABM extends ABMGenerico<Integer, PreTicket> implements PreTicketABM {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	@Autowired
	@Qualifier("preTicketDao")
	public void setDao(DaoGenerico<Integer, PreTicket> dao) {
		super.setDao(dao);
	}

	@Override
	public void guardar(PreTicket entidad) {
		super.guardar(entidad);
	}

	@Override
	protected void actualizarEntidad(PreTicket entidadPersistida, PreTicket entidadActualizada) {
		BeanUtils.copyProperties(entidadActualizada, entidadPersistida, "idPreTicket");
	}

	@Override
	public List<PreTicket> listar() {
		
		return dao.list(true, OrderType.ASCENDING, "idPreTicket");
	}
	
	public List<PreTicket> TraerPorCliente(int idCliente){
		return ((PreTicketDao)dao).PreTicketsPorCliente(idCliente);
	}
	
	
}