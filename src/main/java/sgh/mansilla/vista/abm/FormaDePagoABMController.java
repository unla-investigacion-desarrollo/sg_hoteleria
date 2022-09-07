package sgh.mansilla.vista.abm;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sgh.mansilla.modelo.datos.facturacion.FormaDePago;
import sgh.mansilla.modelo.negocio.ABM;

@Controller
@RequestMapping("/formaDePago")
public class FormaDePagoABMController extends AbstractABMController<Integer, FormaDePago> {

	@Autowired
	@Qualifier("formaDePagoABM")
	protected void setAbm(ABM<Integer, FormaDePago> abm) {
		super.setAbm(abm);
	}

	public FormaDePagoABMController() {
		super("abm/formaDePago");
	}

	@Override
	protected FormaDePago createEntity() {
		return new FormaDePago();
	}
	

}