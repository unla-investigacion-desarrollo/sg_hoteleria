package sgh.mansilla.modelo.datos.facturacion;

import sgh.mansilla.modelo.dao.Identificable;

public class TipoComprobante implements Identificable<Integer>{

    private Integer idTipoComprobante;
    private String codigo;
    private String descripcion;
    
    
    @Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return idTipoComprobante;
	}

    public TipoComprobante() {
    }
    
    public TipoComprobante(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

	public Integer getIdTipoComprobante() {
		return idTipoComprobante;
	}

	public void setIdTipoComprobante(Integer idTipoComprobante) {
		this.idTipoComprobante = idTipoComprobante;
	}
	
	@Override
	public String toString() {
		return descripcion;
	}
    
    
}
