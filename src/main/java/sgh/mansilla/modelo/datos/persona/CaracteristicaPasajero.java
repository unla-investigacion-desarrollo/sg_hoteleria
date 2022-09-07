package sgh.mansilla.modelo.datos.persona;

import java.io.Serializable;

import sgh.mansilla.modelo.dao.Identificable;

public class CaracteristicaPasajero implements Identificable<Integer>, Serializable {
	Integer idCaracteristicaPasajero;
	String descripcion;

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return idCaracteristicaPasajero;
	}

	public CaracteristicaPasajero() {
	}

	public CaracteristicaPasajero(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public void setIdCaracteristicaPasajero(Integer idCaracteristicaPasajero) {
		this.idCaracteristicaPasajero = idCaracteristicaPasajero;
	}

	public Integer getIdCaracteristicaPasajero() {
		return idCaracteristicaPasajero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CaracteristicaPasajero [idCaracteristicaPasajero=").append(idCaracteristicaPasajero)
				.append(", descripcion=").append(descripcion).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((idCaracteristicaPasajero == null) ? 0 : idCaracteristicaPasajero.hashCode());
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
		CaracteristicaPasajero other = (CaracteristicaPasajero) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (idCaracteristicaPasajero == null) {
			if (other.idCaracteristicaPasajero != null)
				return false;
		} else if (!idCaracteristicaPasajero.equals(other.idCaracteristicaPasajero))
			return false;
		return true;
	}

}
