package sgh.mansilla.vista.abm;

import java.beans.PropertyEditorSupport;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.SimpleTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import sgh.mansilla.modelo.datos.estadia.Estadia;
import sgh.mansilla.modelo.datos.estadia.EstadoEstadia;
import sgh.mansilla.modelo.datos.estadia.PasajeroEstadia;
import sgh.mansilla.modelo.datos.hotel.CaracteristicaHabitacion;
import sgh.mansilla.modelo.datos.hotel.Hotel;
import sgh.mansilla.modelo.datos.hotel.PlanAlojamiento;
import sgh.mansilla.modelo.datos.hotel.TipoHabitacion;
import sgh.mansilla.modelo.datos.persona.Pasajero;
import sgh.mansilla.modelo.negocio.ABM;
import sgh.mansilla.modelo.negocio.estadia.EstadoEstadiaABM;
import sgh.mansilla.modelo.negocio.estadia.PasajeroEstadiaABM;
import sgh.mansilla.modelo.negocio.hotel.PlanAlojamientoABM;
import sgh.mansilla.modelo.negocio.hotel.TipoHabitacionABM;

@Controller
@RequestMapping("/estadia")
public class EstadiaABMController extends AbstractABMController<Integer, Estadia> {


	@Autowired
	EstadoEstadiaABM estadoEstadiaABM;
	@Autowired
	PlanAlojamientoABM planAlojamientoABM;
	@Autowired
	PasajeroEstadiaABM pasajeroEstadiaABM;

	@Autowired
	@Qualifier("estadiaABM")
	protected void setAbm(ABM<Integer, Estadia> abm) {
		super.setAbm(abm);
	}

	public EstadiaABMController() {
		super("abm/estadia");
	}


	@Override
	protected Estadia createEntity() {
		return new Estadia();
	}

	@ModelAttribute("planAlojamiento")
	public List<PlanAlojamiento> initializeProfiles() {
		return planAlojamientoABM.listar();
	}


	@ModelAttribute("estadoEstadia")
	public List<EstadoEstadia> initializeProfiles2() {
		return estadoEstadiaABM.listar();
	}

	@ModelAttribute("pasajeroEstadia")
	public List<PasajeroEstadia> initializeProfiles3() {
		return pasajeroEstadiaABM.listar();
	}

	@Override
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listEntities(ModelMap model) {

		List<Estadia> entities = abm.listar();
		List<PasajeroEstadia> pasajeros = pasajeroEstadiaABM.listar();

		List<PasajeroConEstadia> pasajerosFiltrados = filtrarPasajeros(entities, pasajeros);



		logger.info("Tengo {} usuarios registrados", entities.size());

		logger.info("Tengo {} usuarios filtrados", pasajerosFiltrados.size());

		model.addAttribute("entities", entities);
		model.addAttribute("pasajeros", pasajeros);
		model.addAttribute("pasajerosfiltrados", pasajerosFiltrados);

		model.addAttribute("loggedinuser", getPrincipal());

		return viewBaseLocation + "/list";
	}

	List<PasajeroConEstadia> filtrarPasajeros(List<Estadia> entities, List<PasajeroEstadia> pasajeros){
		List<PasajeroConEstadia> filtrado = new ArrayList<PasajeroConEstadia>();
		for (Estadia e: entities) {

			PasajeroConEstadia pasajerosEnEstadia = new PasajeroConEstadia(e.getIdEstadia());
			HashSet<Pasajero> pasajerosFiltrados = new HashSet<Pasajero>();

			for (PasajeroEstadia p: pasajeros)
			{
				if(e.getIdEstadia() == p.getEstadia().getIdEstadia()){
					pasajerosFiltrados.add(p.getPasajero());
				}
			}
			pasajerosEnEstadia.pasajerosConEstadia = pasajerosFiltrados;
			filtrado.add(pasajerosEnEstadia);
		}
		return filtrado;
	}

	public class PasajeroConEstadia{
		private HashSet<Pasajero> pasajerosConEstadia;
		private int idEstadia;

		PasajeroConEstadia(){};


		PasajeroConEstadia(int idEstadia){
			this.idEstadia = idEstadia;
		}

		public HashSet<Pasajero> getPasajerosConEstadia() {
			return pasajerosConEstadia;
		}

		public void setPasajerosConEstadia(HashSet<Pasajero> pasajerosConEstadia) {
			this.pasajerosConEstadia = pasajerosConEstadia;
		}

		public int getIdEstadia() {
			return idEstadia;
		}

		public void setIdEstadia(int idEstadia) {
			this.idEstadia = idEstadia;
		}
	}

	@InitBinder
    public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "diaCheckIn", new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(Date.class, "diaCheckOut", new CustomDateEditor(dateFormat, true));

		binder.registerCustomEditor(PlanAlojamiento.class, new PlanAlojamientoEditor());
		binder.registerCustomEditor(EstadoEstadia.class, new EstadoEstadiaEditor());
		binder.registerCustomEditor(PasajeroEstadia.class, new PasajeroEstadiaEditor());


    }

	private class PasajeroEstadiaEditor extends PropertyEditorSupport {

		private SimpleTypeConverter typeConverter = new SimpleTypeConverter();

		@Override
		public void setAsText(String text) {
			if (text == null || 0 == text.length()) {
				setValue(null);
				return;
			}

			setValue(pasajeroEstadiaABM.buscarPorId(typeConverter.convertIfNecessary(text, Integer.class)));
		}
	}

	private class PlanAlojamientoEditor extends PropertyEditorSupport {

		private SimpleTypeConverter typeConverter = new SimpleTypeConverter();

		@Override
		public void setAsText(String text) {
			if (text == null || 0 == text.length()) {
				setValue(null);
				return;
			}

			setValue(planAlojamientoABM.buscarPorId(typeConverter.convertIfNecessary(text, Integer.class)));
		}
	}

	private class EstadoEstadiaEditor extends PropertyEditorSupport {

		private SimpleTypeConverter typeConverter = new SimpleTypeConverter();

		@Override
		public void setAsText(String text) {
			if (text == null || 0 == text.length()) {
				setValue(null);
				return;
			}

			setValue(estadoEstadiaABM.buscarPorId(typeConverter.convertIfNecessary(text, Integer.class)));
		}
	}

}