package sgh.mansilla.modelo.datos.hotel;

import sgh.mansilla.modelo.dao.Identificable;

public class EstadoHabitacion implements Identificable<Integer>  {
	Integer idEstadoHabitacion;
	String descripcion;

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return idEstadoHabitacion;
	}
	public EstadoHabitacion() {
	}

	public EstadoHabitacion(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public Integer getIdEstadoHabitacion() {
		return idEstadoHabitacion;
	}

	public void setIdEstadoHabitacion(Integer idEstadoHabitacion) {
		this.idEstadoHabitacion = idEstadoHabitacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



}
