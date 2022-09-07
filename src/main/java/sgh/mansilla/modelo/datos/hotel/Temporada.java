package sgh.mansilla.modelo.datos.hotel;

import java.util.Date;

public class Temporada {

	Integer idTemporada;
	String nombreTemporada;
	Date fechaInicia;
	Date fechaTermina;
	String descripcion;

	public Temporada(Integer idTemporada, String nombreTemporada, Date fechaInicia, Date fechaTermina,
			String descripcion) {
		super();
		this.idTemporada = idTemporada;
		this.nombreTemporada = nombreTemporada;
		this.fechaInicia = fechaInicia;
		this.fechaTermina = fechaTermina;
		this.descripcion = descripcion;
	}

	public Integer getIdTemporada() {
		return idTemporada;
	}

	public void setIdTemporada(Integer idTemporada) {
		this.idTemporada = idTemporada;
	}

	public String getNombreTemporada() {
		return nombreTemporada;
	}

	public void setNombreTemporada(String nombreTemporada) {
		this.nombreTemporada = nombreTemporada;
	}

	public Date getFechaInicia() {
		return fechaInicia;
	}

	public void setFechaInicia(Date fechaInicia) {
		this.fechaInicia = fechaInicia;
	}

	public Date getFechaTermina() {
		return fechaTermina;
	}

	public void setFechaTermina(Date fechaTermina) {
		this.fechaTermina = fechaTermina;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
