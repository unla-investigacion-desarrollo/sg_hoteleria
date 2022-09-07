package sgh.mansilla.modelo.dao.persona;

import org.springframework.stereotype.Repository;

import sgh.mansilla.modelo.dao.AbstractDao;
import sgh.mansilla.modelo.datos.persona.Pasajero;

@Repository("pasajeroDao")
public class HPasajeroDao extends AbstractDao<Integer, Pasajero> implements PasajeroDao {


}
