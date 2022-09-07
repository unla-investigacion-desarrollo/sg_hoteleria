package sgh.mansilla.modelo.dao.hotel;

import org.springframework.stereotype.Repository;

import sgh.mansilla.modelo.dao.AbstractDao;
import sgh.mansilla.modelo.datos.hotel.Habitacion;

@Repository("habitacionDao")
public class HHabitacionDao extends AbstractDao<Integer, Habitacion> implements HabitacionDao {


}
