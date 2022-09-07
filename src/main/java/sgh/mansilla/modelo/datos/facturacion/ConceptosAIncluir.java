package sgh.mansilla.modelo.datos.facturacion;

import sgh.mansilla.modelo.dao.Identificable;

public class ConceptosAIncluir implements Identificable<Integer>{
	
	private Integer idConceptosAIncluir;
	private int codigo;
	private String descripcion;
	
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return idConceptosAIncluir;
	}
	
	public ConceptosAIncluir(){
		
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

	public Integer getIdConceptosAIncluir() {
		return idConceptosAIncluir;
	}

	public void setIdConceptosAIncluir(Integer idConceptosAIncluir) {
		this.idConceptosAIncluir = idConceptosAIncluir;
	}
	
	@Override
	public String toString() {
		return descripcion;
	}

}
