package sgh.mansilla.vista.abm;


import java.beans.PropertyEditorSupport;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.SimpleTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sgh.mansilla.modelo.datos.facturacion.ClienteComprobante;
import sgh.mansilla.modelo.datos.facturacion.PreTicket;
import sgh.mansilla.modelo.negocio.ABM;
import sgh.mansilla.modelo.negocio.facturacion.Abm.ClienteComprobanteABM;

@Controller
@RequestMapping("/preticket")
public class PreTicketABMController extends AbstractABMController<Integer, PreTicket> {

	@Autowired
	ClienteComprobanteABM clienteComprobanteABM;
	
	@Autowired
	@Qualifier("preTicketABM")
	protected void setAbm(ABM<Integer, PreTicket> abm) {
		super.setAbm(abm);
	}

	public PreTicketABMController() {
		super("abm/preTicket");
	}

	@Override
	protected PreTicket createEntity() {
		return new PreTicket();
	}
	
	
	
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);

		binder.registerCustomEditor(Date.class, "fecha", new CustomDateEditor(dateFormat, true));
		
		binder.registerCustomEditor(ClienteComprobante.class, new ClienteComprobanteEditor());
    }
	
	@ModelAttribute("clienteComprobante")
	public List<ClienteComprobante> initializeClienteComprobante() {
		return clienteComprobanteABM.listar();
	}
	
	private class ClienteComprobanteEditor extends PropertyEditorSupport {

		private SimpleTypeConverter typeConverter = new SimpleTypeConverter();

		@Override
		public void setAsText(String text) {
			if (text == null || 0 == text.length()) {
				setValue(null);
				return;
			}

			setValue(clienteComprobanteABM.buscarPorId(typeConverter.convertIfNecessary(text, Integer.class)));
		}
	}
	

}