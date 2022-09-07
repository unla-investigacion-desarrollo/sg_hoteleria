package sgh.mansilla.modelo.negocio.usuario;

import java.util.List;

import sgh.mansilla.modelo.datos.usuario.Privilegio;

public interface PrivilegioABM {

	Privilegio findById(int id);

	Privilegio findByType(String type);

	List<Privilegio> findAll();
}
