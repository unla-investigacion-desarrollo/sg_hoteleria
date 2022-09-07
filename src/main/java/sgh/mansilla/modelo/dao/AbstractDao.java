package sgh.mansilla.modelo.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<PK extends Serializable, T> implements DaoGenerico<PK, T> {

	final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see sgh.mansilla.modelo.dao.DaoGenerico#getByKey(PK)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public T getByKey(PK key) {
		return (T) getSession().get(persistentClass, key);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see sgh.mansilla.modelo.dao.DaoGenerico#persist(T)
	 */
	@Override
	public void persist(T entity) {
		// getSession().persist(entity);
		getSession().save(entity);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see sgh.mansilla.modelo.dao.DaoGenerico#update(T)
	 */
	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see sgh.mansilla.modelo.dao.DaoGenerico#delete(T)
	 */
	@Override
	public void delete(T entity) {
		getSession().delete(entity);
	}

	protected Criteria createEntityCriteria() {
		return getSession().createCriteria(persistentClass);
	}

	public static enum OrderType {
		ASCENDING, DESCENDING;

		public void configure(Criteria criteria, String[] orderByProperties) {
			if (orderByProperties != null) {
				switch (this) {
				case ASCENDING:
					for (String order : orderByProperties) {
						criteria.addOrder(Order.asc(order));
					}
					break;

				case DESCENDING:
					for (String order : orderByProperties) {
						criteria.addOrder(Order.desc(order));
					}
					break;
				}

			}
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see sgh.mansilla.modelo.dao.DaoGenerico#list(boolean,
	 * sgh.mansilla.modelo.dao.AbstractDao.OrderType, java.lang.String)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<T> list(boolean avoidDuplicates, OrderType orderType, String... orderByProperties) {

		Criteria criteria = createEntityCriteria();
		orderType.configure(criteria, orderByProperties);

		if (avoidDuplicates) {
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		}
		return (List<T>) criteria.list();
	}

}
