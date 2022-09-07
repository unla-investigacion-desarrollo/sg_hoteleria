package sgh.mansilla.modelo.negocio.estadia;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import sgh.mansilla.modelo.dao.AbstractDao.OrderType;
import sgh.mansilla.modelo.dao.DaoGenerico;
import sgh.mansilla.modelo.datos.estadia.Estadia;
import sgh.mansilla.modelo.datos.estadia.EstadoEstadia;
import sgh.mansilla.modelo.datos.hotel.PlanAlojamiento;
import sgh.mansilla.modelo.negocio.ABMGenerico;
import sgh.mansilla.modelo.negocio.hotel.PlanAlojamientoABM;

@Service("estadiaABM")
@Transactional
public class DefaultEstadiaABM extends ABMGenerico<Integer, Estadia> implements EstadiaABM {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EstadoEstadiaABM estadoEstadiaABM;

	@Autowired
	PlanAlojamientoABM planAlojamientoABM;

	@Override
	@Autowired
	@Qualifier("estadiaDao")
	public void setDao(DaoGenerico<Integer, Estadia> dao) {
		super.setDao(dao);
	}

	@Override
	public void guardar(Estadia entidad) {
		PlanAlojamiento attachedPlan = planAlojamientoABM.buscarPorId(entidad.getPlanAlojamiento().getId());
		entidad.setPlanAlojamiento(attachedPlan);

		EstadoEstadia attachedEstado = estadoEstadiaABM.buscarPorId(entidad.getEstadoEstadia().getId());
		entidad.setEstadoEstadia(attachedEstado);

		super.guardar(entidad);
	}

	@Override
	protected void actualizarEntidad(Estadia entidadPersistida, Estadia entidadActualizada) {

		entidadPersistida.setPrecioPorNoche(entidadActualizada.getPrecioPorNoche());
		Boolean cambioFecha = false;
		//la nueva fecha inicio es posterior a la anterior que no a la final
		if((entidadPersistida.getDiaCheckIn().compareTo(entidadActualizada.getDiaCheckIn())<=0)
				&& (entidadActualizada.getDiaCheckIn().compareTo(entidadPersistida.getDiaCheckOut())<=0)){
			entidadPersistida.setDiaCheckIn(entidadActualizada.getDiaCheckIn());
			cambioFecha = true;
		}
		if(cambioFecha){
			if((entidadActualizada.getDiaCheckOut().compareTo(entidadActualizada.getDiaCheckIn())>=0)
					&& (entidadActualizada.getDiaCheckOut().compareTo(entidadPersistida.getDiaCheckOut())<=0)){
				entidadPersistida.setDiaCheckOut(entidadActualizada.getDiaCheckOut());
			}
		} else {
			if((entidadActualizada.getDiaCheckOut().compareTo(entidadPersistida.getDiaCheckIn())>=0)
					&& (entidadActualizada.getDiaCheckOut().compareTo(entidadPersistida.getDiaCheckOut())<=0)){
				entidadPersistida.setDiaCheckOut(entidadActualizada.getDiaCheckOut());
			}
		}
		entidadPersistida.setComentario(entidadActualizada.getComentario());


		PlanAlojamiento attachedPlan = planAlojamientoABM.buscarPorId(entidadActualizada.getPlanAlojamiento().getId());
		entidadPersistida.setPlanAlojamiento(attachedPlan);

		EstadoEstadia attachedEstado = estadoEstadiaABM.buscarPorId(entidadActualizada.getEstadoEstadia().getId());
		entidadPersistida.setEstadoEstadia(attachedEstado);

	}

	@Override
	public List<Estadia> listar() {
		return dao.list(true, OrderType.ASCENDING, "idEstadia");
	}
}
