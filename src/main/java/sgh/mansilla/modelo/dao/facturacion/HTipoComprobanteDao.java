package sgh.mansilla.modelo.dao.facturacion;

import org.springframework.stereotype.Repository;

import sgh.mansilla.modelo.dao.AbstractDao;
import sgh.mansilla.modelo.datos.facturacion.TipoComprobante;

@Repository("tipoComprobanteDao")
public class HTipoComprobanteDao extends AbstractDao<Integer, TipoComprobante> implements TipoComprobanteDao {


}
