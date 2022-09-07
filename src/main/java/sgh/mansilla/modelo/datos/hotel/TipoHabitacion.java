package sgh.mansilla.modelo.datos.hotel;

import sgh.mansilla.modelo.dao.Identificable;

public class TipoHabitacion implements Identificable<Integer>  {

	Integer idTipoHabitacion;
	String nombreTipoHabitacion;
	String descripcion;
	int capacidad;

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return idTipoHabitacion;
	}

	public TipoHabitacion() {
	}

	public TipoHabitacion(Integer idTipoHabitacion, String nombreTipoHabitacion, String descripcion, int capacidad) {
		super();
		this.idTipoHabitacion = idTipoHabitacion;
		this.nombreTipoHabitacion = nombreTipoHabitacion;
		this.descripcion = descripcion;
		this.capacidad = capacidad;
	}

	public Integer getIdTipoHabitacion() {
		return idTipoHabitacion;
	}

	public void setIdTipoHabitacion(Integer idTipoHabitacion) {
		this.idTipoHabitacion = idTipoHabitacion;
	}

	public String getNombreTipoHabitacion() {
		return nombreTipoHabitacion;
	}

	public void setNombreTipoHabitacion(String nombreTipoHabitacion) {
		this.nombreTipoHabitacion = nombreTipoHabitacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("");
		if (nombreTipoHabitacion != null)
			builder.append(nombreTipoHabitacion).append(", ");
		builder.append(capacidad).append(" personas. ").append("");
		return builder.toString();
	}


	public String getToString() {
		StringBuilder builder = new StringBuilder();
		builder.append("");
		if (nombreTipoHabitacion != null)
			builder.append(nombreTipoHabitacion).append(", ");
		builder.append(capacidad).append(" personas. ").append("");
		return builder.toString();
	}

}
