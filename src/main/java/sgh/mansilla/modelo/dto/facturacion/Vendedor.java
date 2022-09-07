package sgh.mansilla.modelo.dto.facturacion;

import java.util.Date;

public class Vendedor {
	private String cuit;
	private String nombre;
	private String domicilio;
	private String localidad;
	private String telefono;
	private String condicionIVA;
	private String ingresosBrutos;
	private String inicioActividades;
	
	public Vendedor(){
		
	}
	
	

	public Vendedor(String cuit, String nombre, String domicilio, String telefono, String condicionIVA,
			String ingresosBrutos, String inicioActividades, String localidad) {
		super();
		this.cuit = cuit;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.condicionIVA = condicionIVA;
		this.ingresosBrutos = ingresosBrutos;
		this.inicioActividades = inicioActividades;
		this.localidad = localidad;
	}



	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCondicionIVA() {
		return condicionIVA;
	}

	public void setCondicionIVA(String condicionIVA) {
		this.condicionIVA = condicionIVA;
	}



	public String getIngresosBrutos() {
		return ingresosBrutos;
	}



	public void setIngresosBrutos(String ingresosBrutos) {
		this.ingresosBrutos = ingresosBrutos;
	}



	public String getInicioActividades() {
		return inicioActividades;
	}



	public void setInicioActividades(String inicioActividades) {
		this.inicioActividades = inicioActividades;
	}



	public String getLocalidad() {
		return localidad;
	}



	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	
	
}
