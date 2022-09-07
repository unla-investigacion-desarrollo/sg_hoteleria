package sgh.mansilla.modelo.dao.persona;

import org.springframework.stereotype.Repository;

import sgh.mansilla.modelo.dao.AbstractDao;
import sgh.mansilla.modelo.datos.persona.TipoDocumento;

@Repository("tipoDocumentoDao")
public class HTipoDocumentoDao extends AbstractDao<Integer, TipoDocumento> implements TipoDocumentoDao {


}
