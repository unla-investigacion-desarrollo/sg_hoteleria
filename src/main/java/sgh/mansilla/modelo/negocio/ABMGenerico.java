package sgh.mansilla.modelo.negocio;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sgh.mansilla.modelo.dao.AbstractDao.OrderType;
import sgh.mansilla.modelo.dao.DaoGenerico;
import sgh.mansilla.modelo.dao.Identificable;

/**
 * @author Romina Mansilla
 *
 * @param <ID>
 * @param <ENTIDAD>
 */
@Transactional
public abstract class ABMGenerico<ID extends Serializable, ENTIDAD extends Identificable<ID>>
		implements ABM<ID, ENTIDAD> {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	protected DaoGenerico<ID, ENTIDAD> dao;

	public void setDao(DaoGenerico<ID, ENTIDAD> dao) {
		this.dao = dao;
	}

	public ENTIDAD buscarPorId(ID id) {
		return dao.getByKey(id);
	}

	@Override
	public void guardar(ENTIDAD entidad) {
		dao.persist(entidad);
	}

	public List<ENTIDAD> listar() {
		return dao.list(true, OrderType.ASCENDING, "id");
	}

	public void eliminarPorId(ID id) {
		dao.delete(buscarPorId(id));
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate
	 * update explicitly. Just fetch the entity from db and update it with
	 * proper values within transaction. It will be updated in db once
	 * transaction ends.
	 */
	public void actualizar(ENTIDAD entidadActualizada) {
		ENTIDAD entidadPersistida = dao.getByKey(entidadActualizada.getId());
		if (entidadPersistida != null) {

			actualizarEntidad(entidadPersistida, entidadActualizada);
		}
	}

	protected abstract void actualizarEntidad(ENTIDAD entidadPersistida, ENTIDAD entidadActualizada);
}
