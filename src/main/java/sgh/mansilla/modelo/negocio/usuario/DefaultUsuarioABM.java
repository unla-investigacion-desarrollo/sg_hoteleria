package sgh.mansilla.modelo.negocio.usuario;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import sgh.mansilla.modelo.dao.AbstractDao.OrderType;
import sgh.mansilla.modelo.dao.usuario.UsuarioDAO;
import sgh.mansilla.modelo.datos.usuario.User;
import sgh.mansilla.modelo.datos.usuario.Usuario;

@Service("usuarioABM")
@Transactional
public class DefaultUsuarioABM implements UsuarioABM{

	@Autowired
	UsuarioDAO dao;

	@Autowired
    private PasswordEncoder passwordEncoder;

	public Usuario findById(int id) {
		return dao.getByKey(id);
	}

	public Usuario findBySSO(String sso) {
		Usuario user = dao.findBySSO(sso);
		return user;
	}

	public void saveUser(Usuario user) {
		user.setPassLogin(passwordEncoder.encode(user.getPassLogin()));
		dao.persist(user);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends.
	 */
	public void updateUser(Usuario user) {
		Usuario entity = dao.getByKey(user.getId());
		if(entity!=null){
			entity.setIdUsuario(user.getIdUsuario());
			if(!user.getPassLogin().equals(entity.getPassLogin())){
				entity.setPassLogin(passwordEncoder.encode(user.getPassLogin()));
			}
			entity.setUserLogin(user.getUserLogin());
			entity.setActivo(user.getActivo());
			entity.setPrivilegioUsuario(user.getPrivilegioUsuario());
		}
	}


	public void deleteUserBySSO(String sso) {
		Usuario entity = dao.findBySSO(sso);
		dao.delete(entity);
	}

	public List<Usuario> findAllUsers() {
		return dao.list(true, OrderType.ASCENDING, "idUsuario");
	}

	public boolean isUserSSOUnique(Integer id, String sso) {
		Usuario user = findBySSO(sso);
		return ( user == null || ((id != null) && (user.getId() == id)));
	}

}
