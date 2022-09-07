package sgh.mansilla.modelo.negocio.hotel;

import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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
import org.springframework.util.CollectionUtils;

import sgh.mansilla.modelo.dao.AbstractDao.OrderType;
import sgh.mansilla.modelo.dao.DaoGenerico;
import sgh.mansilla.modelo.datos.estadia.Estadia;
import sgh.mansilla.modelo.datos.hotel.CaracteristicaHabitacion;
import sgh.mansilla.modelo.datos.hotel.EstadoHabitacion;
import sgh.mansilla.modelo.datos.hotel.Habitacion;
import sgh.mansilla.modelo.datos.hotel.Hotel;
import sgh.mansilla.modelo.datos.hotel.TipoHabitacion;
import sgh.mansilla.modelo.negocio.ABMGenerico;

@Service("habitacionABM")
@Transactional
public class DefaultHabitacionABM extends ABMGenerico<Integer, Habitacion> implements HabitacionABM {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EstadoHabitacionABM estadoHabitacionABM;

	@Autowired
	TipoHabitacionABM tipoHabitacionABM;

	@Autowired
	HotelABM hotelABM;

	@Autowired
	CaracteristicaHabitacionABM caracteristicaHabitacionABM;

	@Override
	@Autowired
	@Qualifier("habitacionDao")
	public void setDao(DaoGenerico<Integer, Habitacion> dao) {
		super.setDao(dao);
	}

	@Override
	public void guardar(Habitacion entidad) {

		EstadoHabitacion attachedEstadoHabitacion = estadoHabitacionABM.buscarPorId(entidad.getEstadoHabitacion().getId());
		entidad.setEstadoHabitacion(attachedEstadoHabitacion);

		TipoHabitacion attachedTipoHabitacion = tipoHabitacionABM.buscarPorId(entidad.getTipoHabitacion().getId());
		entidad.setTipoHabitacion(attachedTipoHabitacion);

		Hotel attachedHotel = hotelABM.buscarPorId(entidad.getHotel().getId());
		entidad.setHotel(attachedHotel);

		super.guardar(entidad);
	}

	@Override
	protected void actualizarEntidad(Habitacion entidadPersistida, Habitacion entidadActualizada) {
		entidadPersistida.setDescripcion(entidadActualizada.getDescripcion());
		EstadoHabitacion attachedEstadoHabitacion = estadoHabitacionABM
				.buscarPorId(entidadActualizada.getEstadoHabitacion().getId());
		entidadPersistida.setEstadoHabitacion(attachedEstadoHabitacion);

		TipoHabitacion attachedTipoHabitacion = tipoHabitacionABM
				.buscarPorId(entidadActualizada.getTipoHabitacion().getId());
		entidadPersistida.setTipoHabitacion(attachedTipoHabitacion);

		Hotel attachedHotel = hotelABM.buscarPorId(entidadActualizada.getHotel().getId());
		entidadPersistida.setHotel(attachedHotel);

		Set<CaracteristicaHabitacion> caracteristicas = entidadActualizada.getCaracteristicas();
		if (!CollectionUtils.isEmpty(caracteristicas)) {
			Set<CaracteristicaHabitacion> attachedCaracteristicaHabitacion = new LinkedHashSet<CaracteristicaHabitacion>();

			for (CaracteristicaHabitacion ch : entidadActualizada.getCaracteristicas()) {
				attachedCaracteristicaHabitacion.add(caracteristicaHabitacionABM.buscarPorId(ch.getId()));
			}
			entidadPersistida.setCaracteristicas(attachedCaracteristicaHabitacion);
		}
	}


