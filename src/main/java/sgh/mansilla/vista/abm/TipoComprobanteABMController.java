package sgh.mansilla.vista.abm;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sgh.mansilla.modelo.datos.facturacion.TipoComprobante;
import sgh.mansilla.modelo.negocio.ABM;

@Controller
@RequestMapping("/tipoComprobante")
public class TipoComprobanteABMController extends AbstractABMController<Integer, TipoComprobante> {

	@Autowired
	@Qualifier("tipoComprobanteABM")
	protected void setAbm(ABM<Integer, TipoComprobante> abm) {
		super.setAbm(abm);
	}

	public TipoComprobanteABMController() {
		super("abm/tipoComprobante");
	}

	@Override
	protected TipoComprobante createEntity() {
		return new TipoComprobante();
	}
	

}