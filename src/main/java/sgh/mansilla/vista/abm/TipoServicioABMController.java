package sgh.mansilla.vista.abm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sgh.mansilla.modelo.datos.hotel.TipoServicio;
import sgh.mansilla.modelo.negocio.ABM;

@Controller
@RequestMapping("/tipoServicio")
public class TipoServicioABMController extends AbstractABMController<Integer, TipoServicio> {


	@Autowired
	@Qualifier("tipoServicioABM")
	protected void setAbm(ABM<Integer, TipoServicio> abm) {
		super.setAbm(abm);
	}

	public TipoServicioABMController() {
		super("abm/tipoServicio");
	}


	@Override
	protected TipoServicio createEntity() {
		return new TipoServicio();
	}

}