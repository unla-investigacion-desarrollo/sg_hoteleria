package sgh.mansilla.modelo.datos.facturacion;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class RespuestaProcesarFactura {

    List<String> listaErrores=new ArrayList<String>();
    List<String> listaObservaciones=new ArrayList<String>();
    String cae;
    String rutaPdf;
    String resultado;
    int nroComprobante;
    String fecha;
    GregorianCalendar fechaVtoCae;

    public List<String> getListaErrores() {
        return listaErrores;
    }

    public void setListaErrores(List<String> listaErrores) {
        this.listaErrores = listaErrores;
    }
    public String getRutaPdf() {
        return this.rutaPdf;
    }
    public void setRutaPdf(String rutaPdf) {
       this.rutaPdf = rutaPdf;
    }

	public List<String> getListaObservaciones() {
		return listaObservaciones;
	}

	public void setListaObservaciones(List<String> listaObservaciones) {
		this.listaObservaciones = listaObservaciones;
	}

	public String getCae() {
		return cae;
	}

	public void setCae(String cae) {
		this.cae = cae;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public int getNroComprobante() {
		return nroComprobante;
	}

	public void setNroComprobante(int nroComprobante) {
		this.nroComprobante = nroComprobante;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public GregorianCalendar getFechaVtoCae() {
		return fechaVtoCae;
	}

	public void setFechaVtoCae(GregorianCalendar fechaVtoCae) {
		this.fechaVtoCae = fechaVtoCae;
	}
    
	
    
}
