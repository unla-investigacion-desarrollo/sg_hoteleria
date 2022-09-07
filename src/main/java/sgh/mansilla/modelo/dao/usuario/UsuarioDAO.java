package sgh.mansilla.modelo.dao.usuario;


import sgh.mansilla.modelo.dao.DaoGenerico;
import sgh.mansilla.modelo.datos.usuario.Usuario;


public interface UsuarioDAO extends DaoGenerico<Integer, Usuario>  {

	Usuario findBySSO(String sso);

}

