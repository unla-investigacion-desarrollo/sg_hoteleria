package sgh.mansilla.vista.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sgh.mansilla.modelo.datos.estadia.Estadia;
import sgh.mansilla.modelo.datos.estadia.PasajeroEstadia;
import sgh.mansilla.modelo.datos.hotel.Habitacion;
import sgh.mansilla.modelo.datos.usuario.User;
import sgh.mansilla.modelo.negocio.estadia.EstadiaABM;
import sgh.mansilla.modelo.negocio.estadia.EstadoEstadiaABM;
import sgh.mansilla.modelo.negocio.estadia.PasajeroEstadiaABM;
import sgh.mansilla.modelo.negocio.hotel.HabitacionABM;
import sgh.mansilla.modelo.negocio.persona.PasajeroABM;
import sgh.mansilla.modelo.negocio.sistema.Ocupacion;
import sgh.mansilla.modelo.negocio.sistema.VistaOcupacion;
import sgh.mansilla.modelo.negocio.sistema.VistaOcupacionHabitacion;

// abre en pag http://localhost:8080/ProyectoSGHRomina/test/

@Controller
@RequestMapping("/test")
//@SessionAttributes({"operatorId", "searchForm"})
public class TestController {

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
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/", "/ocupacion" }, method = RequestMethod.POST)
	public String saveUser(@ModelAttribute VistaOcupacion vistaOcupacion, BindingResult result, ModelMap model) {

		model.addAttribute("success",
				"User registered successfully");
		model.addAttribute("loggedinuser", getPrincipal());
		return "registrationsuccess";
	}

	/**
	 * This method will list all existing users.
	 * @throws ParseException
	 */
	@RequestMapping(value = { "/", "/ocupacion" }, method = RequestMethod.GET)
	public String listEntities(ModelMap model) throws ParseException{

		Calendar desde = new GregorianCalendar();
		desde.set(2017, 00, 1);
		Calendar auxDesde = new GregorianCalendar();
		auxDesde.set(2017, 00, 1);

		Calendar hasta = new GregorianCalendar();
		hasta.set(2017,00, 15);
		Calendar auxHasta = new GregorianCalendar();
		auxHasta.set(2017,00, 15);

		ArrayList<Estadia> estadias = (ArrayList<Estadia>) estadiaABM.listar();
		ArrayList<Habitacion> habitaciones = (ArrayList<Habitacion>) habitacionABM.listar();
		ArrayList<VistaOcupacion> ocupaciones = new ArrayList<VistaOcupacion>();

		ArrayList<String> fechasString = armarColumnas(desde, hasta);


		for(int auxHab = 0; auxHab < habitaciones.size(); auxHab++){
			Habitacion habitacion = habitaciones.get(auxHab);
			VistaOcupacion vistaOcupacion = new VistaOcupacion(habitacion);
			for (int auxFechas = 1;auxFechas<fechasString.size();auxFechas++){
				Calendar fecha = volverStringAcalendar(fechasString.get(auxFechas));

				for (int auxEstadia = 0; auxEstadia < estadias.size(); auxEstadia++) {

					Estadia estadia = estadias.get(auxEstadia);

					Calendar desdeEstadia = Calendar.getInstance();
					desdeEstadia.setTime(estadia.getDiaCheckIn());
					Calendar hastaEstadia = Calendar.getInstance();
					hastaEstadia.setTime(estadia.getDiaCheckOut());


					ArrayList<Habitacion> habitacionesPE =
							(ArrayList<Habitacion>) pasajeroEstadiaABM.listarHabitacionesPorEstadiayFecha(estadiaABM.buscarPorId(estadia.getIdEstadia()),fecha);

					for(int auxHabPE = 0; auxHabPE<habitacionesPE.size();auxHabPE++){
						if(vistaOcupacion.getHabitacion().getId() == habitacionesPE.get(auxHabPE).getIdHabitacion()){
							vistaOcupacion.addOcupacion(
									new Ocupacion(estadia.getIdEstadia(), estadia.getEstadoEstadia().getEstado(),
											fecha, auxFechas, desdeEstadia, hastaEstadia));

						}
					}
				}
			}
			ocupaciones.add(vistaOcupacion);
		}

		// Recorro todas las habitaciones


		model.addAttribute("vista", ocupaciones);
		model.addAttribute("fechas", fechasString);
		model.addAttribute("loggedinuser", getPrincipal());

		return "/test";
	}


	public ArrayList<String> armarColumnas(Calendar armarDesde, Calendar armarHasta){

		ArrayList<String> fechasString = new ArrayList<String>();
		fechasString.add("        ");

		while( !armarDesde.after(armarHasta)){
			fechasString.add(armarStringFecha(armarDesde));
			armarDesde.add(Calendar.DAY_OF_MONTH, 1);
		}

	  return fechasString;

}

	public String armarStringFecha(Calendar fecha){

		    String fechaString = "";
		    if (fecha.get(Calendar.DAY_OF_MONTH)<10){
		    	fechaString += "0"+ fecha.get(Calendar.DAY_OF_MONTH)+"-";
		    } else{
		    	fechaString += fecha.get(Calendar.DAY_OF_MONTH)+"-";
		    }

		    if ((fecha.get(Calendar.MONTH) + 1)<10){
		    	fechaString += "0"+ (fecha.get(Calendar.MONTH) + 1)+"-";
		    } else{
		    	fechaString += (fecha.get(Calendar.MONTH) + 1)+"-";
		    }
		    fechaString += fecha.get(Calendar.YEAR);

		  return fechaString;

	}

	public Calendar volverStringAcalendar(String fecha) throws ParseException{

	    DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
		Date date = formatter.parse(fecha);
		Calendar fechaCalendar = Calendar.getInstance();
		fechaCalendar.setTime(date);
		//fechaCalendar.add(Calendar.MONTH), 1);

	  return fechaCalendar;

}


	@InitBinder
    public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
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