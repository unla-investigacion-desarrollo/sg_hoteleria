package sgh.mansilla.modelo.dao.persona;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import sgh.mansilla.modelo.dao.AbstractDao;
import sgh.mansilla.modelo.dao.persona.CaracteristicaPasajeroDao;
import sgh.mansilla.modelo.dao.usuario.UserDaoImpl;
import sgh.mansilla.modelo.datos.persona.CaracteristicaPasajero;
import sgh.mansilla.modelo.datos.persona.Pasajero;
import sgh.mansilla.modelo.datos.usuario.User;

@Repository("caracteristicaPasajeroDao")
public class HCaracteristicaPasajeroDao extends AbstractDao<Integer, CaracteristicaPasajero> implements CaracteristicaPasajeroDao {
		


}