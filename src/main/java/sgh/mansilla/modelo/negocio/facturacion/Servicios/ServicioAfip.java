package sgh.mansilla.modelo.negocio.facturacion.Servicios;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.axis.AxisFault;

import sgh.mansilla.modelo.dto.facturacion.ComprobanteDTO;
import sgh.mansilla.modelo.dto.facturacion.TicketAcceso;
import sgh.mansilla.modelo.dto.facturacion.afip.ErrorAfip;
import sgh.mansilla.modelo.dto.facturacion.afip.Observacion;
import sgh.mansilla.modelo.datos.facturacion.RespuestaAFIP;
import sgh.mansilla.modelo.datos.facturacion.RespuestaProcesarFactura;

public class ServicioAfip {
	
	String endpoint;
	String urlSolicitarCAE;
	String service;
	String dstDN;
	String p12file;
	String signer;
    String p12pass;
	Long ticketTime;
    Long CUITVendedor;
    
    public ServicioAfip(){
    	Properties config = new Properties();
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			java.io.File file = new java.io.File(classLoader.getResource("afip.properties").getFile());
			config.load(new FileInputStream(file));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.endpoint = config.getProperty("endpoint"); 
		this.urlSolicitarCAE = config.getProperty("urlSolicitarCAE"); 
		this.service = config.getProperty("service"); 
		this.dstDN = config.getProperty("dstdn"); 
		this.p12file = config.getProperty("keystore"); 
		this.signer = config.getProperty("keystore-signer"); 
		this.p12pass = config.getProperty("keystore-password"); 
		this.ticketTime = Long.parseLong(config.getProperty("TicketTime"));
		this.CUITVendedor = Long.parseLong(config.getProperty("CUITVendedor")); 
    }

    
    public TicketAcceso obtenerTicketAcceso() {
        TicketAcceso ticketAcceso = null;
        try {
        	//PARCHE
			ClassLoader classLoader = this.getClass().getClassLoader();
			java.io.File file = new java.io.File(classLoader.getResource(p12file).getFile());
			
            ticketAcceso = WsAfipCaller.invocarWSAA(file, p12pass, signer, dstDN, service, ticketTime, endpoint);
            ticketAcceso.setCuit(CUITVendedor.toString());
            return ticketAcceso;
        } catch (AxisFault e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticketAcceso;
    }
    
    public int obtenerUltimoComprobante(TicketAcceso ticketAcceso, String codigoComprobante, int puntoDeVenta){
    	int nroUltimoComprobante = -1;
    	try {
            nroUltimoComprobante = WsAfipCaller.getUltimoComprobanteAutorizado(ticketAcceso, Integer.parseInt(codigoComprobante), CUITVendedor, urlSolicitarCAE, puntoDeVenta).getCbteNro();
        } catch (Exception e) {
            e.printStackTrace();
        }
    	return nroUltimoComprobante;
    }
    
    public RespuestaProcesarFactura procesarComprobante(ComprobanteDTO comprobante, TicketAcceso ticketAcceso, int ultimoComprobante, int puntoDeVenta) {
        

        List<String> errores = new ArrayList<>();
        List<String> observaciones = new ArrayList<>();
        RespuestaProcesarFactura respuestaProcesarFactura = new RespuestaProcesarFactura();

        comprobante.setNumeroComprobante(ultimoComprobante + 1);
        RespuestaAFIP respuestaAFIP;
        adaptarFacturaPorTipo(comprobante); //modifico el subtotal para discriminar el iva ante afip

        try {
            respuestaAFIP = WsAfipCaller.getCAE(ticketAcceso, urlSolicitarCAE, comprobante, puntoDeVenta);
        } catch (Exception e) {
            e.printStackTrace();
            errores.add("No se pudo completar el pedido del CAE.");
            errores.add("Se desconoce el estado del tramite.");
            respuestaProcesarFactura.setListaErrores(errores);
            return respuestaProcesarFactura;
        }
        respuestaProcesarFactura.setResultado(respuestaAFIP.getResultado());
        
        if (respuestaAFIP.getObservaciones() != null) {
        	for (Observacion e: respuestaAFIP.getObservaciones()){
                observaciones.add("Observacion: " + String.valueOf(e.getCode()) + " - " + e.getMsg());
            }
            respuestaProcesarFactura.setListaObservaciones(observaciones);
        }
        
        if (respuestaAFIP.getErrores() != null) {
            for (ErrorAfip e: respuestaAFIP.getErrores()) {
                errores.add("Error: " + String.valueOf(e.getCode()) + " - " + e.getMsg());
                errores.add("No se pudo completar el tramite.");
            }
            respuestaProcesarFactura.setListaErrores(errores);
            return respuestaProcesarFactura;
        }
        
        if (!respuestaAFIP.hasCAE()) {
            errores.add("No se pudo obtener el CAE.");
            respuestaProcesarFactura.setListaErrores(errores);
            return respuestaProcesarFactura;
        }

        respuestaProcesarFactura.setNroComprobante(ultimoComprobante + 1);
        respuestaProcesarFactura.setCae(respuestaAFIP.getCAE());
        respuestaProcesarFactura.setFechaVtoCae(respuestaAFIP.getFechaExpiracion());

        return respuestaProcesarFactura;
    }
    
    
    private void adaptarFacturaPorTipo(ComprobanteDTO comprobante) {
        if(comprobante.esFacturaB()){
            //En subtotal tiene el precio con iva, tengo que discriminarlo para la afip
//            double subtotal =  ((100 * comprobante.getImporteNeto()) / (100+comprobante.getPorcentajeIva()) );
//            double importeIva = comprobante.getImporteNeto() - subtotal;
//            comprobante.setSubtotal(round(subtotal, 2));
//            comprobante.setImporteNeto(round(comprobante.getImporteNeto(),2));
//            comprobante.setTotalIva(round(importeIva,2));
            comprobante.setSubtotal(round(comprobante.getSubtotal(), 2));
            comprobante.setImporteNeto(round(comprobante.getImporteNeto(),2));
            comprobante.setTotalIva(round(comprobante.getTotalIva(),2));
        }else{
        	comprobante.setSubtotal(round(comprobante.getSubtotal(), 2));
            comprobante.setImporteNeto(round(comprobante.getImporteNeto(),2));
            comprobante.setTotalIva(round(comprobante.getTotalIva(),2));
        }
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

}