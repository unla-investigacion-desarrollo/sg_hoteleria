package sgh.mansilla.modelo.negocio.persona;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import sgh.mansilla.modelo.dao.AbstractDao.OrderType;
import sgh.mansilla.modelo.dao.DaoGenerico;
import sgh.mansilla.modelo.datos.persona.TipoDocumento;
import sgh.mansilla.modelo.negocio.ABMGenerico;

@Service("tipoDocumentoABM")
@Transactional
public class DefaultTipoDocumentoABM extends ABMGenerico<Integer, TipoDocumento> implements TipoDocumentoABM {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	@Autowired
	@Qualifier("tipoDocumentoDao")
	public void setDao(DaoGenerico<Integer, TipoDocumento> dao) {
		super.setDao(dao);
	}

	@Override
	public void guardar(TipoDocumento entidad) {
		super.guardar(entidad);
	}

	@Override
	protected void actualizarEntidad(TipoDocumento entidadPersistida, TipoDocumento entidadActualizada) {
		entidadPersistida.setDescripcion(entidadActualizada.getDescripcion());
		entidadPersistida.setIdDocumentoAfip(entidadActualizada.getIdDocumentoAfip());
	}

	@Override
	public List<TipoDocumento> listar() {
		return dao.list(true, OrderType.ASCENDING, "idTipoDocumento");
	}
}
