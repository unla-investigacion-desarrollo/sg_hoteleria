package sgh.mansilla.modelo.negocio.persona;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import sgh.mansilla.modelo.dao.AbstractDao.OrderType;
import sgh.mansilla.modelo.dao.DaoGenerico;
import sgh.mansilla.modelo.datos.persona.Organizacion;
import sgh.mansilla.modelo.negocio.ABMGenerico;

@Service("organizacionABM")
@Transactional
public class DefaultOrganizacionABM extends ABMGenerico<Integer, Organizacion> implements OrganizacionABM {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	@Autowired
	@Qualifier("organizacionDao")
	public void setDao(DaoGenerico<Integer, Organizacion> dao) {
		super.setDao(dao);
	}

	@Override
	public void guardar(Organizacion entidad) {
		super.guardar(entidad);
	}

	@Override
	protected void actualizarEntidad(Organizacion entidadPersistida, Organizacion entidadActualizada) {
		entidadPersistida.setTelefono(entidadActualizada.getTelefono());
		entidadPersistida.setEmail(entidadActualizada.getEmail());
		entidadPersistida.setRazonSocial(entidadActualizada.getRazonSocial());
		entidadPersistida.setCuit(entidadActualizada.getCuit());
	}

	@Override
	public List<Organizacion> listar() {
		return dao.list(true, OrderType.ASCENDING, "idContacto");
	}
}
