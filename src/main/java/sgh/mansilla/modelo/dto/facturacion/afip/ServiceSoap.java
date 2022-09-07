/**
 * ServiceSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package sgh.mansilla.modelo.dto.facturacion.afip;

import java.net.SocketTimeoutException;
import java.rmi.RemoteException;

public interface ServiceSoap extends java.rmi.Remote {

	
    /**
     * Solicitud de Código de Autorización Electrónico (CAE)
     * @param urlSolicitarCAE 
     * @throws SocketTimeoutException 
     */
    public FECAEResponse FECAESolicitar(FEAuthRequest auth, FECAERequest feCAEReq, String urlSolicitarCAE) throws java.rmi.RemoteException, SocketTimeoutException;

     /**
     * Metodo dummy para verificacion de funcionamiento
     */
    public DummyResponse FEDummy() throws java.rmi.RemoteException;

   /**
     * Consulta Comprobante emitido y su código.
     */
    public FECompConsultaResponse FECompConsultar(FEAuthRequest auth, FECompConsultaReq feCompConsReq,String urlSolicitar) throws java.rmi.RemoteException;

    public UltimoComprobante FECompUltimoAutorizado(FEAuthRequest auth,int ptoVta, int cbteTipo,String url) throws RemoteException ;
    	

}