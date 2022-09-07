package sgh.mansilla.modelo.datos.usuario;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Transient;

import sgh.mansilla.modelo.dao.Identificable;

public class Usuario implements Identificable<Integer>{

	private Integer idUsuario;
	private String userLogin;
	private String passLogin;
	private Boolean activo;
	private Set<Privilegio> privilegioUsuario = new HashSet<Privilegio>();

	public Integer getIdUsuario() {
		return idUsuario;
	}

	@Transient
	@Override
	public Integer getId() {
		return idUsuario;
	}

	public Usuario() {
	}


	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	public String getPassLogin() {
		return passLogin;
	}
	public void setPassLogin(String passLogin) {
		this.passLogin = passLogin;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Set<Privilegio> getPrivilegioUsuario() {
		return privilegioUsuario;
	}

	public void setPrivilegioUsuario(Set<Privilegio> privilegioUsuario) {
		this.privilegioUsuario = privilegioUsuario;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [");
		if (idUsuario != null)
			builder.append("idUsuario=").append(idUsuario).append(", ");
		if (userLogin != null)
			builder.append("userLogin=").append(userLogin).append(", ");
		if (activo != null)
			builder.append("activo=").append(activo).append(", ");
		if (privilegioUsuario != null)
			builder.append("privilegioUsuario=").append(privilegioUsuario);
		builder.append("]");
		return builder.toString();
	}



}


