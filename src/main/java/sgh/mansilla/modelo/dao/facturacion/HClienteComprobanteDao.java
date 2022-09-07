package sgh.mansilla.modelo.dao.facturacion;

import org.springframework.stereotype.Repository;

import sgh.mansilla.modelo.dao.AbstractDao;
import sgh.mansilla.modelo.datos.facturacion.Alicuota;
import sgh.mansilla.modelo.datos.facturacion.ClienteComprobante;

@Repository("clienteComprobanteDao")
public class HClienteComprobanteDao extends AbstractDao<Integer, ClienteComprobante> implements ClienteComprobanteDao {


}
