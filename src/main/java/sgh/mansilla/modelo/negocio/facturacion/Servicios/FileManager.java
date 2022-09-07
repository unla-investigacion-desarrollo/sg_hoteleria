package sgh.mansilla.modelo.negocio.facturacion.Servicios;

import sgh.mansilla.modelo.datos.facturacion.Comprobante;
import sgh.mansilla.modelo.datos.facturacion.RespuestaAFIP;
import sgh.mansilla.modelo.datos.facturacion.RespuestaProcesarFactura;
import sgh.mansilla.modelo.datos.facturacion.TipoComprobante;

import java.awt.Font;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;

public class FileManager {


	/**
	 * El código de barras deberá contener los siguientes datos con su correspondiente orden:
	 * -Clave Unica de Identificación Tributaria (C.U.I.T.) del  emisor de la factura (11 caracteres)
	 * -Código de tipo de comprobante (2 caracteres)
	 * -Punto de venta (4 caracteres)
	 * -Código de Autorización de Impresión (C.A.E.) (14 caracteres)
	 * -Fecha de vencimiento (8 caracteres)
	 * -Dígito verificador (1 carácter)
	 * @throws Exception
	 * @params Ruta con nombre pero sin extensión
	 */
	public static void generarCodigoDeBarra(String CUIT,Comprobante factura, String rutaCompleta) throws Exception {
		String barcodeData = getBarcodeData(CUIT,factura,rutaCompleta);
//		Linear linear = new Linear();
//		linear.setType(Linear.INTERLEAVED25);
//		linear.setAddCheckSum(true);
//		linear.setData(barcodeData);
//		linear.setX(6);
//		linear.setY(150);
//		linear.setTextFont(new Font("Arial", Font.PLAIN, 45));
//		linear.renderBarcode(rutaCompleta+".gif");
		Barcode barcode = null;
		try {
			barcode = BarcodeFactory.createInt2of5(barcodeData,true);
			barcode.setFont(new Font("Arial", Font.PLAIN, 20));
			File file = new File(rutaCompleta);
			BarcodeImageHandler.saveGIF(barcode, file);

			//this is useless ... but it helps get rid of the black line.
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			BarcodeImageHandler.writePNG(barcode, baos);

			file.deleteOnExit();
			FileOutputStream fos = new FileOutputStream(file);
			BarcodeImageHandler.writeGIF(barcode, fos);


//			BufferedImage originalImage = ImageIO.read(file);
//			BufferedImage resizedImage = new BufferedImage(30, 10, BufferedImage.TYPE_INT_RGB);
//			Graphics2D g = resizedImage.createGraphics();
//			g.drawImage(originalImage, 0, 0, 30, 10, null);
//			g.dispose();
//			ImageIO.write(resizedImage, ".gif", file);

		}
		catch (BarcodeException e) {
			e.printStackTrace();
		}

	}

	private static String getBarcodeData(String CUIT, Comprobante factura, String rutaCompleta) {
		String puntoDeVentaFormateado = adaptarPuntoDeVenta(factura.getPtoVenta());
		String tipoComprobante = adaptarTipoComprobante(factura.getTipoComprobante());
		//String fechaVencimientoFormateada = adaptarFechaVencimiento(respuestaAFIP.getFechaExpiracion());
		Calendar cal = Calendar.getInstance();
		cal.setTime(factura.getVencimientoCae());
		int anio = cal.get(Calendar.YEAR);
		int mes = cal.get(Calendar.MONTH);
		int dia = cal.get(Calendar.DAY_OF_MONTH);
		String fechaVencimientoFormateada = adaptarFechaVencimiento(new GregorianCalendar(anio,mes,dia));
		String barcodeData = CUIT+tipoComprobante+puntoDeVentaFormateado+factura.getCae()+fechaVencimientoFormateada;
		return barcodeData;
	}

	private static String adaptarFechaVencimiento(GregorianCalendar fechaExpiracion) {
		String mes = adaptarFecha(fechaExpiracion.get(Calendar.MONTH)+1);
		String dia = adaptarFecha(fechaExpiracion.get(Calendar.DAY_OF_MONTH));
		String fechaFormateada=String.valueOf(fechaExpiracion.get(Calendar.YEAR))+mes+dia;
		return fechaFormateada;
	}

	/**
	 * Metodo que devuelve el campo agregando un 0 a la izquierda si no lo tiene
	 * @param fecha - mes
	 * @return mes formateado
	 */
	private static String adaptarFecha(int fecha) {
		String fechaFormateada = String.valueOf(fecha);
		while(fechaFormateada.length()<2){
			fechaFormateada = "0"+fechaFormateada;
		}

		return fechaFormateada;
	}

	private static String adaptarTipoComprobante(TipoComprobante tipoComprobante) {
		String tipoComprobanteFormateado = tipoComprobante.getCodigo();
		while(tipoComprobanteFormateado.length()<2){
			tipoComprobanteFormateado = "0"+tipoComprobanteFormateado;
		}
		return tipoComprobanteFormateado.substring(1, 3);
	}

	/**
	 * Metodo que adapta el int para que ocupe los 4 caracteres en caso de no poseerlos
	 * @param puntoDeVenta
	 * @return
	 */
	public static String adaptarPuntoDeVenta(int puntoDeVenta) {
		String puntoDeVentaFormateado = String.valueOf(puntoDeVenta);
		while(puntoDeVentaFormateado.length()<4){
			puntoDeVentaFormateado = "0"+puntoDeVentaFormateado;
		}
		return puntoDeVentaFormateado;
	}
	
	/**
	 * Metodo que adapta el int para que ocupe los 4 caracteres en caso de no poseerlos
	 * @param puntoDeVenta
	 * @return
	 */
	public static String adaptarNroComprobante(int nroComprobante) {
		String puntoDeVentaFormateado = String.valueOf(nroComprobante);
		while(puntoDeVentaFormateado.length()<8){
			puntoDeVentaFormateado = "0"+puntoDeVentaFormateado;
		}
		return puntoDeVentaFormateado;
	}
}