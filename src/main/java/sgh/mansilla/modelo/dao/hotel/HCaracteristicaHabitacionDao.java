package sgh.mansilla.modelo.dao.hotel;

import org.springframework.stereotype.Repository;

import sgh.mansilla.modelo.dao.AbstractDao;
import sgh.mansilla.modelo.datos.hotel.CaracteristicaHabitacion;

@Repository("caracteristicaHabitacionDao")
public class HCaracteristicaHabitacionDao extends AbstractDao<Integer, CaracteristicaHabitacion> implements CaracteristicaHabitacionDao {


}