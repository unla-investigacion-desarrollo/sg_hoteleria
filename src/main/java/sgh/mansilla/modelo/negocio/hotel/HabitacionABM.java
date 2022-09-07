package sgh.mansilla.modelo.negocio.hotel;


import java.util.Calendar;
import java.util.List;

import sgh.mansilla.modelo.datos.estadia.Estadia;
import sgh.mansilla.modelo.datos.hotel.Habitacion;
import sgh.mansilla.modelo.negocio.ABM;


public interface HabitacionABM extends ABM<Integer, Habitacion> {

	List<Habitacion> listarHabitacionesLibresPorEstadia(Integer idEstadia);
	List<Habitacion> listarHabitacionesLibresPorEstadiayPE(Integer idEstadia, Integer idPE);

}