package sgh.mansilla.modelo.datos.facturacion;

import sgh.mansilla.modelo.dao.Identificable;

public class Moneda implements Identificable<Integer>{

	private Integer idMoneda;
    private String codigo;
    private String descripcion;
    private double cotizacion;
    
    
    @Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return idMoneda;
	}
    
    public Moneda(){
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

	public double getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(double cotizacion) {
		this.cotizacion = cotizacion;
	}

	public Integer getIdMoneda() {
		return idMoneda;
	}

	public void setIdMoneda(Integer idMoneda) {
		this.idMoneda = idMoneda;
	}
    
	@Override
	public String toString() {
		return descripcion;
	}
    
}
