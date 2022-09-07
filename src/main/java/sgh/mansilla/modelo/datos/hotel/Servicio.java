package sgh.mansilla.modelo.datos.hotel;

import java.math.BigDecimal;

import sgh.mansilla.modelo.dao.Identificable;

public class Servicio implements Identificable<Integer>  {
	Integer idServicio;
	String descripcion;
	BigDecimal precio;
	TipoServicio tipoServicio;

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return idServicio;
	}

	public Servicio() {
	}

	public Servicio(Integer idServicio, String descripcion, BigDecimal precio, TipoServicio tipo) {
		super();
		this.idServicio = idServicio;
		this.descripcion = descripcion;
		this.precio = precio;
		this.tipoServicio = tipo;
	}

	public Integer getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoServicio getTipoServicio() {
		return tipoServicio;
	}

	public void setTipoServicio(TipoServicio tipo) {
		this.tipoServicio = tipo;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Servicio [id=").append(idServicio).append(", ");
		if (descripcion != null)
			builder.append("descripcion=").append(descripcion).append(", ");
		if (precio != null)
			builder.append("precio=").append(precio).append(", ");
		if (tipoServicio != null)
			builder.append("tipo=").append(tipoServicio);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((idServicio == null) ? 0 : idServicio.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		result = prime * result + ((tipoServicio == null) ? 0 : tipoServicio.hashCode());
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
		Servicio other = (Servicio) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (idServicio == null) {
			if (other.idServicio != null)
				return false;
		} else if (!idServicio.equals(other.idServicio))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		if (tipoServicio == null) {
			if (other.tipoServicio != null)
				return false;
		} else if (!tipoServicio.equals(other.tipoServicio))
			return false;
		return true;
	}

}
