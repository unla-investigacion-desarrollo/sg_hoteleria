package sgh.mansilla.modelo.negocio.estadia;

import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import sgh.mansilla.modelo.dao.AbstractDao.OrderType;
import sgh.mansilla.modelo.dao.DaoGenerico;
import sgh.mansilla.modelo.datos.estadia.Estadia;
import sgh.mansilla.modelo.datos.estadia.PasajeroEstadia;
import sgh.mansilla.modelo.datos.hotel.Habitacion;
import sgh.mansilla.modelo.datos.persona.Pasajero;
import sgh.mansilla.modelo.negocio.ABMGenerico;
import sgh.mansilla.modelo.negocio.hotel.HabitacionABM;
import sgh.mansilla.modelo.negocio.persona.PasajeroABM;

@Service("pasajeroEstadiaABM")
@Transactional
public class DefaultPasajeroEstadiaABM extends ABMGenerico<Integer, PasajeroEstadia>
	implements PasajeroEstadiaABM {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EstadiaABM estadiaABM;

	@Autowired
	PasajeroABM pasajeroABM;

	@Autowired
	HabitacionABM habitacionABM;

	@Override
	@Autowired
	@Qualifier("pasajeroEstadiaDao")
	public void setDao(DaoGenerico<Integer, PasajeroEstadia> dao) {
		super.setDao(dao);
	}

	@Override
	public void guardar(PasajeroEstadia entidad) {
		Estadia attachedEstadia = estadiaABM.buscarPorId(entidad.getEstadia().getId());
		entidad.setEstadia(attachedEstadia);

		if(entidad.getPasajero() != null){
			Pasajero attachedPasajero = pasajeroABM.buscarPorId(entidad.getPasajero().getId());
			entidad.setPasajero(attachedPasajero);
		}


		Habitacion attachedHabitacion = habitacionABM.buscarPorId(entidad.getHabitacion().getId());
		entidad.setHabitacion(attachedHabitacion);
		
		super.guardar(entidad);
	}

	@Override
	protected void actualizarEntidad(PasajeroEstadia entidadPersistida, PasajeroEstadia entidadActualizada) {
		Estadia attachedEstadia = estadiaABM.buscarPorId(entidadActualizada.getEstadia().getId());
		entidadPersistida.setEstadia(attachedEstadia);

		if(entidadActualizada.getPasajero() != null){
			Pasajero attachedPasajero = pasajeroABM.buscarPorId(entidadActualizada.getPasajero().getId());
			entidadPersistida.setPasajero(attachedPasajero);
		} else {
			entidadPersistida.setPasajero(null);
		}

		Habitacion attachedHabitacion = habitacionABM.buscarPorId(entidadActualizada.getHabitacion().getId());
		entidadPersistida.setHabitacion(attachedHabitacion);
	}

	@Override
	public List<PasajeroEstadia> listar() {
		return dao.list(true, OrderType.ASCENDING, "idPasajeroEstadia");
	}

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<PasajeroEstadia> listarPasajeroEstadiaPorEstadia(Estadia estadia) {

		Query query = getSession().createQuery("from PasajeroEstadia where estadia = :estadia ");
		query.setParameter("estadia", estadia);

		List<PasajeroEstadia> resultado = query.list();

		return resultado;

	}


	@SuppressWarnings("unchecked")
	public List<Estadia> listarEstadiasPorHabitacion(Habitacion habitacion) {

		Query query = getSession().createQuery(
				"select pe.estadia, pe.habitacion "
						+ "from PasajeroEstadia as pe "
						+ "where pe.habitacion = :habitacion ");
		query.setParameter("habitacion", habitacion);
		query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Estadia> resultado = query.list();

		return resultado;

	}



	@SuppressWarnings("unchecked")
	public List<Habitacion> listarHabitacionesPorEstadia(Estadia estadia) {

		Query query = getSession().createQuery(
				"select pe.estadia, pe.habitacion "
						+ "from PasajeroEstadia as pe "
						+ "where pe.estadia = :estadia ");
		query.setParameter("estadia", estadia);
		query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Habitacion> resultado = query.list();

		return resultado;

	}

	@SuppressWarnings("unchecked")
	public List<Habitacion> listarHabitacionesPorEstadiayFecha(Estadia estadia, Calendar fecha) {

		Query query = getSession().createQuery("select pe.estadia, pe.habitacion "
				+ "from PasajeroEstadia as pe , Estadia as e "
				+ "where pe.estadia.idEstadia = e.idEstadia "
				+ "and pe.estadia = :estadia "
				+ "and e.diaCheckIn <= :fecha and e.diaCheckOut >= :fecha" );


		query.setParameter("estadia", estadia);
		query.setDate("fecha", fecha.getTime());

		query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Habitacion> resultado = query.list();

		return resultado;
	}

}
