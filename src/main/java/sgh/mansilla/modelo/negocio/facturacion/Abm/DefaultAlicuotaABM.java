package sgh.mansilla.modelo.negocio.facturacion.Abm;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import sgh.mansilla.modelo.dao.DaoGenerico;
import sgh.mansilla.modelo.dao.AbstractDao.OrderType;
import sgh.mansilla.modelo.datos.facturacion.Alicuota;
import sgh.mansilla.modelo.negocio.ABMGenerico;

@Service("alicuotaABM")
@Transactional
public class DefaultAlicuotaABM extends ABMGenerico<Integer, Alicuota> implements AlicuotaABM {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	@Autowired
	@Qualifier("alicuotaDao")
	public void setDao(DaoGenerico<Integer, Alicuota> dao) {
		super.setDao(dao);
	}

	@Override
	public void guardar(Alicuota entidad) {
		super.guardar(entidad);
	}

	@Override
	protected void actualizarEntidad(Alicuota entidadPersistida, Alicuota entidadActualizada) {

	}

	@Override
	public List<Alicuota> listar() {
		return dao.list(true, OrderType.ASCENDING, "idAlicuota");
	}
}
