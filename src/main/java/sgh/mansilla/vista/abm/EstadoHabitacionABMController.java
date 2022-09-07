package sgh.mansilla.vista.abm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sgh.mansilla.modelo.datos.hotel.EstadoHabitacion;
import sgh.mansilla.modelo.negocio.ABM;

@Controller
@RequestMapping("/estadoHabitacion")
public class EstadoHabitacionABMController extends AbstractABMController<Integer, EstadoHabitacion> {


	@Autowired
	@Qualifier("estadoHabitacionABM")
	protected void setAbm(ABM<Integer, EstadoHabitacion> abm) {
		super.setAbm(abm);
	}

	public EstadoHabitacionABMController() {
		super("abm/estadoHabitacion");
	}


	@Override
	protected EstadoHabitacion createEntity() {
		return new EstadoHabitacion();
	}

}