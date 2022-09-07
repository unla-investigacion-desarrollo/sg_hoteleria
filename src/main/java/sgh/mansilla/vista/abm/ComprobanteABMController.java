package sgh.mansilla.vista.abm;


import java.beans.PropertyEditorSupport;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.SimpleTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import sgh.mansilla.modelo.datos.facturacion.ClienteComprobante;
import sgh.mansilla.modelo.datos.facturacion.Comprobante;
import sgh.mansilla.modelo.datos.facturacion.Concepto;
import sgh.mansilla.modelo.datos.facturacion.ConceptosAIncluir;
import sgh.mansilla.modelo.datos.facturacion.FormaDePago;
import sgh.mansilla.modelo.datos.facturacion.Moneda;
import sgh.mansilla.modelo.datos.facturacion.PreTicket;
import sgh.mansilla.modelo.datos.facturacion.RespuestaProcesarFactura;
import sgh.mansilla.modelo.datos.facturacion.TipoComprobante;
import sgh.mansilla.modelo.dto.facturacion.ComprobanteDTO;
import sgh.mansilla.modelo.dto.facturacion.TicketAcceso;
import sgh.mansilla.modelo.dto.facturacion.Vendedor;
import sgh.mansilla.modelo.dto.facturacion.afip.AlicIva;
import sgh.mansilla.modelo.negocio.ABM;
import sgh.mansilla.modelo.negocio.facturacion.Abm.ClienteComprobanteABM;
import sgh.mansilla.modelo.negocio.facturacion.Abm.ConceptosAIncluirABM;
import sgh.mansilla.modelo.negocio.facturacion.Abm.FormaDePagoABM;
import sgh.mansilla.modelo.negocio.facturacion.Abm.MonedaABM;
import sgh.mansilla.modelo.negocio.facturacion.Abm.PreTicketABM;
import sgh.mansilla.modelo.negocio.facturacion.Abm.TicketAccesoABM;
import sgh.mansilla.modelo.negocio.facturacion.Abm.TipoComprobanteABM;
import sgh.mansilla.modelo.negocio.facturacion.Servicios.FacturaToPDF;
import sgh.mansilla.modelo.negocio.facturacion.Servicios.ServicioAfip;

@Controller
@RequestMapping("/comprobante")
public class ComprobanteABMController extends AbstractABMController<Integer, Comprobante> {

	@Autowired
	TipoComprobanteABM tipoComprobanteABM;
	@Autowired
	ClienteComprobanteABM clienteComprobanteABM;
	@Autowired
	MonedaABM monedaABM;
	@Autowired
	ConceptosAIncluirABM conceptosAIncluirABM;
	@Autowired
	FormaDePagoABM formaDePagoABM;
	@Autowired
	PreTicketABM preTicketABM;
	@Autowired
	TicketAccesoABM ticketAccesoABM;
	
	@Autowired
	@Qualifier("comprobanteABM")
	protected void setAbm(ABM<Integer, Comprobante> abm) {
		super.setAbm(abm);
	}

	public ComprobanteABMController() {
		super("abm/comprobante");
	}

	@Override
	protected Comprobante createEntity() {
		return new Comprobante();
	}
	
