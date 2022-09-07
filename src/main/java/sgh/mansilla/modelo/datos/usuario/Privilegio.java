package sgh.mansilla.modelo.datos.usuario;


import javax.persistence.Transient;

import sgh.mansilla.modelo.dao.Identificable;


public class Privilegio implements Identificable<Integer> {

	private Integer idPrivilegio;
	private String descripcion = TipoPrivilegio.USUARIO.getTipoPrivilegio();
	ModuloSistema moduloSistema;

	@Transient
	@Override
	public Integer getId() {
		return idPrivilegio;
	}

	public Privilegio() {

	}

	public Integer getIdPrivilegio() {
		return idPrivilegio;
	}

	public void setIdPrivilegio(Integer idPrivilegio) {
		this.idPrivilegio = idPrivilegio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Transient
	public ModuloSistema getModuloSistema() {
		return moduloSistema;
	}

	@Transient
	public void setModuloSistema(ModuloSistema moduloSistema) {
		this.moduloSistema = moduloSistema;
	}



}
