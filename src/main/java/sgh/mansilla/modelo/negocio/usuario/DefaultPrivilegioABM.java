package sgh.mansilla.modelo.negocio.usuario;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sgh.mansilla.modelo.dao.AbstractDao.OrderType;
import sgh.mansilla.modelo.dao.usuario.PrivilegioDAO;
import sgh.mansilla.modelo.datos.usuario.Privilegio;

@Service("privilegioABM")
@Transactional
public class DefaultPrivilegioABM implements PrivilegioABM{

	@Autowired
	PrivilegioDAO dao;

	@Override
	public Privilegio findById(int id) {
		return dao.getByKey(id);
	}

	@Override
	public Privilegio findByType(String type) {
		return dao.findByType(type);
	}

	@Override
	public List<Privilegio> findAll() {
		return dao.list(true, OrderType.ASCENDING, "idPrivilegio");
	}

}
