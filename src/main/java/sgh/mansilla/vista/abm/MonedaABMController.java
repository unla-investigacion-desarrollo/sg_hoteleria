package sgh.mansilla.vista.abm;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sgh.mansilla.modelo.datos.facturacion.Moneda;
import sgh.mansilla.modelo.negocio.ABM;

@Controller
@RequestMapping("/moneda")
public class MonedaABMController extends AbstractABMController<Integer, Moneda> {

	@Autowired
	@Qualifier("monedaABM")
	protected void setAbm(ABM<Integer, Moneda> abm) {
		super.setAbm(abm);
	}

	public MonedaABMController() {
		super("abm/moneda");
	}

	@Override
	protected Moneda createEntity() {
		return new Moneda();
	}
	

}