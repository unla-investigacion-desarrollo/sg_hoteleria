package sgh.mansilla.vista.sistema;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sgh.mansilla.modelo.datos.estadia.Estadia;
import sgh.mansilla.modelo.datos.estadia.EstadoEstadia;
import sgh.mansilla.modelo.datos.hotel.Habitacion;
import sgh.mansilla.modelo.negocio.estadia.EstadiaABM;
import sgh.mansilla.modelo.negocio.estadia.EstadoEstadiaABM;
import sgh.mansilla.modelo.negocio.estadia.PasajeroEstadiaABM;
import sgh.mansilla.modelo.negocio.hotel.HabitacionABM;
import sgh.mansilla.modelo.negocio.persona.PasajeroABM;
import sgh.mansilla.modelo.negocio.sistema.Ocupacion;
import sgh.mansilla.modelo.negocio.sistema.VistaOcupacion;

@Controller
@RequestMapping("/panelOcupacion")

public class PanelOcupacionController {

	private static final String FORMATO_CAMPO_FECHA = "yyyy-MM-dd";

	private static final String DATE_FORMAT = "dd/MM/yyyy";

	@Autowired
	EstadiaABM estadiaABM;

	@Autowired
	HabitacionABM habitacionABM;

	@Autowired
	PasajeroABM pasajeroABM;

	@Autowired
	PasajeroEstadiaABM pasajeroEstadiaABM;

	@Autowired
	EstadoEstadiaABM estadoEstadiaABM;

	@Autowired
	protected MessageSource messageSource;

	protected Logger logger = LoggerFactory.getLogger(this.getClass());


	/**
	 * This method will list all existing users.
	 *
	 * @throws ParseException
	 */
	@RequestMapping(value = { "/", "/ocupacion" }, method = RequestMethod.GET)
	public String listEntities(ModelMap model, @RequestParam(required = false) Date desde,
			@RequestParam(required = false) Date hasta) throws ParseException {

		if((desde != null) && (hasta.before(desde))){
			Calendar nuevoHasta = Calendar.getInstance();
			nuevoHasta.setTime(desde);
			nuevoHasta.add(Calendar.DAY_OF_MONTH, 15);
			hasta = nuevoHasta.getTime();
		}

		desde = definirFecha(desde, -2);
		hasta = definirFecha(hasta, 15);

		ArrayList<Estadia> estadias = (ArrayList<Estadia>) estadiaABM.listar();
		ArrayList<Habitacion> habitaciones = (ArrayList<Habitacion>) habitacionABM.listar();
		ArrayList<VistaOcupacion> ocupaciones = new ArrayList<VistaOcupacion>();

		ArrayList<String> fechasString = armarColumnas(desde, hasta);

		for (int auxHab = 0; auxHab < habitaciones.size(); auxHab++) {
			Habitacion habitacion = habitaciones.get(auxHab);
			VistaOcupacion vistaOcupacion = new VistaOcupacion(habitacion);
			for (int auxFechas = 1; auxFechas < fechasString.size(); auxFechas++) {
				Calendar fecha = interpretarFecha(fechasString.get(auxFechas));

				for (int auxEstadia = 0; auxEstadia < estadias.size(); auxEstadia++) {

					Estadia estadia = estadias.get(auxEstadia);

					String informacion = "Estadia Nro: "+ estadia.getIdEstadia() +
							" (Desde:" + estadia.getDiaCheckIn().toString()+", Hasta: " +
							 estadia.getDiaCheckOut().toString() +")";
					String color = estadia.getEstadoEstadia().getColor();
					//Calendar desdeEstadia = Calendar.getInstance();
					//desdeEstadia.setTime(estadia.getDiaCheckIn());
					//Calendar hastaEstadia = Calendar.getInstance();
					//hastaEstadia.setTime(estadia.getDiaCheckOut());

					ArrayList<Habitacion> habitacionesPE = (ArrayList<Habitacion>) pasajeroEstadiaABM
							.listarHabitacionesPorEstadiayFecha(estadiaABM.buscarPorId(estadia.getIdEstadia()), fecha);

					for (int auxHabPE = 0; auxHabPE < habitacionesPE.size(); auxHabPE++) {
						if (vistaOcupacion.getHabitacion().getId() == habitacionesPE.get(auxHabPE).getIdHabitacion()) {

							if(estadia.getEstadoEstadia().getIdEstadoEstadia() != EstadoEstadia.CANCELADA){
								vistaOcupacion.addOcupacion(
										new Ocupacion(estadia.getIdEstadia(), estadia.getEstadoEstadia().getEstado(), fecha,
												auxFechas, informacion, color));

							}

						}
					}
				}
			}
			ocupaciones.add(vistaOcupacion);
		}

		// Recorro todas las habitaciones

		SimpleDateFormat formatter = new SimpleDateFormat(FORMATO_CAMPO_FECHA);
		model.addAttribute("desde", formatter.format(desde));
		model.addAttribute("hasta", formatter.format(hasta));


		model.addAttribute("vista", ocupaciones);
		model.addAttribute("fechas", fechasString);
		model.addAttribute("loggedinuser", getPrincipal());

		return "/panelOcupacion";
	}

	private Date definirFecha(Date fecha, int desplazamientoPorDefecto) {
		if (fecha == null) {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_MONTH, desplazamientoPorDefecto);
			fecha = calendar.getTime();
		}
		return fecha;
	}


	public ArrayList<String> armarColumnas(Date armarDesde, Date armarHasta) {
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
		ArrayList<String> fechasString = new ArrayList<String>();
		fechasString.add("        ");

		Calendar fechaAux = Calendar.getInstance();
		fechaAux.setTime(armarDesde);
		while (!fechaAux.getTime().after(armarHasta)) {
			fechasString.add(formatter.format(fechaAux.getTime()));
			fechaAux.add(Calendar.DAY_OF_MONTH, 1);
		}

		return fechasString;

	}

	public Calendar interpretarFecha(String fecha) throws ParseException {
		Calendar fechaCalendar = null;
		if (fecha != null) {
			SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
			Date date = formatter.parse(fecha);
			fechaCalendar = Calendar.getInstance();
			fechaCalendar.setTime(date);
		}

		return fechaCalendar;

	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(FORMATO_CAMPO_FECHA);
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	/**
	 * This method returns the principal[user-name] of logged-in user.
	 */
	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

}
