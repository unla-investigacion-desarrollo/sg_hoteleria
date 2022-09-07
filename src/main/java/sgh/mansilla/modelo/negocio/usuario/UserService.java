package sgh.mansilla.modelo.negocio.usuario;

import java.util.List;

import sgh.mansilla.modelo.datos.usuario.User;


public interface UserService {

	User findById(int id);

	User findBySSO(String sso);

	void saveUser(User user);

	void updateUser(User user);

	void deleteUserBySSO(String sso);

	List<User> findAllUsers();

	boolean isUserSSOUnique(Integer id, String sso);

}