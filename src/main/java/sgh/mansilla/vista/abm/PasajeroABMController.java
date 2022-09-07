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

import sgh.mansilla.modelo.datos.persona.TipoDocumento;
import sgh.mansilla.modelo.datos.persona.CaracteristicaPasajero;
import sgh.mansilla.modelo.datos.persona.Pasajero;
import sgh.mansilla.modelo.negocio.ABM;
import sgh.mansilla.modelo.negocio.persona.CaracteristicaPasajeroABM;
import sgh.mansilla.modelo.negocio.persona.TipoDocumentoABM;

@Controller
@RequestMapping("/pasajero")
//@SessionAttributes({"tipoDocumento","caracteristicaPasajero"})
public class PasajeroABMController extends AbstractABMController<Integer, Pasajero> {

	@Autowired
	TipoDocumentoABM tipoDocumentoABM;
	@Autowired
	CaracteristicaPasajeroABM caracteristicaPasajeroABM;

	@Autowired
	@Qualifier("pasajeroABM")
	protected void setAbm(ABM<Integer, Pasajero> abm) {
		super.setAbm(abm);
	}

	public PasajeroABMController() {
		super("abm/pasajero");
	}

	/**
	 * This method will provide tipoDocumento list to views
	 */
	@ModelAttribute("tipoDocumento")
	public List<TipoDocumento> initializeProfiles() {
		return tipoDocumentoABM.listar();
	}


	/**
	 * This method will provide CaracteristicasPasajero list to views
	 */
	@ModelAttribute("caracteristicaPasajero")
	public List<CaracteristicaPasajero> initializeProfiles2() {
		return caracteristicaPasajeroABM.listar();
	}

	@Override
	protected Pasajero createEntity() {
		return new Pasajero();
	}

	@InitBinder
    public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "fechaDeNacimiento", new CustomDateEditor(dateFormat, true));

		binder.registerCustomEditor(TipoDocumento.class, new TipoDocumentoEditor());

		binder.registerCustomEditor(Set.class, "caracteristicas", new CustomCollectionEditor(Set.class) {

			protected Object convertElement(Object element) {
				Integer id = null;
				if (element instanceof String) {
					id = Integer.parseInt((String) element);
				} else if (element instanceof Number) {
					id = ((Number) element).intValue();
				}

				return id != null ? caracteristicaPasajeroABM.buscarPorId(id) : null;
			}
		});
	}

	private class TipoDocumentoEditor extends PropertyEditorSupport {

		private SimpleTypeConverter typeConverter = new SimpleTypeConverter();

		@Override
		public void setAsText(String text) {
			if(text == null || 0 == text.length()) {
				setValue(null);
				return;
			}

			setValue(tipoDocumentoABM.buscarPorId(typeConverter.convertIfNecessary(text, Integer.class)));
		}

	}


}