package sgh.mansilla.modelo.negocio.sistema;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import sgh.mansilla.modelo.datos.hotel.Habitacion;

public class VistaOcupacion {

	Calendar desde;
	Calendar hasta;
	Habitacion habitacion;
	ArrayList<Ocupacion> ocupaciones = new ArrayList<Ocupacion>();

	public VistaOcupacion(Habitacion habitacion) {
		super();
		this.habitacion = habitacion;
	}

	public VistaOcupacion(Calendar desde, Calendar hasta) {
		super();
		this.desde = desde;
		this.hasta = hasta;
	}

	public Calendar getDesde() {
		return desde;
	}

	public void setDesde(Calendar desde) {
		this.desde = desde;
	}

	public Calendar getHasta() {
		return hasta;
	}

	public void setHasta(Calendar hasta) {
		this.hasta = hasta;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public ArrayList<Ocupacion> getOcupaciones() {
		return ocupaciones;
	}

	public void setOcupaciones(ArrayList<Ocupacion> ocupaciones) {
		this.ocupaciones = ocupaciones;
	}

	public void addOcupacion(Ocupacion ocupacion){
		this.ocupaciones.add(ocupacion);
	}


}
