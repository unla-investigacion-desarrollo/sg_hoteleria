package sgh.mansilla.modelo.dao.facturacion;

import org.springframework.stereotype.Repository;

import sgh.mansilla.modelo.dao.AbstractDao;
import sgh.mansilla.modelo.datos.facturacion.Concepto;

@Repository("conceptoDao")
public class HConceptoDao extends AbstractDao<Integer, Concepto> implements ConceptoDao {


}
