package sgh.mansilla.modelo.dto.facturacion.clientesoap;

import sgh.mansilla.modelo.dto.facturacion.afip.FEAuthRequest;
import sgh.mansilla.modelo.dto.facturacion.afip.FECAERequest;
import sgh.mansilla.modelo.dto.facturacion.afip.FECAEResponse;


public interface WSFEClient {
	
	public FECAEResponse obtenerCAE(FEAuthRequest authRequest,FECAERequest fecaeRequest,String urlSolicitarCAE) throws Exception;
	
}
