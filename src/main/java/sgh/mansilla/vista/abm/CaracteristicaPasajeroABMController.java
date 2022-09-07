package sgh.mansilla.vista.abm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sgh.mansilla.modelo.datos.persona.CaracteristicaPasajero;
import sgh.mansilla.modelo.negocio.ABM;

@Controller
@RequestMapping("/caracteristicaPasajero")
public class CaracteristicaPasajeroABMController extends AbstractABMController<Integer, CaracteristicaPasajero> {


	@Autowired
	@Qualifier("caracteristicaPasajeroABM")
	protected void setAbm(ABM<Integer, CaracteristicaPasajero> abm) {
		super.setAbm(abm);
	}

	public CaracteristicaPasajeroABMController() {
		super("abm/caracteristicaPasajero");
	}


	@Override
	protected CaracteristicaPasajero createEntity() {
		return new CaracteristicaPasajero();
	}

}