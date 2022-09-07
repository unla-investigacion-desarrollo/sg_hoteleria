package sgh.mansilla.modelo.datos.facturacion;

import sgh.mansilla.modelo.dao.Identificable;

public class Tributo implements Identificable<Integer>{
	
	private Integer idTributo;
	private String descripcion;
	private double alicuota;
	private double baseImponible;
	private double importe;
	
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return idTributo;
	}
	
	public Tributo(){
		
	}
	
	public double getAlicuota() {
		return alicuota;
	}

	public void setAlicuota(double alicuota) {
		this.alicuota = alicuota;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getBaseImponible() {
		return baseImponible;
	}

	public void setBaseImponible(double baseImponible) {
		this.baseImponible = baseImponible;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public Integer getIdTributo() {
		return idTributo;
	}

	public void setIdTributo(Integer idTributo) {
		this.idTributo = idTributo;
	}
	
	
	
	
}
