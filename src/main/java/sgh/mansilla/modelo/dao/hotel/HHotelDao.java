package sgh.mansilla.modelo.dao.hotel;

import org.springframework.stereotype.Repository;

import sgh.mansilla.modelo.dao.AbstractDao;
import sgh.mansilla.modelo.datos.hotel.Hotel;

@Repository("hotelDao")
public class HHotelDao extends AbstractDao<Integer, Hotel> implements HotelDao {


}
