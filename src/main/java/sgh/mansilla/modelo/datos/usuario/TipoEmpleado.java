package sgh.mansilla.modelo.datos.usuario;

public class TipoEmpleado {

	Integer idTipoEmpleado;
	String descripcion;

	public TipoEmpleado(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public Integer getIdTipoEmpleado() {
		return idTipoEmpleado;
	}

	public void setIdTipoEmpleado(Integer idTipoEmpleado) {
		this.idTipoEmpleado = idTipoEmpleado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
