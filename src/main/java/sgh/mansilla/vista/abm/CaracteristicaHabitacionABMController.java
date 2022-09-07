package sgh.mansilla.vista.abm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sgh.mansilla.modelo.datos.hotel.CaracteristicaHabitacion;
import sgh.mansilla.modelo.negocio.ABM;

@Controller
@RequestMapping("/caracteristicaHabitacion")
public class CaracteristicaHabitacionABMController extends AbstractABMController<Integer, CaracteristicaHabitacion> {


	@Autowired
	@Qualifier("caracteristicaHabitacionABM")
	protected void setAbm(ABM<Integer, CaracteristicaHabitacion> abm) {
		super.setAbm(abm);
	}

	public CaracteristicaHabitacionABMController() {
		super("abm/caracteristicaHabitacion");
	}


	@Override
	protected CaracteristicaHabitacion createEntity() {
		return new CaracteristicaHabitacion();
	}

}