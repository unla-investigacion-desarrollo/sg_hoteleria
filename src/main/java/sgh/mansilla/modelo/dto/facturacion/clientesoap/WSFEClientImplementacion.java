package sgh.mansilla.modelo.dto.facturacion.clientesoap;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import org.apache.axis.AxisFault;

import sgh.mansilla.modelo.dto.facturacion.afip.FEAuthRequest;
import sgh.mansilla.modelo.dto.facturacion.afip.FECAERequest;
import sgh.mansilla.modelo.dto.facturacion.afip.FECAEResponse;
import sgh.mansilla.modelo.dto.facturacion.afip.Service;
import sgh.mansilla.modelo.dto.facturacion.afip.ServiceLocator;
import sgh.mansilla.modelo.dto.facturacion.afip.ServiceSoap;

public class WSFEClientImplementacion implements WSFEClient {

	public WSFEClientImplementacion(){
		
	}
	public FECAEResponse obtenerCAE(FEAuthRequest authRequest,FECAERequest fecaeRequest,String urlSolicitarCAE) throws SocketTimeoutException,AxisFault,UnknownHostException,Exception {
		// TODO Auto-generated method stub
		Service servicio = new ServiceLocator();
		
		ServiceSoap port = servicio.getServiceSoap();
		
		FECAEResponse fecaeResponse = port.FECAESolicitar(authRequest, fecaeRequest,urlSolicitarCAE);
		
		//FEDetResponse [] feDetResponses = fecaeResponse.getFeDetResp();
		
		return fecaeResponse;
		
	}



}
