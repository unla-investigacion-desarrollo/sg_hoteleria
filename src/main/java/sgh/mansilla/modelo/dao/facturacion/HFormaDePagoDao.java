package sgh.mansilla.modelo.dao.facturacion;

import org.springframework.stereotype.Repository;

import sgh.mansilla.modelo.dao.AbstractDao;
import sgh.mansilla.modelo.datos.facturacion.FormaDePago;

@Repository("formaDePagoDao")
public class HFormaDePagoDao extends AbstractDao<Integer, FormaDePago> implements FormaDePagoDao {


}
