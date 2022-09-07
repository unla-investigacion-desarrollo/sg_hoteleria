package sgh.mansilla.vista.abm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sgh.mansilla.modelo.datos.estadia.EstadoEstadia;
import sgh.mansilla.modelo.negocio.ABM;

@Controller
@RequestMapping("/estadoEstadia")
public class EstadoEstadiaABMController extends AbstractABMController<Integer, EstadoEstadia> {


	@Autowired
	@Qualifier("estadoEstadiaABM")
	protected void setAbm(ABM<Integer, EstadoEstadia> abm) {
		super.setAbm(abm);
	}

	public EstadoEstadiaABMController() {
		super("abm/estadoEstadia");
	}


	@Override
	protected EstadoEstadia createEntity() {
		return new EstadoEstadia();
	}

}