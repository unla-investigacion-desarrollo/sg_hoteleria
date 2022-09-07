package sgh.mansilla.vista.test;

import java.io.IOException;
import java.util.GregorianCalendar;

import sgh.mansilla.modelo.dto.facturacion.ComprobanteDTO;
import sgh.mansilla.modelo.dto.facturacion.afip.*;
import sgh.mansilla.modelo.datos.facturacion.*;
import sgh.mansilla.modelo.negocio.facturacion.*;


public class Test {

	public static void main(String[] args) {
		
//		TipoDocumento tipoDocumento = new TipoDocumento();
//		tipoDocumento.setCodigo("80"); // 80 es CUIT, 99 es "Otro"
//		
//		Cliente cliente = new Cliente();
//		cliente.setTipoDocumento(tipoDocumento);
//		cliente.setNroDocumento("30655116512");
//		
//		//EJEMPLO FACTURA A
//		TipoComprobante tipoComprobante = new TipoComprobante();
//		tipoComprobante.setCodigo("1");
//		tipoComprobante.setDescripcion("Factura A");
//		tipoComprobante.setIdTipoComprobante(1);
//		
//		ComprobanteDTO f1 = new ComprobanteDTO();
//		f1.setCliente(cliente);
//		f1.setFecha(new GregorianCalendar());
//		f1.setNumeroComprobante(1);
//		f1.setImporteTotal(231.5);
//		f1.setImporteNeto(200);
//		f1.setSubtotal(200);
//		f1.setTotalIva(31.5);
//		f1.setTipoComprobante(tipoComprobante);
//		f1.setPorcentajeIva(21);
//		f1.setCondicionVenta("1");
//		f1.setIdIva(5);
//		f1.setIdConcepto(1);
//		f1.setCantidadRegistros(1);
//		f1.setImporteExcento(0);
//		f1.setImporteTributos(0);
//		f1.setIdMoneda("PES");
//		f1.setCotizacionMoneda(1);
//		
		AlicIva [] alicIvas = {new AlicIva(5,100, 21),new AlicIva(4,100, 10.5)};
		AlicIva [] alicIvas2 = alicIvas;
//		f1.setAlicIvas(alicIvas);
//		
//		ServicioAfip servicioAfip = new ServicioAfip();
//		
//		TicketAcceso ticketAcceso =  servicioAfip.obtenerTicketAcceso();
//		int nroUltimoComprobante = servicioAfip.obtenerUltimoComprobante(ticketAcceso, f1.getTipoComprobante().getCodigo(),2);
//		RespuestaProcesarFactura rpf =servicioAfip.procesarComprobante(f1,ticketAcceso,nroUltimoComprobante,2);
//		
//		System.out.println(f1.getNumeroComprobante());
//		for(String error : rpf.getListaErrores()){
//			System.out.println(error);
//		}
//		
//		
		
		//EJEMPLO FACTURA B - EL IVA ESTA INCLUIDO EN EL TOTAL Y HAY QUE DISCRIMINARLO PARA EL SUBTOTAL
//		TipoComprobante tipoComprobante2 = new TipoComprobante();
//		tipoComprobante2.setCodigo("6");
//		tipoComprobante2.setDescripcion("Factura B");
//		tipoComprobante2.setIdTipoComprobante(6);
//		
//		Factura f2 = new Factura();
//		f2.setCliente(cliente);
//		f2.setFecha(new GregorianCalendar());
//		f2.setNumeroComprobante(1);
//		f2.setImporteTotal(121);
//		f2.setImporteNeto(121);
//		//f2.setSubtotal(1); No es necesario porque se calcula luego
//		f2.setTotalIva(21);
//		f2.setTipoComprobante(tipoComprobante2);
//		f2.setPorcentajeIva(21);
//		f2.setCondicionVenta("1");
//		
//		ServicioAfip fa2 = new ServicioAfip();
//		RespuestaProcesarFactura rpf2 =fa2.procesarFactura(f2);
//		System.out.println(f2.getNumeroComprobante());
//		for(String error : rpf2.getListaErrores()){
//			System.out.println(error);
//		}
	}

}
