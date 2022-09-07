package sgh.mansilla.modelo.negocio.facturacion.Abm;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import sgh.mansilla.modelo.dao.AbstractDao.OrderType;
import sgh.mansilla.modelo.dao.DaoGenerico;
import sgh.mansilla.modelo.datos.facturacion.Comprobante;
import sgh.mansilla.modelo.datos.facturacion.Concepto;
import sgh.mansilla.modelo.datos.facturacion.PreTicket;
import sgh.mansilla.modelo.datos.persona.Pasajero;
import sgh.mansilla.modelo.negocio.ABMGenerico;
import sgh.mansilla.modelo.negocio.estadia.EstadiaABM;

@Service("comprobanteABM")
@Transactional
public class DefaultComprobanteABM extends ABMGenerico<Integer, Comprobante> implements ComprobanteABM {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ConceptoABM conceptoABM;
	
	@Autowired
	PreTicketABM preTicketABM;

	@Override
	@Autowired
	@Qualifier("comprobanteDao")
	public void setDao(DaoGenerico<Integer, Comprobante> dao) {
		super.setDao(dao);
	}

	@Override
	public void guardar(Comprobante entidad) {
		//Parche porque no guarda automaticamente la relacion circular
		List<Concepto> conceptosActualizados = new ArrayList<Concepto>();
		for(Concepto concepto : entidad.getConceptos()){
			if(concepto.getTipoIva() > 0){
				Concepto conceptoActualizado = new Concepto();
				BeanUtils.copyProperties(concepto, conceptoActualizado);
				if(conceptoActualizado.getPreTicket() != null){
					PreTicket attachedPreTicket = preTicketABM.buscarPorId(conceptoActualizado.getPreTicket().getId());
					attachedPreTicket.setConcepto(conceptoActualizado);
					conceptoActualizado.setPreTicket(attachedPreTicket);
				}

				conceptoActualizado.setComprobante(entidad);
				conceptosActualizados.add(conceptoActualizado);
			}
		}
		entidad.setConceptos(conceptosActualizados);
		super.guardar(entidad);
	}

	@Override
	protected void actualizarEntidad(Comprobante entidadPersistida, Comprobante entidadActualizada) {
		for(Concepto concepto : entidadPersistida.getConceptos()){
			conceptoABM.eliminarPorId(concepto.getId());
		}
		for(Concepto concepto : entidadActualizada.getConceptos()){
			if(concepto.getTipoIva() > 0){
				concepto.setComprobante(entidadActualizada);
			}
			if(concepto.getPreTicket() != null){
				PreTicket attachedPreTicket = preTicketABM.buscarPorId(concepto.getPreTicket().getId());
				attachedPreTicket.setConcepto(concepto);
				concepto.setPreTicket(attachedPreTicket);
			}
		}
		BeanUtils.copyProperties(entidadActualizada, entidadPersistida, "idComprobante");
	}

	@Override
	public List<Comprobante> listar() {
		return dao.list(true, OrderType.ASCENDING, "idComprobante");
	}
}
