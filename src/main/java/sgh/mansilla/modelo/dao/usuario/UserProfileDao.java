package sgh.mansilla.modelo.dao.usuario;

import java.util.List;

import sgh.mansilla.modelo.datos.usuario.UserProfile;


public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
