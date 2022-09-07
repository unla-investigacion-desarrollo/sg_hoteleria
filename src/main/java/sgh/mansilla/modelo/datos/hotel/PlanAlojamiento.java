package sgh.mansilla.modelo.datos.hotel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


import sgh.mansilla.modelo.dao.Identificable;

public class PlanAlojamiento implements Identificable<Integer>, Serializable{
	Integer idPlanAlojamiento;
	String plan;
	BigDecimal precioExtraPorNoche;
	Set<Servicio> lstServicio  = new HashSet <Servicio>();

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return idPlanAlojamiento;
	}

	public PlanAlojamiento() {
	}

	public PlanAlojamiento(Integer idPlanAlojamiento, String plan, BigDecimal precioExtraPorNoche,
			Set<Servicio> lstServicio) {
		super();
		this.idPlanAlojamiento = idPlanAlojamiento;
		this.plan = plan;
		this.precioExtraPorNoche = precioExtraPorNoche;
		this.lstServicio = lstServicio;
	}

	public Integer getIdPlanAlojamiento() {
		return idPlanAlojamiento;
	}

	public void setIdPlanAlojamiento(Integer idPlanAlojamiento) {
		this.idPlanAlojamiento = idPlanAlojamiento;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public BigDecimal getPrecioExtraPorNoche() {
		return precioExtraPorNoche;
	}

	public void setPrecioExtraPorNoche(BigDecimal precioExtraPorNoche) {
		this.precioExtraPorNoche = precioExtraPorNoche;
	}


	public Set<Servicio> getLstServicio() {
		return lstServicio;
	}


	public void setLstServicio(Set<Servicio> lstServicio) {
		this.lstServicio = lstServicio;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PlanAlojamiento [id=").append(idPlanAlojamiento).append(", ");
		if (plan != null)
			builder.append("plan=").append(plan).append(", ");
		if (precioExtraPorNoche != null)
			builder.append("precioExtraPorNoche=").append(precioExtraPorNoche).append(", ");
		if (lstServicio != null)
			builder.append("lstServicio=").append(lstServicio);
		builder.append("]");
		return builder.toString();
	}



}
