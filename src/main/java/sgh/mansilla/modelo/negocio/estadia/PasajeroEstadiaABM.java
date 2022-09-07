package sgh.mansilla.modelo.negocio.estadia;

import java.util.Calendar;
import java.util.List;

import sgh.mansilla.modelo.datos.estadia.Estadia;
import sgh.mansilla.modelo.datos.estadia.PasajeroEstadia;
import sgh.mansilla.modelo.datos.hotel.Habitacion;
import sgh.mansilla.modelo.negocio.ABM;


public interface PasajeroEstadiaABM extends ABM<Integer, PasajeroEstadia> {

	List<PasajeroEstadia> listarPasajeroEstadiaPorEstadia(Estadia estadia);
	List<Estadia>listarEstadiasPorHabitacion(Habitacion habitacion)  ;
	List<Habitacion> listarHabitacionesPorEstadia(Estadia estadia);
	List<Habitacion> listarHabitacionesPorEstadiayFecha(Estadia estadia, Calendar fecha);

}