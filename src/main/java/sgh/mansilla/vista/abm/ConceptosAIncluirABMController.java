package sgh.mansilla.vista.abm;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sgh.mansilla.modelo.datos.facturacion.ConceptosAIncluir;
import sgh.mansilla.modelo.negocio.ABM;

@Controller
@RequestMapping("/conceptosAIncluir")
public class ConceptosAIncluirABMController extends AbstractABMController<Integer, ConceptosAIncluir> {

	@Autowired
	@Qualifier("conceptosAIncluirABM")
	protected void setAbm(ABM<Integer, ConceptosAIncluir> abm) {
		super.setAbm(abm);
	}

	public ConceptosAIncluirABMController() {
		super("abm/conceptosAIncluir");
	}

	@Override
	protected ConceptosAIncluir createEntity() {
		return new ConceptosAIncluir();
	}
	

}