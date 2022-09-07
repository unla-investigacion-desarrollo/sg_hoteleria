package sgh.mansilla.modelo.dao.estadia;

import org.springframework.stereotype.Repository;

import sgh.mansilla.modelo.dao.AbstractDao;
import sgh.mansilla.modelo.datos.estadia.PasajeroEstadia;

@Repository("pasajeroEstadiaDao")
public class HPasajeroEstadiaDao extends AbstractDao<Integer, PasajeroEstadia> implements PasajeroEstadiaDao {


}
