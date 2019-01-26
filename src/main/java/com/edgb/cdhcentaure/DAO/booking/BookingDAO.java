package com.edgb.cdhcentaure.DAO.booking;

import java.time.LocalDate;
import static java.time.temporal.TemporalAdjusters.firstDayOfYear;
import static java.time.temporal.TemporalAdjusters.lastDayOfYear;
import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.Query;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.edgb.cdhcentaure.model.Booking;

@Transactional
@Repository
public class BookingDAO  implements IBookingDAO {

	@PersistenceContext	
	private EntityManager entityManager;	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Booking> getAll() {
		String request = "FROM Booking as booking ORDER BY booking.id";
		return (List<Booking>) entityManager.createQuery(request).getResultList();
	}

	@Override
	public Booking getById(int id) {
		return entityManager.find(Booking.class, id);
	}

	@Override
	public void add(Booking horse) {
		entityManager.persist(horse);
		
	}

	@Override
	public void update(Booking booking) {
		Booking h = getById(booking.getId());
		//h.setName(horse.getName());
		//h.setAge(horse.getAge());
		//h.setRegistrationNumber(horse.getRegistrationNumber());
		entityManager.flush();
	}

	@Override
	public void delete(int id) {	
		entityManager.remove(getById(id));
	}

	@Override
	public boolean exists(int id) {
		
		String request = "FROM Booking as booking WHERE booking.id = :id";
		int count = entityManager
					.createQuery(request)
					.setParameter("id", id)
					.getResultList()
					.size();
		return count > 0 ? true : false;
	}

	@Override
	public List<Booking> getBookingsByYear(int year) {
		LocalDate initial = LocalDate.ofYearDay(year, 1);
		LocalDate start = initial.with(firstDayOfYear());
		LocalDate end = initial.with(lastDayOfYear());
		String request = "FROM Booking as booking WHERE booking.closed = 0 AND booking.arrival >:start AND booking.arrival <=:end ORDER BY booking.arrival";
		return (List<Booking>) entityManager
				.createQuery(request)
				.setParameter("start", start)
				.setParameter("end", end)
				.getResultList();
	}

	@Override
	public List<Booking> getBookingsByYearAndMonth(int year, int month) {
		LocalDate initial = LocalDate.ofYearDay(year, month);
		LocalDate start = initial.with(firstDayOfMonth());
		LocalDate end = initial.with(lastDayOfMonth());
		String request = "FROM Booking as booking WHERE booking.closed = 0 AND booking.arrival >:start AND booking.arrival <=:end ORDER BY booking.arrival";
		return (List<Booking>) entityManager
				.createQuery(request)
				.setParameter("start", start)
				.setParameter("end", end)
				.getResultList();
	}
}
