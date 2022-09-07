package sgh.mansilla.modelo.dao.usuario;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import sgh.mansilla.modelo.dao.AbstractDao;
import sgh.mansilla.modelo.datos.usuario.Privilegio;

@Repository("privilegioDao")
public class HPrivilegioDAO extends AbstractDao<Integer, Privilegio> implements PrivilegioDAO  {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public Privilegio findByType(String type) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("type", type));
		return (Privilegio) crit.uniqueResult();
	}
}




