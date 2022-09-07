package sgh.mansilla.vista.abm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sgh.mansilla.modelo.datos.hotel.TipoHabitacion;
import sgh.mansilla.modelo.negocio.ABM;

@Controller
@RequestMapping("/tipoHabitacion")
public class TipoHabitacionABMController extends AbstractABMController<Integer, TipoHabitacion> {


	@Autowired
	@Qualifier("tipoHabitacionABM")
	protected void setAbm(ABM<Integer, TipoHabitacion> abm) {
		super.setAbm(abm);
	}

	public TipoHabitacionABMController() {
		super("abm/tipoHabitacion");
	}


	@Override
	protected TipoHabitacion createEntity() {
		return new TipoHabitacion();
	}

}