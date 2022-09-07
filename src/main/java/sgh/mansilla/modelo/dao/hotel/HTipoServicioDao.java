package sgh.mansilla.modelo.dao.hotel;

import org.springframework.stereotype.Repository;

import sgh.mansilla.modelo.dao.AbstractDao;
import sgh.mansilla.modelo.datos.hotel.TipoServicio;

@Repository("tipoServicioDao")
public class HTipoServicioDao extends AbstractDao<Integer, TipoServicio> implements TipoServicioDao {


}