	/**
	 * This method will provide the medium to add a new user.
	 */
	@RequestMapping(value = { "/newComprobante"}, method = RequestMethod.GET)
	public String newEntity(ModelMap model) {
		Comprobante entity = createEntity();
		model.addAttribute("titulo", "Crear Comprobante");
		model.addAttribute("entity", entity);
		model.addAttribute("edit", false);
		model.addAttribute("loggedinuser", getPrincipal());
		return viewBaseLocation + "/form";
	}
	
	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newComprobante" }, method = RequestMethod.POST)
	public String saveEntity(@Valid Comprobante entity, BindingResult result, ModelMap model,
			@RequestParam(required = false) Boolean facturar) {
		try{
	
			if (result.hasErrors()) {
				return viewBaseLocation + "/form";
			}
			
			Iterator<Concepto> i = entity.getConceptos().iterator();
			while (i.hasNext()) {
				Concepto o = i.next();
			  //some condition
				if(o.getTipoIva() == 0)
					i.remove();
			}
			
			if(facturar){
				RespuestaProcesarFactura rpf = Facturar(entity);
				if(rpf.getCae() != null && rpf.getCae() != ""){
					entity.setCae(rpf.getCae());
					entity.setVencimientoCae(rpf.getFechaVtoCae().getTime());
					//File file = GenerarPdf(entity);
					//EnviarMail(entity.getClienteComprobante().getMail(),file);
					model.addAttribute("facturado", "El comprobante fue emitido correctamente");
				}else{
					model.addAttribute("observacionesComprobante", rpf.getListaObservaciones());
					model.addAttribute("erroresComprobante", rpf.getListaErrores());
					model.addAttribute("entity", entity);
					return viewBaseLocation + "/form";
				}
			}
	
			abm.guardar(entity);
			if(entity.getNroComprobante() != 0){
				model.addAttribute("nroComprobante", entity.getNroComprobante());
			}
			model.addAttribute("success", "La creaci&oacuten se realiz&oacute correctamente.");
			
		} catch(Exception e) {
			model.addAttribute("success", "La creaci&oacuten no pudo realizarse.");
		}
		model.addAttribute("loggedinuser", getPrincipal());
		return "redirect:list";
	}
	
	/**
	 * This method will provide the medium to update an existing user.
	 */
	@RequestMapping(value = { "/editComprobante-{id}" }, method = RequestMethod.GET)
	public String editEntity(@PathVariable int id, ModelMap model) {
		Comprobante entity = abm.buscarPorId(id);
		model.addAttribute("entity", entity);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", getPrincipal());
		model.addAttribute("titulo", "Editar Comprobante");
		return viewBaseLocation + "/form";
	}

	@RequestMapping(value = { "/editComprobante-{id}" }, method = RequestMethod.POST)
	public String updateEntity(@Valid Comprobante entity, BindingResult result,
			ModelMap model, @PathVariable int id,@RequestParam(required = false) Boolean facturar) {
		try{


			if (result.hasErrors()) {
				return super.viewBaseLocation + "/form";
			}

			
			model.addAttribute("success", "La modificaci&oacuten se realiz&oacute correctamente.");
		} catch (Exception exception) {
			model.addAttribute("success", "La modificaci&oacuten no pudo realizarse.");
		}
		
		Iterator<Concepto> i = entity.getConceptos().iterator();
		while (i.hasNext()) {
			Concepto o = i.next();
		  //some condition
			if(o.getTipoIva() == 0)
				i.remove();
		}
		
		if(facturar){
			RespuestaProcesarFactura rpf = Facturar(entity);
			if(rpf.getCae() != null && rpf.getCae() != ""){
				entity.setCae(rpf.getCae());
				entity.setVencimientoCae(rpf.getFechaVtoCae().getTime());
				//File file = GenerarPdf(entity);
				//EnviarMail(entity.getClienteComprobante().getMail(),file);
				model.addAttribute("facturado", "El comprobante fue emitido correctamente");
			}else{
				model.addAttribute("observacionesComprobante", rpf.getListaObservaciones());
				model.addAttribute("erroresComprobante", rpf.getListaErrores());
				model.addAttribute("entity", entity);
				return viewBaseLocation + "/form";
			}
		}
		abm.actualizar(entity);

		model.addAttribute("entity", entity);
		model.addAttribute("edit", true);
		model.addAttribute("loggedinuser", super.getPrincipal());
		//return viewBaseLocation + "/list";
		return super.viewBaseLocation + "/form";

	}
	
//	@RequestMapping(value = { "/TraerPreTicketsPorCliente" }, method = RequestMethod.POST)
//	public String traerPreTicketsPorCliente(@RequestParam(required = false) Integer idCliente, ModelMap model) {
//		List<PreTicket> preTickets = preTicketABM.listar();
//		ModelAndView
//		model.addAttribute("entities", preTickets);
//		return viewBaseLocation + "/list";
//		
//	}
//	
	@RequestMapping(value="/TraerPreTicketsPorCliente", method=RequestMethod.GET)
    public ModelAndView TraerPreTicketsPorCliente(@RequestParam  int id) {
        ModelAndView mav = new ModelAndView("abm/comprobante/TraerPreTicketsPorCliente");
        List<PreTicket> preTickets = preTicketABM.TraerPorCliente(id);
        List<PreTicket> preTicketsSinAsignar = new ArrayList<PreTicket>();
        preTicketsSinAsignar = preTickets.stream().filter(c -> c.getConcepto() == null).collect(Collectors.toList());
        
        mav.addObject("preTickets", preTicketsSinAsignar);
        return mav;
    }
	
