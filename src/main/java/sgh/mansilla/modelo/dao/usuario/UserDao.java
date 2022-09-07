package sgh.mansilla.modelo.dao.usuario;

import java.util.List;

import sgh.mansilla.modelo.datos.usuario.User;


public interface UserDao {

	User findById(int id);
	
	User findBySSO(String sso);
	
	void save(User user);
	
	void deleteBySSO(String sso);
	
	List<User> findAllUsers();

}

