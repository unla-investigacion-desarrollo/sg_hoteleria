package sgh.mansilla.modelo.datos.persona;

import java.sql.Date;
import java.util.Set;

import sgh.mansilla.modelo.datos.cuenta.Cuenta;

/**
 * @author Romina E. Mansilla - UNLA
 *
 */
public class ClientePersona extends Pasajero implements ICliente {

	Cuenta cuenta;

	public ClientePersona() {
	}

	public ClientePersona(String nombre, String apellido, TipoDocumento tipoDocumento, String documento,
			Date fechaDeNacimiento, Set<CaracteristicaPasajero> caracteristicas) {
		super(nombre, apellido, tipoDocumento, documento, fechaDeNacimiento, caracteristicas);
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

}
