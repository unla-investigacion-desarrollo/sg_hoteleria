package sgh.mansilla.modelo.datos.facturacion;

import sgh.mansilla.modelo.dao.Identificable;

public class Alicuota implements Identificable<Integer>{

	private Integer idAlicuota;
	private double baseImponible;
	private double importe;
	
	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return idAlicuota;
	}
	
	public Alicuota(){
		
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

	public Integer getIdAlicuota() {
		return idAlicuota;
	}

	public void setIdAlicuota(Integer idAlicuota) {
		this.idAlicuota = idAlicuota;
	}
	
	
}
