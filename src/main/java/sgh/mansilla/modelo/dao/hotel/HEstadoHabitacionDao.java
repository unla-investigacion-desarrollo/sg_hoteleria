package sgh.mansilla.modelo.dao.hotel;

import org.springframework.stereotype.Repository;

import sgh.mansilla.modelo.dao.AbstractDao;
import sgh.mansilla.modelo.datos.hotel.EstadoHabitacion;

@Repository("estadoHabitacionDao")
public class HEstadoHabitacionDao extends AbstractDao<Integer, EstadoHabitacion> implements EstadoHabitacionDao {


}