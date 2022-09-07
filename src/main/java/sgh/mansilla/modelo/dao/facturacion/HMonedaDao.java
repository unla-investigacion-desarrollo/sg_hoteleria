package sgh.mansilla.modelo.dao.facturacion;

import org.springframework.stereotype.Repository;

import sgh.mansilla.modelo.dao.AbstractDao;
import sgh.mansilla.modelo.datos.facturacion.Moneda;

@Repository("monedaDao")
public class HMonedaDao extends AbstractDao<Integer, Moneda> implements MonedaDao {


}
