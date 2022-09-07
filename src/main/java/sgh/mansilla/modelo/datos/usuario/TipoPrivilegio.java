package sgh.mansilla.modelo.datos.usuario;

import java.io.Serializable;

public enum TipoPrivilegio implements Serializable{
	USUARIO("USUARIO"),
	DBA("DBA"),
	ADMIN("ADMIN");

	String tipoPrivilegio;

	private TipoPrivilegio(String tipoPrivilegio){
		this.tipoPrivilegio = tipoPrivilegio;
	}

	public String getTipoPrivilegio(){
		return tipoPrivilegio;
	}

}
