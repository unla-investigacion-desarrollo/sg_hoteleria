package sgh.mansilla.modelo.negocio.sistema;

import java.util.ArrayList;
import java.util.Calendar;

public class VistaOcupacionHabitacion {

	Calendar desdeOcupacion;
	Calendar hastaOcupacion;
	ArrayList<String> fechas = new ArrayList<String>();
	ArrayList<Ocupacion> ocupaciones = new ArrayList<Ocupacion>();

	public VistaOcupacionHabitacion(Calendar desdeOcupacion, Calendar hastaOcupacion, ArrayList<String> fechas,
			ArrayList<Ocupacion> ocupaciones) {
		super();
		this.desdeOcupacion = desdeOcupacion;
		this.hastaOcupacion = hastaOcupacion;
		this.fechas = fechas;
		this.ocupaciones = ocupaciones;
	}

	public Calendar getDesdeOcupacion() {
		return desdeOcupacion;
	}

	public void setDesdeOcupacion(Calendar desdeOcupacion) {
		this.desdeOcupacion = desdeOcupacion;
	}

	public Calendar getHastaOcupacion() {
		return hastaOcupacion;
	}

	public void setHastaOcupacion(Calendar hastaOcupacion) {
		this.hastaOcupacion = hastaOcupacion;
	}

	public ArrayList<String> getFechas() {
		return fechas;
	}

	public void setFechas(ArrayList<String> fechas) {
		this.fechas = fechas;
	}

	public ArrayList<Ocupacion> getOcupaciones() {
		return ocupaciones;
	}

	public void setOcupaciones(ArrayList<Ocupacion> ocupaciones) {
		this.ocupaciones = ocupaciones;
	}

	public long getDesdeEstadiaMillis() {
		return desdeOcupacion.getTimeInMillis();
	}
	public long getHastaEstadiaMillis() {
		return hastaOcupacion.getTimeInMillis();
	}
}
