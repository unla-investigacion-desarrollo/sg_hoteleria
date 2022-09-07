package sgh.mansilla.modelo.dao.estadia;

import org.springframework.stereotype.Repository;

import sgh.mansilla.modelo.dao.AbstractDao;
import sgh.mansilla.modelo.datos.estadia.EstadoEstadia;

@Repository("estadoEstadiaDao")
public class HEstadoEstadiaDao extends AbstractDao<Integer, EstadoEstadia> implements EstadoEstadiaDao {


}
