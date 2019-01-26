package com.edgb.cdhcentaure.service.booking;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgb.cdhcentaure.DAO.booking.IBookingDAO;
import com.edgb.cdhcentaure.model.Booking;

@Service
public class BookingService implements IBookingService {

	@Autowired
	private IBookingDAO bookingDAO;
	
	@Override
	public List<Booking> getAll() {
		return bookingDAO.getAll();
	}

	@Override
	public Booking getById(int id) {
		return bookingDAO.getById(id);
	}

	@Override
	public synchronized boolean add(Booking booking) {
		if (bookingDAO.exists(booking.getId())) {
            return false;
        } else {
            bookingDAO.add(booking);
            return true;
        }
	}

	@Override
	public void update(Booking booking) {
		bookingDAO.update(booking);
	} 

	@Override
	public synchronized boolean delete(int id) {
		if(bookingDAO.exists(id)) {
			bookingDAO.delete(id);	
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public List<Booking> getBookingsByYear(int year) {
		return bookingDAO.getBookingsByYear(year);
	}

	@Override
	public List<Booking> getBookingsByYearAndMonth(int year, int month) {
		return bookingDAO.getBookingsByYearAndMonth(year,month);
	}

}