	@RequestMapping(value="/TraerItemsPreTicket", method=RequestMethod.GET)
    public ModelAndView TraerItemsPreTicket(@RequestParam  int id) {
        ModelAndView mav = new ModelAndView("abm/comprobante/TraerItemsPreTicket");
        PreTicket preTicket = preTicketABM.buscarPorId(id);

        mav.addObject("itemsPreTicket", preTicket.getItemsPreTicket());
        return mav;
    }
	
	@RequestMapping(value = { "/Download/{id}" }, method = RequestMethod.GET, produces = "application/pdf")
	public @ResponseBody Resource downloadC(HttpServletResponse response, @PathVariable int id) throws FileNotFoundException {
		Comprobante comprobante = abm.buscarPorId(id);

		File file = GenerarPdf(comprobante);
		
	    response.setContentType("application/pdf");
	    response.setHeader("Content-Disposition", "inline; filename=" + file.getName());
	    response.setHeader("Content-Length", String.valueOf(file.length()));
	    return new FileSystemResource(file);
	}
	
	@RequestMapping(value="/EnviarComprobante", method=RequestMethod.GET)
	public @ResponseBody Boolean EnviarComprobante(@RequestParam  int id) {
		Boolean enviado = false;
		Comprobante comprobante = abm.buscarPorId(id);
		File file = GenerarPdf(comprobante);
		enviado = EnviarMail(comprobante.getClienteComprobante().getMail(),file);
	    return enviado;
	}

