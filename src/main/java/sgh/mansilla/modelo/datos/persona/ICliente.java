package sgh.mansilla.modelo.datos.persona;

import sgh.mansilla.modelo.datos.cuenta.Cuenta;

public interface ICliente {
	Integer getIdContacto();

	String getEmail();

	String getTelefono();

	Cuenta getCuenta();
}
