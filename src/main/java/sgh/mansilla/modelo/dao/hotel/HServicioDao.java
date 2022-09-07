package sgh.mansilla.modelo.dao.hotel;

import org.springframework.stereotype.Repository;

import sgh.mansilla.modelo.dao.AbstractDao;
import sgh.mansilla.modelo.datos.hotel.Servicio;

@Repository("servicioDao")
public class HServicioDao extends AbstractDao<Integer, Servicio> implements ServicioDao {


}