	@InitBinder
    public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "fechaComprobante", new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(Date.class, "fechaFacturadoDesde", new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(Date.class, "fechaFacturadoHasta", new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(Date.class, "vencimientoPago", new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(Date.class, "vencimientoCae", new CustomDateEditor(dateFormat, true));

		binder.registerCustomEditor(ClienteComprobante.class, new ClienteComprobanteEditor());
		binder.registerCustomEditor(TipoComprobante.class, new TipoComprobanteEditor());
		binder.registerCustomEditor(ConceptosAIncluir.class, new ConceptosAIncluirEditor());
		binder.registerCustomEditor(Moneda.class, new MonedaEditor());
		binder.registerCustomEditor(FormaDePago.class, new FormaDePagoEditor());
		binder.registerCustomEditor(PreTicket.class, new PreTicketEditor());
    }
	
	@ModelAttribute("clienteComprobante")
	public List<ClienteComprobante> initializeClienteComprobante() {
		return clienteComprobanteABM.listar();
	}
	
	@ModelAttribute("tipoComprobante")
	public List<TipoComprobante> initializeTipoComprobante() {
		return tipoComprobanteABM.listar();
	}
	
	@ModelAttribute("conceptosAIncluir")
	public List<ConceptosAIncluir> initializeConceptosAIncluir() {
		return conceptosAIncluirABM.listar();
	}
	
	@ModelAttribute("moneda")
	public List<Moneda> initializeMoneda() {
		return monedaABM.listar();
	}
	
	
	@ModelAttribute("formaDePago")
	public List<FormaDePago> initializeFormaDePago() {
		return formaDePagoABM.listar();
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
	
	private class TipoComprobanteEditor extends PropertyEditorSupport {

		private SimpleTypeConverter typeConverter = new SimpleTypeConverter();

		@Override
		public void setAsText(String text) {
			if (text == null || 0 == text.length()) {
				setValue(null);
				return;
			}

			setValue(tipoComprobanteABM.buscarPorId(typeConverter.convertIfNecessary(text, Integer.class)));
		}
	}
	
	private class MonedaEditor extends PropertyEditorSupport {

		private SimpleTypeConverter typeConverter = new SimpleTypeConverter();

		@Override
		public void setAsText(String text) {
			if (text == null || 0 == text.length()) {
				setValue(null);
				return;
			}

			setValue(monedaABM.buscarPorId(typeConverter.convertIfNecessary(text, Integer.class)));
		}
	}
	
	private class FormaDePagoEditor extends PropertyEditorSupport {

		private SimpleTypeConverter typeConverter = new SimpleTypeConverter();

		@Override
		public void setAsText(String text) {
			if (text == null || 0 == text.length()) {
				setValue(null);
				return;
			}

			setValue(formaDePagoABM.buscarPorId(typeConverter.convertIfNecessary(text, Integer.class)));
		}
	}
	
	private class ConceptosAIncluirEditor extends PropertyEditorSupport {

		private SimpleTypeConverter typeConverter = new SimpleTypeConverter();

		@Override
		public void setAsText(String text) {
			if (text == null || 0 == text.length()) {
				setValue(null);
				return;
			}

			setValue(conceptosAIncluirABM.buscarPorId(typeConverter.convertIfNecessary(text, Integer.class)));
		}
	}
	
	private class PreTicketEditor extends PropertyEditorSupport {

		private SimpleTypeConverter typeConverter = new SimpleTypeConverter();

		@Override
		public void setAsText(String text) {
			if (text == null || 0 == text.length()) {
				setValue(null);
				return;
			}

			setValue(preTicketABM.buscarPorId(typeConverter.convertIfNecessary(text, Integer.class)));
		}
	}
	
	private RespuestaProcesarFactura Facturar(Comprobante comprobante) {
		ComprobanteDTO f1 = new ComprobanteDTO();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(comprobante.getFechaComprobante());
		int anio = cal.get(Calendar.YEAR);
		int mes = cal.get(Calendar.MONTH);
		int dia = cal.get(Calendar.DAY_OF_MONTH);

		
		//COMPROBANTE
		f1.setNroDocumentoCliente(comprobante.getClienteComprobante().getDocumento());
		f1.setCodigoDocumento(String.valueOf(comprobante.getClienteComprobante().getTipoDocumento().getIdDocumentoAfip()));
		f1.setFecha(new GregorianCalendar(anio,mes,dia));
		f1.setCodigoComprobante(comprobante.getTipoComprobante().getCodigo());
		f1.setCondicionVenta(String.valueOf(comprobante.getFormaDePago().getCodigo()));
		f1.setIdConcepto(comprobante.getConceptosAIncluir().getCodigo());
		f1.setCantidadRegistros(1);
		//f1.setNumeroComprobante(comprobante.getNroComprobante());
		
		//MONEDA
		f1.setIdMoneda(comprobante.getMoneda().getCodigo());
		f1.setCotizacionMoneda(1);
		
		//IVA
		f1.setTotalIva(comprobante.getTotalIva());
		f1.setIdIva(5);
		f1.setPorcentajeIva(21);
		
		//TOTALES
		f1.setImporteTotal(comprobante.getImporteTotal());
		f1.setImporteNeto(comprobante.getImporteTotal()-comprobante.getTotalIva());
		f1.setSubtotal(comprobante.getImporteTotal()-comprobante.getTotalIva());
		
		//ALICUOTAS IVA
		f1.setAlicIvas(generarArrayAlicuotas(comprobante));
		
		ServicioAfip servicioAfip = new ServicioAfip();
		
		
		TicketAcceso ticketAcceso = GetTicketAcceso(servicioAfip);
		RespuestaProcesarFactura rpf = new RespuestaProcesarFactura();
		if(ticketAcceso == null){
			List<String> listaErrores = new ArrayList<String>();
			listaErrores.add("No se pudo obtener el ticket de acceso.");
			rpf.setListaErrores(listaErrores);
			return rpf;
		}
		
		int nroUltimoComprobante = servicioAfip.obtenerUltimoComprobante(ticketAcceso, f1.getCodigoComprobante(),comprobante.getPtoVenta());
		rpf =servicioAfip.procesarComprobante(f1,ticketAcceso,nroUltimoComprobante,comprobante.getPtoVenta());
		comprobante.setNroComprobante(rpf.getNroComprobante());
		
		return rpf;
	}

	
	private TicketAcceso GetTicketAcceso(ServicioAfip servicioAfip) {
		TicketAcceso ticketAcceso = null;
		
		try{
			ticketAcceso = ticketAccesoABM.buscarPorId(1);
		}catch(Exception e){
			
		}
		Calendar calendar = Calendar.getInstance();
        java.util.Date date =  calendar.getTime();
		
        try{
        	if(ticketAcceso == null){
    			ticketAcceso =  servicioAfip.obtenerTicketAcceso();
    			if(ticketAcceso.getSign() != null && ticketAcceso.getSign() != "")
    				ticketAccesoABM.guardar(ticketAcceso);
    		}else if(ticketAcceso.getFechaHoraExpiracion().compareTo(date) < 0){
    			TicketAcceso ticketAccesoNuevo =  servicioAfip.obtenerTicketAcceso();
    			if(ticketAccesoNuevo.getSign() != null && ticketAccesoNuevo.getSign() != ""){
    				ticketAcceso.setCuit(ticketAccesoNuevo.getCuit());
    				ticketAcceso.setSign(ticketAccesoNuevo.getSign());
    				ticketAcceso.setToken(ticketAccesoNuevo.getToken());
    				ticketAcceso.setFechaHoraExpiracion(ticketAccesoNuevo.getFechaHoraExpiracion());
    				ticketAccesoABM.actualizar(ticketAcceso);
    			}
    		}
        }catch(Exception ex){
        	
        }
		
		return ticketAcceso;
	}
	
	private AlicIva[] generarArrayAlicuotas(Comprobante comprobante){
		double iva0bi = 0;
		double iva0importe = 0;
		double iva105bi = 0;
		double iva105importe = 0;
		double iva21bi = 0;
		double iva21importe = 0;
		double iva27bi = 0;
		double iva27importe = 0;
		for(Concepto concepto : comprobante.getConceptos()){
			if(concepto.getTipoIva() == 3){
				iva0bi = iva0bi + concepto.getPrecio()*concepto.getCantidad();
				iva0importe = 0;
			}
			if(concepto.getTipoIva() == 4){
				iva105bi = iva105bi + concepto.getPrecio()*concepto.getCantidad();
				iva105importe = iva105importe + (concepto.getPrecio()*concepto.getCantidad())*0.105;
			}
			if(concepto.getTipoIva() == 5){
				iva21bi = iva21bi + concepto.getPrecio()*concepto.getCantidad();
				iva21importe = iva21importe + (concepto.getPrecio()*concepto.getCantidad())*0.21;
			}
			if(concepto.getTipoIva() == 6){
				iva27bi = iva27bi + concepto.getPrecio()*concepto.getCantidad();
				iva27importe = iva27importe + (concepto.getPrecio()*concepto.getCantidad())*0.27;
			}
		}
		List<AlicIva> alicuotasList = new ArrayList<AlicIva>();
		if(iva0bi>0)
			alicuotasList.add(new AlicIva(3,round(iva0bi,2), round(iva0importe,2)));
		if(iva105bi>0)
			alicuotasList.add(new AlicIva(4,round(iva105bi,2), round(iva105importe,2)));
		if(iva21bi>0)
			alicuotasList.add(new AlicIva(5,round(iva21bi,2), round(iva21importe,2)));
		if(iva27bi>0)
			alicuotasList.add(new AlicIva(6,round(iva27bi,2), round(iva27importe,2)));
		
		AlicIva[] alicIvas = new AlicIva[alicuotasList.size()];
		alicuotasList.toArray(alicIvas);
		
		return alicIvas;
	}
	
	public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
	
	public Boolean EnviarMail(String destinatario, File file){
		// Recipient's email ID needs to be mentioned.
        String to = destinatario;
        // Sender's email ID needs to be mentioned
        String from = "sghfacturacion@gmail.com";
        final String username = "sghfacturacion@gmail.com";//change accordingly
        final String password = "29332941";//change accordingly
        // Assuming you are sending email through relay.jangosmtp.net
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));
            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            // Set Subject: header field
            message.setSubject("Comprobante de estadia");
            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();
            // Now set the actual message
            messageBodyPart.setText("Se encuentra adjunto el comprobante de su estadia.");
            // Create a multipar message
            Multipart multipart = new MimeMultipart();
            // Set text message part
            multipart.addBodyPart(messageBodyPart);
            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            String filename = file.getAbsolutePath();
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(file.getName());
            multipart.addBodyPart(messageBodyPart);
            // Send the complete message parts
            message.setContent(multipart);
            // Send message
            Transport.send(message);
            System.out.println("Email Sent Successfully !!");
            return true;
        } catch (MessagingException e) {
            return false;
        }
	}
	
