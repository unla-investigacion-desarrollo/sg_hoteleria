package sgh.mansilla.modelo.dao.estadia;

import org.springframework.stereotype.Repository;

import sgh.mansilla.modelo.dao.AbstractDao;
import sgh.mansilla.modelo.datos.estadia.Estadia;

@Repository("estadiaDao")
public class HEstadiaDao extends AbstractDao<Integer, Estadia> implements EstadiaDao {


}
