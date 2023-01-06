package sgh.mansilla.modelo.datos.estadia;

import java.util.Objects;

import sgh.mansilla.modelo.dao.Identificable;
import sgh.mansilla.modelo.datos.hotel.Habitacion;
import sgh.mansilla.modelo.datos.persona.Pasajero;

public class PasajeroEstadia implements Identificable<Integer>{

	Integer idPasajeroEstadia;
	Pasajero pasajero;
	Estadia estadia;
	Habitacion habitacion;

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return idPasajeroEstadia;
	}

	public PasajeroEstadia() {
		// TODO Auto-generated constructor stub
	}

	public PasajeroEstadia(Pasajero pasajero, Estadia estadia, Habitacion habitacion) {
		super();
		this.pasajero = pasajero;
		this.estadia = estadia;
		this.habitacion = habitacion;
	}

	public Integer getIdPasajeroEstadia() {
		return idPasajeroEstadia;
	}

	public void setIdPasajeroEstadia(Integer idPasajeroEstadia) {
		this.idPasajeroEstadia = idPasajeroEstadia;
	}

	public Pasajero getPasajero() {
		return pasajero;
	}

	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}

	public Estadia getEstadia() {
		return estadia;
	}

	public void setEstadia(Estadia estadia) {
		this.estadia = estadia;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PasajeroEstadia [");
		if (pasajero != null)
			builder.append("pasajero=").append(pasajero).append(", ");
		if (estadia != null)
			builder.append("estadia=").append(estadia).append(", ");
		if (habitacion != null)
			builder.append("habitacion=").append(habitacion);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estadia == null) ? 0 : estadia.hashCode());
		result = prime * result + ((habitacion == null) ? 0 : habitacion.hashCode());
		result = prime * result + ((idPasajeroEstadia == null) ? 0 : idPasajeroEstadia.hashCode());
		result = prime * result + ((pasajero == null) ? 0 : pasajero.hashCode());
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
		PasajeroEstadia other = (PasajeroEstadia) obj;
		if (estadia == null) {
			if (other.estadia != null)
				return false;
		} else if (!estadia.equals(other.estadia))
			return false;
		if (habitacion == null) {
			if (other.habitacion != null)
				return false;
		} else if (!habitacion.equals(other.habitacion))
			return false;
		if (idPasajeroEstadia == null) {
			if (other.idPasajeroEstadia != null)
				return false;
		} else if (!idPasajeroEstadia.equals(other.idPasajeroEstadia))
			return false;
		if (pasajero == null) {
			if (other.pasajero != null)
				return false;
		} else if (!pasajero.equals(other.pasajero))
			return false;
		return true;		
	}

}
