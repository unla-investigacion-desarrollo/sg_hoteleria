package sgh.mansilla.modelo.datos.estadia;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import sgh.mansilla.modelo.dao.Identificable;
import sgh.mansilla.modelo.datos.cuenta.Cuenta;
import sgh.mansilla.modelo.datos.hotel.PlanAlojamiento;

public class Estadia implements Identificable<Integer>{
	private Integer idEstadia;
	private EstadoEstadia estadoEstadia;
	private PlanAlojamiento planAlojamiento;
	private BigDecimal precioPorNoche;
	private Cuenta cuenta;
	private Date diaCheckIn;
	private Date diaCheckOut;
    private String comentario;


    @Override
	public Integer getId() {
		return idEstadia;
	}

	public Estadia() {
	}



	public Estadia(Integer idEstadia, EstadoEstadia estadoEstadia, PlanAlojamiento planAlojamiento,
			BigDecimal precioPorNoche, Date diaCheckIn, Date diaCheckOut, String comentario) {
		super();
		this.idEstadia = idEstadia;
		this.estadoEstadia = estadoEstadia;
		this.planAlojamiento = planAlojamiento;
		this.precioPorNoche = precioPorNoche;
		this.diaCheckIn = diaCheckIn;
		this.diaCheckOut = diaCheckOut;
		this.comentario = comentario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}


	public Integer getIdEstadia() {
		return idEstadia;
	}

	public void setIdEstadia(Integer idEstadia) {
		this.idEstadia = idEstadia;
	}

	public EstadoEstadia getEstadoEstadia() {
		return estadoEstadia;
	}

	public void setEstadoEstadia(EstadoEstadia estadoEstadia) {
		this.estadoEstadia = estadoEstadia;
	}


	public PlanAlojamiento getPlanAlojamiento() {
		return planAlojamiento;
	}


	public void setPlanAlojamiento(PlanAlojamiento planAlojamiento) {
		this.planAlojamiento = planAlojamiento;
	}

	public BigDecimal getPrecioPorNoche() {
		return precioPorNoche;
	}

	public void setPrecioPorNoche(BigDecimal precioPorNoche) {
		this.precioPorNoche = precioPorNoche;
	}
	
	public String getDescripcion() {
		return "Nro. " + idEstadia +" ( "+estadoEstadia.getEstado()+" )";
	}

	@Transient
	public Cuenta getCuenta() {
		return cuenta;
	}

	@Transient
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}


	public Date getDiaCheckIn() {
		return diaCheckIn;
	}

	public void setDiaCheckIn(Date diaCheckIn) {
		this.diaCheckIn = diaCheckIn;
	}

	public Date getDiaCheckOut() {
		return diaCheckOut;
	}

	public void setDiaCheckOut(Date diaCheckOut) {
		this.diaCheckOut = diaCheckOut;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Estadia [");
		if (idEstadia != null)
			builder.append("idEstadia=").append(idEstadia).append(", ");
		if (estadoEstadia != null)
			builder.append("estadoEstadia=").append(estadoEstadia).append(", ");
		if (diaCheckIn != null)
			builder.append("diaCheckIn=").append(diaCheckIn).append(", ");
		if (diaCheckOut != null)
			builder.append("diaCheckOut=").append(diaCheckOut).append(",");
		if (comentario != null)
			builder.append("comentario=").append(comentario);
		builder.append("]");
		return builder.toString();
	}


}
