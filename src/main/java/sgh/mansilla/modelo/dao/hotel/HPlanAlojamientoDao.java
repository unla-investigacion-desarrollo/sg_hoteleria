package sgh.mansilla.modelo.dao.hotel;

import org.springframework.stereotype.Repository;

import sgh.mansilla.modelo.dao.AbstractDao;
import sgh.mansilla.modelo.dao.hotel.PlanAlojamientoDao;
import sgh.mansilla.modelo.datos.hotel.PlanAlojamiento;

@Repository("planAlojamientoDao")
public class HPlanAlojamientoDao extends AbstractDao<Integer, PlanAlojamiento> implements PlanAlojamientoDao {


}
