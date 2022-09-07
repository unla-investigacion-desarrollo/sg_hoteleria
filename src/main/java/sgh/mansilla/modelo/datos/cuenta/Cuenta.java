package sgh.mansilla.modelo.datos.cuenta;

import java.math.BigDecimal;

import sgh.mansilla.modelo.datos.persona.ICliente;

/**
 * @author Romina E. Mansilla - UNLA
 *
 */
public class Cuenta {
	Integer idCuenta;
	ICliente cliente;
	BigDecimal saldo;

	public Cuenta() {
	}

	public Cuenta(int idCuenta, ICliente cliente, BigDecimal saldo ) {
		super();
		this.idCuenta = idCuenta;
		this.cliente = cliente;
		this.saldo = saldo;
	}

	public Integer getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(Integer idCuenta) {
		this.idCuenta = idCuenta;
	}

	public ICliente getCliente() {
		return cliente;
	}

	public void setCliente(ICliente cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
}
