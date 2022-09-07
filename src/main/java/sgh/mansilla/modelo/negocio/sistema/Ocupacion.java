package sgh.mansilla.modelo.negocio.sistema;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ocupacion {
	Integer idEstadia;
	String estadoEstadia;
	Calendar fecha;
	Integer columna;
	Calendar diaCheckIn;
	Calendar diaCheckOut;
	String informacion;
	String color;

	public Ocupacion(Integer idEstadia, String estadoEstadia,
			Calendar fecha,	Integer columna,Calendar diaCheckIn,Calendar diaCheckOut) {
		super();
		this.idEstadia = idEstadia;
		this.estadoEstadia = estadoEstadia;
		this.fecha = fecha;
		this.columna = columna;
		this.diaCheckIn = diaCheckIn;
		this.diaCheckOut = diaCheckOut;
	}

	public Ocupacion(Integer idEstadia, String estadoEstadia,
			Calendar fecha,	Integer columna, String informacion, String color) {
		super();
		this.idEstadia = idEstadia;
		this.estadoEstadia = estadoEstadia;
		this.fecha = fecha;
		this.columna = columna;
		this.informacion = informacion;
		this.color = color;
	}

	public Ocupacion() {
		super();
	}


	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getInformacion() {
		return informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}

	public Integer getIdEstadia() {
		return idEstadia;
	}

	public void setIdEstadia(Integer idEstadia) {
		this.idEstadia = idEstadia;
	}

	public String getEstadoEstadia() {
		return estadoEstadia;
	}

	public void setEstadoEstadia(String estadoEstadia) {
		this.estadoEstadia = estadoEstadia;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public Integer getColumna() {
		return columna;
	}

	public void setColumna(Integer columna) {
		this.columna = columna;
	}

	public Calendar getDiaCheckIn() {
		return diaCheckIn;
	}

	public void setDiaCheckIn(Calendar diaCheckIn) {
		this.diaCheckIn = diaCheckIn;
	}

	public Calendar getDiaCheckOut() {
		return diaCheckOut;
	}

	public void setDiaCheckOut(Calendar diaCheckOut) {
		this.diaCheckOut = diaCheckOut;
	}


	public long getFechaMillis() {
		return fecha.getTimeInMillis();
	}
	public long getDiaCheckInMillis() {
		return diaCheckIn.getTimeInMillis();
	}
	public long getDiaCheckOutMillis() {
		return diaCheckOut.getTimeInMillis();
	}
}
