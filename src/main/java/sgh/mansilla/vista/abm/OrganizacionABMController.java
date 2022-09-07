package sgh.mansilla.vista.abm;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sgh.mansilla.modelo.datos.persona.Organizacion;
import sgh.mansilla.modelo.negocio.ABM;

@Controller
@RequestMapping("/organizacion")
public class OrganizacionABMController extends AbstractABMController<Integer, Organizacion> {

	@Autowired
	@Qualifier("organizacionABM")
	protected void setAbm(ABM<Integer, Organizacion> abm) {
		super.setAbm(abm);
	}

	public OrganizacionABMController() {
		super("abm/organizacion");
	}


	@Override
	protected Organizacion createEntity() {
		return new Organizacion();
	}



}