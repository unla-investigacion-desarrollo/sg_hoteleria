package sgh.mansilla.modelo.dao.facturacion;

import org.springframework.stereotype.Repository;

import sgh.mansilla.modelo.dao.AbstractDao;
import sgh.mansilla.modelo.datos.facturacion.Tributo;

@Repository("tributoDao")
public class HTributoDao extends AbstractDao<Integer, Tributo> implements TributoDao {


}
