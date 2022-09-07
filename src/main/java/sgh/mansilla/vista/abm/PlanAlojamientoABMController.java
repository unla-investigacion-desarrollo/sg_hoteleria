package sgh.mansilla.vista.abm;


import java.beans.PropertyEditorSupport;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.List;

import org.springframework.beans.SimpleTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import sgh.mansilla.modelo.datos.hotel.Servicio;
import sgh.mansilla.modelo.datos.hotel.PlanAlojamiento;
import sgh.mansilla.modelo.datos.persona.Pasajero;
import sgh.mansilla.modelo.negocio.ABM;
import sgh.mansilla.modelo.negocio.hotel.ServicioABM;

@Controller
@RequestMapping("/planAlojamiento")
//@SessionAttributes({"tipoDocumento","caracteristicaPasajero"})
public class PlanAlojamientoABMController extends AbstractABMController<Integer, PlanAlojamiento> {

	@Autowired
	ServicioABM servicioABM;

	@Autowired
	@Qualifier("planAlojamientoABM")
	protected void setAbm(ABM<Integer, PlanAlojamiento> abm) {
		super.setAbm(abm);
	}

	public PlanAlojamientoABMController() {
		super("abm/planAlojamiento");
	}

	/**
	 * This method will provide Servicio list to views
	 */
	@ModelAttribute("lstServicio")
	public List<Servicio> initializeProfiles2() {
		return servicioABM.listar();
	}

	@Override
	protected PlanAlojamiento createEntity() {
		return new PlanAlojamiento();
	}

	@InitBinder
    public void initBinder(WebDataBinder binder) {

		binder.registerCustomEditor(Set.class, "lstServicio", new CustomCollectionEditor(Set.class) {

			protected Object convertElement(Object element) {
				Integer id = null;
				if (element instanceof String) {
					id = Integer.parseInt((String) element);
				} else if (element instanceof Number) {
					id = ((Number) element).intValue();
				}

				return id != null ? servicioABM.buscarPorId(id) : null;
			}
		});
	}



}