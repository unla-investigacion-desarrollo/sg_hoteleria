package sgh.mansilla.modelo.datos.estadia;

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


}
