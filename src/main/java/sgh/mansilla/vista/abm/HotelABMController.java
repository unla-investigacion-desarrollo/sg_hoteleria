package sgh.mansilla.vista.abm;

import java.beans.PropertyEditorSupport;
import java.util.List;

import org.springframework.beans.SimpleTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import sgh.mansilla.modelo.datos.hotel.Habitacion;
import sgh.mansilla.modelo.datos.hotel.Hotel;
import sgh.mansilla.modelo.negocio.ABM;
import sgh.mansilla.modelo.negocio.hotel.HabitacionABM;

@Controller
@RequestMapping("/hotel")
//@SessionAttributes("habitacion")
public class HotelABMController extends AbstractABMController<Integer, Hotel> {

	@Autowired
	HabitacionABM habitacionABM;

	@Autowired
	@Qualifier("hotelABM")
	protected void setAbm(ABM<Integer, Hotel> abm) {
		super.setAbm(abm);
	}

	public HotelABMController() {
		super("abm/hotel");
	}

	//@ModelAttribute("habitacion")
	//public List<Habitacion> initializeProfiles() {
	//	return habitacionABM.listar();
	//}

	@Override
	protected Hotel createEntity() {
		return new Hotel();
	}

	/*
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Habitacion.class, new HabitacionEditor());
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

	}*/
}