package sgh.mansilla.modelo.datos.hotel;

import java.io.Serializable;

import sgh.mansilla.modelo.dao.Identificable;

public class CaracteristicaHabitacion implements Identificable<Integer>, Serializable  {
	Integer idCaracteristicaHabitacion;
	String descripcion;

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return idCaracteristicaHabitacion;
	}

	public CaracteristicaHabitacion() {
	}

	public CaracteristicaHabitacion(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public Integer getIdCaracteristicaHabitacion() {
		return idCaracteristicaHabitacion;
	}

	public void setIdCaracteristicaHabitacion(Integer idCaracteristicaHabitacion) {
		this.idCaracteristicaHabitacion = idCaracteristicaHabitacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((idCaracteristicaHabitacion == null) ? 0 : idCaracteristicaHabitacion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CaracteristicaHabitacion other = (CaracteristicaHabitacion) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (idCaracteristicaHabitacion == null) {
			if (other.idCaracteristicaHabitacion != null)
				return false;
		} else if (!idCaracteristicaHabitacion.equals(other.idCaracteristicaHabitacion))
			return false;
		return true;
	}



}
