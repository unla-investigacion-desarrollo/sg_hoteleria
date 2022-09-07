package sgh.mansilla.modelo.datos.facturacion;

import sgh.mansilla.modelo.dao.Identificable;

public class ItemPreTicket implements Identificable<Integer>{
	
	private Integer idItemPreTicket;
	private int cantidad;
	private String descripcion;
	private double precio;
	private PreTicket preTicket; 
	

	@Override
	public Integer getId() {
		return idItemPreTicket;
	}
	
	public ItemPreTicket(){
		
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

	public Integer getIdItemPreTicket() {
		return idItemPreTicket;
	}

	public void setIdItemPreTicket(Integer idItemPreTicket) {
		this.idItemPreTicket = idItemPreTicket;
	}
	
	public PreTicket getPreTicket() {
		return preTicket;
	}

	public void setPreTicket(PreTicket preTicket) {
		this.preTicket = preTicket;
	}

	public double calcularTotalItem() {
		return this.cantidad*this.precio;
	}
	
}
