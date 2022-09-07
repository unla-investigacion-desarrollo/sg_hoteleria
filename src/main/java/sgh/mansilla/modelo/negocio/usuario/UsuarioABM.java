package sgh.mansilla.modelo.negocio.usuario;

import java.util.List;

import sgh.mansilla.modelo.datos.usuario.Usuario;

public interface UsuarioABM {

	Usuario findById(int id);

	Usuario findBySSO(String sso);

	void saveUser(Usuario user);

	void updateUser(Usuario user);

	void deleteUserBySSO(String sso);

	List<Usuario> findAllUsers();

	boolean isUserSSOUnique(Integer id, String sso);
}
