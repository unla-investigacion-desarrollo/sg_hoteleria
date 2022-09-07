package sgh.mansilla.modelo.datos.hotel;

import java.util.List;

import javax.persistence.Transient;

import sgh.mansilla.modelo.dao.Identificable;
import sgh.mansilla.modelo.datos.hotel.Habitacion;
import sgh.mansilla.modelo.datos.usuario.Empleado;

public class Hotel implements Identificable<Integer>  {

	Integer idHotel;
	String nombreHotel;
	String direccion;
	int telefono;
	String email;
	String paginaWeb;
	List<Habitacion> lstHabitaciones;
	List<Empleado> lstEmpleados;

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return idHotel;
	}

	public Hotel() {
	}

	public Hotel(Integer idHotel, String nombreHotel, String direccion, int telefono, String email, String paginaWeb,
			List<Habitacion> lstHabitaciones, List<Empleado> lstEmpleados) {
		super();
		this.idHotel = idHotel;
		this.nombreHotel = nombreHotel;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.paginaWeb = paginaWeb;
		this.lstHabitaciones = lstHabitaciones;
		this.lstEmpleados = lstEmpleados;
	}

	public Integer getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Integer idHotel) {
		this.idHotel = idHotel;
	}

	public String getNombreHotel() {
		return nombreHotel;
	}

	public void setNombreHotel(String nombreHotel) {
		this.nombreHotel = nombreHotel;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPaginaWeb() {
		return paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}

	@Transient
	public List<Habitacion> getLstHabitaciones() {
		return lstHabitaciones;
	}

	@Transient
	public void setLstHabitaciones(List<Habitacion> lstHabitaciones) {
		this.lstHabitaciones = lstHabitaciones;
	}

	@Transient
	public List<Empleado> getLstEmpleados() {
		return lstEmpleados;
	}

	@Transient
	public void setLstEmpleados(List<Empleado> lstEmpleados) {
		this.lstEmpleados = lstEmpleados;
	}

	public void addHabitacion(Habitacion habitacion) {
		this.lstHabitaciones.add(habitacion);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hotel: ");
		if (nombreHotel != null)
			builder.append(nombreHotel).append(", ");
		if (direccion != null)
			builder.append(direccion).append(", ");
		builder.append(telefono).append(", ");
		if (email != null)
			builder.append(email).append(", ");
		if (paginaWeb != null)
			builder.append(paginaWeb);
		builder.append(".");
		return builder.toString();
	}

}
