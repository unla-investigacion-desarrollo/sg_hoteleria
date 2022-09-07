package sgh.mansilla.vista.abm;

import java.beans.PropertyEditorSupport;
import java.util.List;
import java.util.Set;

import org.springframework.beans.SimpleTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import sgh.mansilla.modelo.datos.hotel.Habitacion;
import sgh.mansilla.modelo.datos.hotel.EstadoHabitacion;
import sgh.mansilla.modelo.datos.hotel.TipoHabitacion;
import sgh.mansilla.modelo.datos.hotel.Hotel;
import sgh.mansilla.modelo.datos.hotel.CaracteristicaHabitacion;

import sgh.mansilla.modelo.negocio.ABM;
import sgh.mansilla.modelo.negocio.hotel.EstadoHabitacionABM;
import sgh.mansilla.modelo.negocio.hotel.TipoHabitacionABM;
import sgh.mansilla.modelo.negocio.hotel.HotelABM;
import sgh.mansilla.modelo.negocio.hotel.CaracteristicaHabitacionABM;

@Controller
@RequestMapping("/habitacion")
//@SessionAttributes(value = {"estadoHabitacion","tipoHabitacion","hotel","caracteristicaHabitacion"})
public class HabitacionABMController extends AbstractABMController<Integer, Habitacion> {

	@Autowired
	EstadoHabitacionABM estadoHabitacionABM;
	@Autowired
	TipoHabitacionABM tipoHabitacionABM;
	@Autowired
	HotelABM hotelABM;
	@Autowired
	CaracteristicaHabitacionABM caracteristicaHabitacionABM;


	@Autowired
	@Qualifier("habitacionABM")
	protected void setAbm(ABM<Integer, Habitacion> abm) {
		super.setAbm(abm);
	}

	public HabitacionABMController() {
		super("abm/habitacion");
	}


	@ModelAttribute("tipoHabitacion")
	public List<TipoHabitacion> initializeProfiles() {
		return tipoHabitacionABM.listar();
	}
	@ModelAttribute("estadoHabitacion")
	public List<EstadoHabitacion> initializeProfiles2() {
		return estadoHabitacionABM.listar();
	}

	@ModelAttribute("hotel")
	public List<Hotel> initializeProfiles3() {
		return hotelABM.listar();
	}
	@ModelAttribute("caracteristicaHabitacion")
	public List<CaracteristicaHabitacion> initializeProfiles4() {
		return caracteristicaHabitacionABM.listar();
	}


	@Override
	protected Habitacion createEntity() {
		return new Habitacion();
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(TipoHabitacion.class, new TipoHabitacionEditor());
		binder.registerCustomEditor(Hotel.class, new HotelEditor());
		binder.registerCustomEditor(EstadoHabitacion.class, new EstadoHabitacionEditor());

		binder.registerCustomEditor(Set.class, "caracteristicas", new CustomCollectionEditor(Set.class) {

			protected Object convertElement(Object element) {
				Integer id = null;
				if (element instanceof String) {
					id = Integer.parseInt((String) element);
				} else if (element instanceof Number) {
					id = ((Number) element).intValue();
				}

				return id != null ? caracteristicaHabitacionABM.buscarPorId(id) : null;
			}
		});
	}

	private class TipoHabitacionEditor extends PropertyEditorSupport {

		private SimpleTypeConverter typeConverter = new SimpleTypeConverter();

		@Override
		public void setAsText(String text) {
			if(text == null || 0 == text.length()) {
				setValue(null);
				return;
			}

			setValue(tipoHabitacionABM.buscarPorId(typeConverter.convertIfNecessary(text, Integer.class)));
		}
	}

	private class EstadoHabitacionEditor extends PropertyEditorSupport {

		private SimpleTypeConverter typeConverter = new SimpleTypeConverter();

		@Override
		public void setAsText(String text) {
			if(text == null || 0 == text.length()) {
				setValue(null);
				return;
			}

			setValue(estadoHabitacionABM.buscarPorId(typeConverter.convertIfNecessary(text, Integer.class)));
		}

	}

	private class HotelEditor extends PropertyEditorSupport {

		private SimpleTypeConverter typeConverter = new SimpleTypeConverter();

		@Override
		public void setAsText(String text) {
			if(text == null || 0 == text.length()) {
				setValue(null);
				return;
			}

			setValue(hotelABM.buscarPorId(typeConverter.convertIfNecessary(text, Integer.class)));
		}

	}
}