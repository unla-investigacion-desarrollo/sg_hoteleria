package sgh.mansilla.modelo.dao;

import java.io.Serializable;

/**
 * @author Romina Mansilla
 *
 * @param <ID>
 */
public interface Identificable<ID extends Serializable> {

	ID getId();

}