	public File GenerarPdf(Comprobante comprobante){
		
		ClassLoader classLoader = getClass().getClassLoader();
		Properties config = new Properties();
		try {
			java.io.File file = new java.io.File(classLoader.getResource("afip.properties").getFile());
			config.load(new FileInputStream(file));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String cuit = config.getProperty("CUITVendedor"); 
		String nombre = config.getProperty("NombreVendedor"); 
		String domicilio = config.getProperty("DomicilioVendedor"); 
		String localidad = config.getProperty("LocalidadVendedor"); 
		String telefono = config.getProperty("TelefonoVendedor"); 
		String condicionIVA = config.getProperty("CondicionIvaVendedor"); 
		String ingresosBrutos = config.getProperty("IngresosBrutosVendedor"); 
		String inicioDeActividades = config.getProperty("InicioDeActividadesVendedor"); 
		
		Vendedor vendedor = new Vendedor(cuit,nombre,domicilio,telefono,condicionIVA,ingresosBrutos,inicioDeActividades, localidad);
		
		String tipoComprobanteString = "";
		if(comprobante.esFacturaA()){
			tipoComprobanteString = "Factura_A";
        }
        if(comprobante.esFacturaB()){
        	tipoComprobanteString = "Factura_B";
        }
		
		String pathRaiz = classLoader.getResource("").getPath();
		String comprobantePath = pathRaiz+tipoComprobanteString+"_Nro_"+(comprobante.getNroComprobante())+".pdf";
		String barCodePath = pathRaiz+"cod.gif";
		String limpiadorPruebaPath = classLoader.getResource("SGH.png").getPath();

        String limpiadorPath = limpiadorPruebaPath;

        String codBarraPath = barCodePath;
        int cantidadCopias = 1;

        boolean isCreated = FacturaToPDF.ObtenerPDF(comprobantePath, limpiadorPath, codBarraPath, comprobante, vendedor, cantidadCopias,true);
		
        comprobantePath =  comprobantePath.replace(".pdf","_ORIGINAL.pdf");
        
		File file = new File(comprobantePath);
		return file;
	}

}