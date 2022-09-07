package sgh.mansilla.modelo.dao;

import java.io.Serializable;
import java.util.List;

import sgh.mansilla.modelo.dao.AbstractDao.OrderType;

public interface DaoGenerico<PK extends Serializable, T> {

	T getByKey(PK key);

	void persist(T entity);

	void update(T entity);

	void delete(T entity);

	List<T> list(boolean avoidDuplicates, OrderType orderType, String... orderByProperties);

}