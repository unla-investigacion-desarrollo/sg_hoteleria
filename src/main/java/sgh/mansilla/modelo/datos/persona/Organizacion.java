package sgh.mansilla.modelo.datos.persona;

import sgh.mansilla.modelo.dao.Identificable;
import sgh.mansilla.modelo.datos.cuenta.Cuenta;

/**
 * @author Romina E. Mansilla - UNLA
 *
 */

public class Organizacion extends PersonaAbstracta implements ICliente, Identificable<Integer> {
	String razonSocial;
	String cuit;
	Cuenta cuenta;

	public Organizacion() {

	}
	public Organizacion(String razonSocial, String cuit, Cuenta cuenta) {
		super();
		this.razonSocial = razonSocial;
		this.cuit = cuit;
		this.cuenta = cuenta;
	}

	public Organizacion(String razonSocial, String cuit) {
		super();
		this.razonSocial = razonSocial;
		this.cuit = cuit;
	}


	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return this.idContacto;
	}

}
