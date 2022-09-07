package sgh.mansilla.modelo.datos.usuario;

public class ModuloSistema {
	Integer idModuloSistema;
	String moduloSistema;

	public ModuloSistema(Integer idModuloSistema, String moduloSistema) {
		super();
		this.idModuloSistema = idModuloSistema;
		this.moduloSistema = moduloSistema;
	}

	public Integer getIdModuloSistema() {
		return idModuloSistema;
	}

	public void setIdModuloSistema(Integer idModuloSistema) {
		this.idModuloSistema = idModuloSistema;
	}

	public String getModuloSistema() {
		return moduloSistema;
	}

	public void setModuloSistema(String moduloSistema) {
		this.moduloSistema = moduloSistema;
	}

}
