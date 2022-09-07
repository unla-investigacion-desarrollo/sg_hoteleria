package sgh.mansilla.modelo.dao.persona;

import org.springframework.stereotype.Repository;

import sgh.mansilla.modelo.dao.AbstractDao;
import sgh.mansilla.modelo.datos.persona.Organizacion;

@Repository("organizacionDao")
public class HOrganizacionDao extends AbstractDao<Integer, Organizacion> implements OrganizacionDao {


}
