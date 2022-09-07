package sgh.mansilla.modelo.datos.estadia;

import javax.persistence.Transient;

import sgh.mansilla.modelo.dao.Identificable;

public class EstadoEstadia implements Identificable<Integer> {
	
	public static final int CANCELADA = 4;
	
	private int idEstadoEstadia;
	private String estado;
	private String color;

	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}

	public String getColorTraducido(){
		String nuevoColor = "green";
		if (color.equalsIgnoreCase(new String("coral"))) nuevoColor =  "Coral";
		if (color.equalsIgnoreCase(new String("aquamarine"))) nuevoColor =  "Verde Agua";
		if (color.equalsIgnoreCase(new String("darkgreen")))  nuevoColor =  "Verde Oscuro";
		if (color.equalsIgnoreCase(new String("crimson"))) nuevoColor =  "Rojo Palido";
		if (color.equalsIgnoreCase(new String("dodgerBlue")))  nuevoColor =  "Celeste";
		if (color.equalsIgnoreCase(new String("midnightblue"))) nuevoColor =  "Azul";
		if (color.equalsIgnoreCase(new String("darkcyan"))) nuevoColor =  "Cian";
		if (color.equalsIgnoreCase(new String("gray"))) nuevoColor =  "Gris";
		if (color.equalsIgnoreCase(new String("red"))) nuevoColor =  "Rojo";
		if (color.equalsIgnoreCase(new String("yellow"))) nuevoColor =  "Amarillo";

		return nuevoColor;
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return idEstadoEstadia;
	}

	public EstadoEstadia() {
	}

	public void procesar(){	};
	public void enviarMail(){};

	public EstadoEstadia(int idEstado, String estado, String color) {
		super();
		this.idEstadoEstadia = idEstado;
		this.estado = estado;
		this.color = color;
	}

	public int getIdEstadoEstadia() {
		return idEstadoEstadia;
	}

	public void setIdEstadoEstadia(int idEstado) {
		this.idEstadoEstadia = idEstado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EstadoEstadia [");
		if (estado != null)
			builder.append("estado=").append(estado);
		builder.append("]");
		return builder.toString();
	}



}
