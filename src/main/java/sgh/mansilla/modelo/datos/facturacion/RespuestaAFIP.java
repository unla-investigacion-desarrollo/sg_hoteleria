package sgh.mansilla.modelo.datos.facturacion;


import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import sgh.mansilla.modelo.dto.facturacion.afip.ErrorAfip;
import sgh.mansilla.modelo.dto.facturacion.afip.Observacion;

public class RespuestaAFIP {
	private String CAE;
	private ErrorAfip[] errores;
	private Observacion[] observaciones;
	private String resultado;
	private GregorianCalendar fechaExpiracion;
	public RespuestaAFIP(String CAE) {
		super();
		this.CAE = CAE;
		
	}
	
	public RespuestaAFIP(String cAE, GregorianCalendar fechaExpiracion) {
		super();
		CAE = cAE;
		this.fechaExpiracion = fechaExpiracion;
	}

	public String getCAE() {
		return CAE;
	}
	public void setCAE(String cAE) {
		CAE = cAE;
	}
	public void setErrores(ErrorAfip[] errores) {
		this.errores = errores;
	}
	public ErrorAfip[] getErrores(){
		return errores;
	}
	public Observacion[] getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(Observacion[] observaciones) {
		this.observaciones = observaciones;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public GregorianCalendar getFechaExpiracion() {
		return fechaExpiracion;
	}
	public void setFechaExpiracion(GregorianCalendar fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}
	public void setFechaExpiracion(String fechaExpiracion) {
		fechaExpiracion = fechaExpiracion.trim();

		if (fechaExpiracion.length() != 8)
			return;

		// fechaExpiracion en formato afip aaaammdd
		int anio = Integer.parseInt(fechaExpiracion.substring(0, 4));
		int mes = Integer.parseInt(fechaExpiracion.substring(4, 6));
		int dia = Integer.parseInt(fechaExpiracion.substring(6, 8));
		this.fechaExpiracion = new GregorianCalendar(anio, mes - 1, dia);
	}
	
	public String getFechaString()
	{
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
	    fmt.setCalendar(this.fechaExpiracion);
	    String dateFormatted = fmt.format(this.fechaExpiracion.getTime());
	    return dateFormatted;
	}

	public boolean hasCAE() {
		return this.CAE.trim().length() > 0;
	}
	
}
