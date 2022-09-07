package sgh.mansilla.modelo.datos.estadia.estado;

import sgh.mansilla.modelo.datos.estadia.EstadoEstadia;

public class Cancelada extends  EstadoEstadia {

	public Cancelada(int idEstado, String estado, String color) {
		super(idEstado, estado,color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void procesar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void enviarMail() {
		// TODO Auto-generated method stub

	}

}
