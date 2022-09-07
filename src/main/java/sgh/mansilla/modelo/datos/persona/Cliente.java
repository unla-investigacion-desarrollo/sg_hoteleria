package sgh.mansilla.modelo.datos.persona;

import sgh.mansilla.modelo.datos.cuenta.Cuenta;

/**
 * @author Romina E. Mansilla - UNLA
 *
 */
public class Cliente {
	private Integer idCliente;
	private String tel;
	private String eMail;
	private Cuenta cuenta;

	public Cliente() {
	}

	public Cliente(Integer idCliente, String tel, String eMail, Cuenta cuenta) {
		super();
		this.idCliente = idCliente;
		this.tel = tel;
		this.eMail = eMail;
		this.cuenta = cuenta;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

}
