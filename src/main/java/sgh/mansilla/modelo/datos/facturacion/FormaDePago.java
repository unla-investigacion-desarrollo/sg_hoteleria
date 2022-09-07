package sgh.mansilla.modelo.datos.facturacion;

import sgh.mansilla.modelo.dao.Identificable;

public class FormaDePago implements Identificable<Integer>{
	
	private Integer idFormaDePago;
	private int codigo;
	private String descripcion;
	
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return idFormaDePago;
	}
	
	public FormaDePago(){
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getIdFormaDePago() {
		return idFormaDePago;
	}

	public void setIdFormaDePago(Integer idFormaDePago) {
		this.idFormaDePago = idFormaDePago;
	}
	
	@Override
	public String toString() {
		return descripcion;
	}

}
