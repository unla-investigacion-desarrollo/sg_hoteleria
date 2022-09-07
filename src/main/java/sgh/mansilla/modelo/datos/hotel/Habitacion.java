package sgh.mansilla.modelo.datos.hotel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Transient;

import sgh.mansilla.modelo.dao.Identificable;
import sgh.mansilla.modelo.datos.persona.CaracteristicaPasajero;

public class Habitacion implements Identificable<Integer>  {

	Integer idHabitacion;
	String descripcion;
	EstadoHabitacion estadoHabitacion;
	TipoHabitacion tipoHabitacion;
	Hotel hotel;
	Set<CaracteristicaHabitacion> caracteristicas = new HashSet<CaracteristicaHabitacion>();

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return idHabitacion;
	}

	public Habitacion() {
	}

	public Habitacion(Integer idHabitacion, String descripcion, EstadoHabitacion estadoHabitacion, TipoHabitacion tipoHabitacion,
			Hotel hotel, Set<CaracteristicaHabitacion> caracteristicas) {
		super();
		this.idHabitacion = idHabitacion;
		this.descripcion = descripcion; //Hab. 101
		this.estadoHabitacion = estadoHabitacion;
		this.tipoHabitacion = tipoHabitacion;
		this.hotel = hotel;
		this.caracteristicas = caracteristicas;
	}

	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getIdHabitacion() {
		return idHabitacion;
	}

	public void setIdHabitacion(Integer idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	public EstadoHabitacion getEstadoHabitacion() {
		return estadoHabitacion;
	}

	public void setEstadoHabitacion(EstadoHabitacion estadoHabitacion) {
		this.estadoHabitacion = estadoHabitacion;
	}

	public TipoHabitacion getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public Set<CaracteristicaHabitacion> getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(Set<CaracteristicaHabitacion> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public void addCaracteristicaHabitacion(CaracteristicaHabitacion caracteristica) {
		this.caracteristicas.add(caracteristica);
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("");
		if (idHabitacion != null)
			builder.append(descripcion).append(" ( ");
		if (tipoHabitacion != null)
			builder.append(tipoHabitacion);
		builder.append(")");
		return builder.toString();
	}


}
