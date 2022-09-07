package sgh.mansilla.modelo.negocio.usuario;

import java.util.List;

import sgh.mansilla.modelo.datos.usuario.UserProfile;


public interface UserProfileService {

	UserProfile findById(int id);

	UserProfile findByType(String type);

	List<UserProfile> findAll();

}
