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

import sgh.mansilla.modelo.datos.hotel.Servicio;
import sgh.mansilla.modelo.datos.hotel.TipoServicio;

import sgh.mansilla.modelo.negocio.ABM;
import sgh.mansilla.modelo.negocio.hotel.TipoServicioABM;

@Controller
@RequestMapping("/servicio")
//@SessionAttributes(value = {"estadoHabitacion","tipoHabitacion","hotel","caracteristicaHabitacion"})
public class ServicioABMController extends AbstractABMController<Integer, Servicio> {

	@Autowired
	TipoServicioABM tipoServicioABM;

	@Autowired
	@Qualifier("servicioABM")
	protected void setAbm(ABM<Integer, Servicio> abm) {
		super.setAbm(abm);
	}

	public ServicioABMController() {
		super("abm/servicio");
	}


	@ModelAttribute("tipoServicio")
	public List<TipoServicio> initializeProfiles() {
		return tipoServicioABM.listar();
	}

	@Override
	protected Servicio createEntity() {
		return new Servicio();
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(TipoServicio.class, new TipoServicioEditor());
	}

	private class TipoServicioEditor extends PropertyEditorSupport {

		private SimpleTypeConverter typeConverter = new SimpleTypeConverter();

		@Override
		public void setAsText(String text) {
			if(text == null || 0 == text.length()) {
				setValue(null);
				return;
			}

			setValue(tipoServicioABM.buscarPorId(typeConverter.convertIfNecessary(text, Integer.class)));
		}
	}

}