package sgh.mansilla.modelo.dao.facturacion;

import org.springframework.stereotype.Repository;

import sgh.mansilla.modelo.dao.AbstractDao;
import sgh.mansilla.modelo.datos.facturacion.Comprobante;

@Repository("comprobanteDao")
public class HComprobanteDao extends AbstractDao<Integer, Comprobante> implements ComprobanteDao {


}
