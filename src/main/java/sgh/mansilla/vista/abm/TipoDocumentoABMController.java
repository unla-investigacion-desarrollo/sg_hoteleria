package sgh.mansilla.vista.abm;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sgh.mansilla.modelo.datos.persona.TipoDocumento;
import sgh.mansilla.modelo.negocio.ABM;

@Controller
@RequestMapping("/tipoDocumento")
public class TipoDocumentoABMController extends AbstractABMController<Integer, TipoDocumento> {

	@Autowired
	@Qualifier("tipoDocumentoABM")
	protected void setAbm(ABM<Integer, TipoDocumento> abm) {
		super.setAbm(abm);
	}

	public TipoDocumentoABMController() {
		super("abm/tipoDocumento");
	}

	@Override
	protected TipoDocumento createEntity() {
		return new TipoDocumento();
	}


}