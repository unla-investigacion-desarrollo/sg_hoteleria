package sgh.mansilla.modelo.datos.hotel;

import sgh.mansilla.modelo.dao.Identificable;

public class TipoServicio  implements Identificable<Integer>  {

	Integer idTipoServicio;
	String descripcion;

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return idTipoServicio;
	}

	public TipoServicio() {
	}

	public TipoServicio(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public Integer getIdTipoServicio() {
		return idTipoServicio;
	}

	public void setIdTipoServicio(Integer idTipoServicio) {
		this.idTipoServicio = idTipoServicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TipoServicio [id=").append(idTipoServicio).append(", ");
		if (descripcion != null)
			builder.append("descripcion=").append(descripcion);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((idTipoServicio == null) ? 0 : idTipoServicio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoServicio other = (TipoServicio) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (idTipoServicio == null) {
			if (other.idTipoServicio != null)
				return false;
		} else if (!idTipoServicio.equals(other.idTipoServicio))
			return false;
		return true;
	}

}
