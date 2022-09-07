package sgh.mansilla.modelo.datos.facturacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sgh.mansilla.modelo.dao.Identificable;

public class PreTicket implements Identificable<Integer>  {

		private Integer idPreTicket;
		private ClienteComprobante clientePreTicket;
		private double precio; 
		private String descripcion;
		private Date fecha;
		private Concepto concepto; 
		private Boolean facturado;
		private List<ItemPreTicket> itemsPreTicket = new ArrayList<ItemPreTicket>();
		
		@Override
		public Integer getId() {
			// TODO Auto-generated method stub
			return idPreTicket;
		}

		public PreTicket() {
		}

		public Integer getIdPreTicket() {
			return idPreTicket;
		}

		public ClienteComprobante getClientePreTicket() {
			return clientePreTicket;
		}

		public double getPrecio() {
			return precio;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public Date getFecha() {
			return fecha;
		}

		public Boolean getFacturado() {
			return facturado;
		}

		public void setIdPreTicket(Integer idPreTicket) {
			this.idPreTicket = idPreTicket;
		}

		public void setClientePreTicket(ClienteComprobante clientePreTicket) {
			this.clientePreTicket = clientePreTicket;
		}

		public void setPrecio(double precio) {
			this.precio = precio;
		}

		public Concepto getConcepto() {
			return concepto;
		}

		public void setConcepto(Concepto concepto) {
			this.concepto = concepto;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}

		public void setFacturado(Boolean facturado) {
			this.facturado = facturado;
		}

		public List<ItemPreTicket> getItemsPreTicket() {
			return itemsPreTicket;
		}

		public void setItemsPreTicket(List<ItemPreTicket> itemsPreTicket) {
			this.itemsPreTicket = itemsPreTicket;
		}
		
		public double calcularTotal(){
			double total = 0;
			for(ItemPreTicket item : this.itemsPreTicket){
				total = total + item.calcularTotalItem();
			}
			return total;
		}
		
		public String toString(){
			return "";
		}

		
		
		
		

}

