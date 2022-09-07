package sgh.mansilla.modelo.dao.usuario;


import sgh.mansilla.modelo.dao.DaoGenerico;
import sgh.mansilla.modelo.datos.usuario.Privilegio;


public interface PrivilegioDAO extends DaoGenerico<Integer, Privilegio>  {

	Privilegio findByType(String type);

}

