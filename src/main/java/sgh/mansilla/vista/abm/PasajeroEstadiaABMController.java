package sgh.mansilla.vista.abm;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.List;

import org.springframework.beans.SimpleTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import sgh.mansilla.modelo.datos.estadia.Estadia;
import sgh.mansilla.modelo.datos.estadia.PasajeroEstadia;
import sgh.mansilla.modelo.datos.hotel.Habitacion;
import sgh.mansilla.modelo.datos.persona.Pasajero;
import sgh.mansilla.modelo.negocio.ABM;
import sgh.mansilla.modelo.negocio.estadia.EstadiaABM;
import sgh.mansilla.modelo.negocio.hotel.HabitacionABM;
import sgh.mansilla.modelo.negocio.persona.PasajeroABM;

@Controller
@RequestMapping("/pasajeroEstadia")
public class PasajeroEstadiaABMController extends AbstractABMController<Integer, PasajeroEstadia> {

	@Autowired
	EstadiaABM estadiaABM;

	@Autowired
	PasajeroABM pasajeroABM;

	@Autowired
	HabitacionABM habitacionABM;

	@Autowired
	@Qualifier("pasajeroEstadiaABM")
	protected void setAbm(ABM<Integer, PasajeroEstadia> abm) {
		super.setAbm(abm);
	}

	public PasajeroEstadiaABMController() {
		super("abm/pasajeroEstadia");
	}

	/**
	 * This method will provide Estadia list to views
	 */
	@ModelAttribute("estadia")
	public List<Estadia> initializeProfiles() {
		return estadiaABM.listar();
	}

	/**
	 * This method will provide Pasajero list to views
	 */
	@ModelAttribute("pasajero")
	public List<Pasajero> initializeProfiles2() {
		return pasajeroABM.listar();
	}

	/**
	 * This method will provide Habitacion list to views
	 */
	@ModelAttribute("habitacion")
	public List<Habitacion> initializeProfiles3(@RequestParam(required = false) Integer idEstadia,
			@RequestParam(required = false) Integer idPE) {
		if (idPE == null){
			return habitacionABM.listarHabitacionesLibresPorEstadia(idEstadia);
		} else{
			return habitacionABM.listarHabitacionesLibresPorEstadiayPE(idEstadia, idPE);
		}

	}

	@Override
	protected PasajeroEstadia createEntity() {
		return new PasajeroEstadia();
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Estadia.class, new EstadiaEditor());
		binder.registerCustomEditor(Pasajero.class, new PasajeroEditor());
		binder.registerCustomEditor(Habitacion.class, new HabitacionEditor());
	}

	private class EstadiaEditor extends PropertyEditorSupport {

		private SimpleTypeConverter typeConverter = new SimpleTypeConverter();

		@Override
		public void setAsText(String text) {
			if(text == null || 0 == text.length()) {
				setValue(null);
				return;
			}

			setValue(estadiaABM.buscarPorId(typeConverter.convertIfNecessary(text, Integer.class)));
		}

	}


	private class PasajeroEditor extends PropertyEditorSupport {

		private SimpleTypeConverter typeConverter = new SimpleTypeConverter();

		@Override
		public void setAsText(String text) {
			if(text == null || 0 == text.length()) {
				setValue(null);
				return;
			}

			setValue(pasajeroABM.buscarPorId(typeConverter.convertIfNecessary(text, Integer.class)));
		}

	}


	private class HabitacionEditor extends PropertyEditorSupport {

		private SimpleTypeConverter typeConverter = new SimpleTypeConverter();

		@Override
		public void setAsText(String text) {
			if(text == null || 0 == text.length()) {
				setValue(null);
				return;
			}

			setValue(habitacionABM.buscarPorId(typeConverter.convertIfNecessary(text, Integer.class)));
		}

	}

}