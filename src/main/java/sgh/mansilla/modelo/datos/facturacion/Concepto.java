package sgh.mansilla.modelo.datos.facturacion;

import sgh.mansilla.modelo.dao.Identificable;

public class Concepto implements Identificable<Integer>{
	
	private Integer idConcepto;
	private int cantidad;
	private String descripcion;
	private double precio;
	private int tipoIva;
	private Comprobante comprobante;
	private PreTicket preTicket; 
	

	@Override
	public Integer getId() {
		return idConcepto;
	}
	
	public Concepto(){
		
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getTipoIva() {
		return tipoIva;
	}

	public void setTipoIva(int tipoIva) {
		this.tipoIva = tipoIva;
	}

	public Integer getIdConcepto() {
		return idConcepto;
	}

	public void setIdConcepto(Integer idConcepto) {
		this.idConcepto = idConcepto;
	}

	public Comprobante getComprobante() {
		return comprobante;
	}

	public void setComprobante(Comprobante comprobante) {
		this.comprobante = comprobante;
	}
	
	public PreTicket getPreTicket() {
		return preTicket;
	}

	public void setPreTicket(PreTicket preTicket) {
		this.preTicket = preTicket;
	}
	
	public String toString(){
		return "";
	}

	
	
}
