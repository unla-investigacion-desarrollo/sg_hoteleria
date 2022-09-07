package sgh.mansilla.modelo.datos.hotel;

import java.math.BigDecimal;

/**
 * @author Romina E. Mansilla - UNLA
 *
 */
public class TipoHabitacionPorTemporada {

	Temporada temporada;
	TipoHabitacion tipoHabitacion;
	BigDecimal precioPorNoche;

	/** Es por persona */
	public TipoHabitacionPorTemporada() {
	}

	public TipoHabitacionPorTemporada(Temporada temporada, TipoHabitacion tipoHabitacion, BigDecimal precioPorNoche) {
		super();
		this.temporada = temporada;
		this.tipoHabitacion = tipoHabitacion;
		this.precioPorNoche = precioPorNoche;
	}

	public Temporada getTemporada() {
		return temporada;
	}

	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}

	public TipoHabitacion getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public BigDecimal getPrecioPorNoche() {
		return precioPorNoche;
	}

	public void setPrecioPorNoche(BigDecimal precioPorNoche) {
		this.precioPorNoche = precioPorNoche;
	}

}
