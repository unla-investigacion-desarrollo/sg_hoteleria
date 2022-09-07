package sgh.mansilla.modelo.dao.usuario;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import sgh.mansilla.modelo.dao.AbstractDao;
import sgh.mansilla.modelo.datos.usuario.Usuario;

@Repository("usuarioDao")
public class HUsuarioDAO extends AbstractDao<Integer, Usuario> implements UsuarioDAO  {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	public Usuario findBySSO(String sso) {
		logger.info("SSO : {}", sso);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", sso));
		Usuario user = (Usuario)crit.uniqueResult();
		if(user!=null){
			Hibernate.initialize(user.getPrivilegioUsuario());
		}
		return user;
	}
}