	@Override
	public List<Habitacion> listar() {
		return dao.list(true, OrderType.ASCENDING, "idHabitacion");
	}

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@SuppressWarnings("unchecked")
	public List<Habitacion> listarHabitacionesLibresPorEstadia(Integer idEstadia) {

		Query query = getSession().createSQLQuery(
				"SELECT h.* FROM sgh.habitacion as h "
				+ "inner join (select h.idHabitacion, th.capacidad from sgh.habitacion as h "
				+ "inner join sgh.tipohabitacion as th on h.idTipoHabitacion = th.idTipoHabitacion "
				+ "left join pasajeroestadia as pe  on pe.idHabitacion = h.idHabitacion "
				+ "where pe.idEstadia =  '"+ idEstadia +"' group by pe.idEstadia, pe.idHabitacion "
				+ "having count(*) < th.capacidad) as v on h.idHabitacion = v.idHabitacion "
				+ "Union "
				+ "SELECT h.* FROM sgh.habitacion as h where h.idHabitacion not in "
				+ "(SELECT distinct pe.idHabitacion FROM sgh.pasajeroestadia pe inner join sgh.estadia e "
				+ "on pe.idEstadia = e.idEstadia and e.idEstadoEstadia <> '4'  where "
				+ "(e.diaCheckIn >= (select diaCheckIn from sgh.estadia where estadia.idEstadia = '"+ idEstadia +"') "
				+ "and e.diaCheckOut <= (select diaCheckOut from sgh.estadia where estadia.idEstadia = '"+ idEstadia +"')) "
				+ "or(e.diaCheckIn < (select diaCheckIn from sgh.estadia where estadia.idEstadia = '"+ idEstadia +"') "
				+ "and  e.diaCheckOut > (select diaCheckOut from sgh.estadia where estadia.idEstadia = '"+ idEstadia +"' )) "
				+ "or(e.diaCheckIn >= (select diaCheckIn from sgh.estadia where estadia.idEstadia = '"+ idEstadia +"') "
				+ "and  e.diaCheckIn <= (select diaCheckOut from sgh.estadia where estadia.idEstadia = '"+ idEstadia +"' )) "
				+ "or(e.diaCheckOut >= (select diaCheckIn from sgh.estadia where estadia.idEstadia = '"+ idEstadia +"') "
				+ "and  e.diaCheckOut <= (select diaCheckOut from sgh.estadia where estadia.idEstadia = '"+ idEstadia +"' )))"
				).addEntity("habitacion", Habitacion.class);

		query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Habitacion> resultado = query.list();

		return resultado;
	}

	@SuppressWarnings("unchecked")
	public List<Habitacion> listarHabitacionesLibresPorEstadiayPE(Integer idEstadia, Integer idPE) {

		Query query = getSession().createSQLQuery("select distinct h.* from sgh.estadia e "
				+ "left join sgh.pasajeroestadia pe on e.idEstadia = pe.idEstadia "
				+ "inner join habitacion as h on pe.idHabitacion = h.idHabitacion "
				+ "where pe.idPasajeroEstadia = '"+ idPE +"' "
				+ "UNION "
				+ "SELECT h.* FROM sgh.habitacion as h "
				+ "inner join (select h.idHabitacion, th.capacidad from sgh.habitacion as h "
				+ "inner join sgh.tipohabitacion as th on h.idTipoHabitacion = th.idTipoHabitacion "
				+ "left join pasajeroestadia as pe  on pe.idHabitacion = h.idHabitacion "
				+ "where pe.idEstadia =  '"+ idEstadia +"' group by pe.idEstadia, pe.idHabitacion "
				+ "having count(*) < th.capacidad) as v on h.idHabitacion = v.idHabitacion "
				+ "Union "
				+ "SELECT h.* FROM sgh.habitacion as h where h.idHabitacion not in "
				+ "(SELECT distinct pe.idHabitacion FROM sgh.pasajeroestadia pe inner join sgh.estadia e "
				+ "on pe.idEstadia = e.idEstadia  and e.idEstadoEstadia <> '4'  where "
				+ "(e.diaCheckIn >= (select diaCheckIn from sgh.estadia where estadia.idEstadia = '"+ idEstadia +"') "
				+ "and e.diaCheckOut <= (select diaCheckOut from sgh.estadia where estadia.idEstadia = '"+ idEstadia +"')) "
				+ "or(e.diaCheckIn < (select diaCheckIn from sgh.estadia where estadia.idEstadia = '"+ idEstadia +"') "
				+ "and  e.diaCheckOut > (select diaCheckOut from sgh.estadia where estadia.idEstadia = '"+ idEstadia +"' )) "
				+ "or(e.diaCheckIn >= (select diaCheckIn from sgh.estadia where estadia.idEstadia = '"+ idEstadia +"') "
				+ "and  e.diaCheckIn <= (select diaCheckOut from sgh.estadia where estadia.idEstadia = '"+ idEstadia +"' )) "
				+ "or(e.diaCheckOut >= (select diaCheckIn from sgh.estadia where estadia.idEstadia = '"+ idEstadia +"') "
				+ "and  e.diaCheckOut <= (select diaCheckOut from sgh.estadia where estadia.idEstadia = '"+ idEstadia +"' )))"
				).addEntity("habitacion", Habitacion.class);

		query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Habitacion> resultado = query.list();

		return resultado;
	}


}
