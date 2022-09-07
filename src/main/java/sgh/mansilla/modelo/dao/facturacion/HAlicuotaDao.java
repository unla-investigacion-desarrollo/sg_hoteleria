package sgh.mansilla.modelo.dao.facturacion;

import org.springframework.stereotype.Repository;

import sgh.mansilla.modelo.dao.AbstractDao;
import sgh.mansilla.modelo.datos.facturacion.Alicuota;

@Repository("alicuotaDao")
public class HAlicuotaDao extends AbstractDao<Integer, Alicuota> implements AlicuotaDao {


}
