package sgh.mansilla.modelo.negocio.hotel;

import sgh.mansilla.modelo.datos.hotel.Hotel;
import sgh.mansilla.modelo.negocio.ABM;


public interface HotelABM extends ABM<Integer, Hotel> {

	void guardar(Hotel entidad, int idHabitacion);

}