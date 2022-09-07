package sgh.mansilla.modelo.dao.hotel;

import org.springframework.stereotype.Repository;

import sgh.mansilla.modelo.dao.AbstractDao;
import sgh.mansilla.modelo.datos.hotel.TipoHabitacion;

@Repository("tipoHabitacionDao")
public class HTipoHabitacionDao extends AbstractDao<Integer, TipoHabitacion> implements TipoHabitacionDao {


}