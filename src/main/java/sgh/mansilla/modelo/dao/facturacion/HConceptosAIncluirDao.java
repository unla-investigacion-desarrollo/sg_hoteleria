package sgh.mansilla.modelo.dao.facturacion;

import org.springframework.stereotype.Repository;

import sgh.mansilla.modelo.dao.AbstractDao;
import sgh.mansilla.modelo.datos.facturacion.ConceptosAIncluir;

@Repository("conceptosAIncluirDao")
public class HConceptosAIncluirDao extends AbstractDao<Integer, ConceptosAIncluir> implements ConceptosAIncluirDao {


}
