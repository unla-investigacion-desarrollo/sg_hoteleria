package sgh.mansilla.modelo.datos.usuario;

import sgh.mansilla.modelo.datos.hotel.Hotel;

public class Empleado {

	Integer idEmpleado;
	String apellido;
	String nombre;
	int dni;
	TipoEmpleado tipoEmpleado;
	User usuario;
	/** Es la Clase Usuario modificada */
	Hotel hotel;

	public Empleado() {
	}

	public Empleado(String nombre, String apellido, int dni, TipoEmpleado tipoEmpleado, User usuario, Hotel hotel) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.tipoEmpleado = tipoEmpleado;
		this.usuario = usuario;
		this.hotel = hotel;
	}

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public TipoEmpleado getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}
