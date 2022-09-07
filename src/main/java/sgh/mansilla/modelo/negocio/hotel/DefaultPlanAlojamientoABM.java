package sgh.mansilla.modelo.negocio.hotel;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import sgh.mansilla.modelo.dao.AbstractDao.OrderType;
import sgh.mansilla.modelo.dao.DaoGenerico;
import sgh.mansilla.modelo.datos.hotel.CaracteristicaHabitacion;
import sgh.mansilla.modelo.datos.hotel.PlanAlojamiento;
import sgh.mansilla.modelo.datos.hotel.Servicio;
import sgh.mansilla.modelo.negocio.ABMGenerico;
import sgh.mansilla.modelo.negocio.hotel.PlanAlojamientoABM;

@Service("planAlojamientoABM")
@Transactional
public class DefaultPlanAlojamientoABM extends ABMGenerico<Integer, PlanAlojamiento> implements PlanAlojamientoABM {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	ServicioABM servicioABM;

	@Override
	@Autowired
	@Qualifier("planAlojamientoDao")
	public void setDao(DaoGenerico<Integer, PlanAlojamiento> dao) {
		super.setDao(dao);
	}

	@Override
	public void guardar(PlanAlojamiento entidad) {
		super.guardar(entidad);
	}

	@Override
	protected void actualizarEntidad(PlanAlojamiento entidadPersistida, PlanAlojamiento entidadActualizada) {
		entidadPersistida.setPlan(entidadActualizada.getPlan());
		entidadPersistida.setPrecioExtraPorNoche(entidadActualizada.getPrecioExtraPorNoche());

		Set<Servicio> servicios = entidadActualizada.getLstServicio();
		if (!CollectionUtils.isEmpty(servicios)) {
			Set<Servicio> attachedServicio = new LinkedHashSet<Servicio>();
			for (Servicio cp : entidadActualizada.getLstServicio()) {
				attachedServicio.add(servicioABM.buscarPorId(cp.getId()));
			}
			entidadPersistida.setLstServicio(attachedServicio);
		}
	}

	@Override
	public List<PlanAlojamiento> listar() {
		return dao.list(true, OrderType.ASCENDING, "idPlanAlojamiento");
	}
}
