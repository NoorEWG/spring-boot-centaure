package com.edgb.cdhcentaure.DAO.stats;

import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;
import static java.time.temporal.TemporalAdjusters.firstDayOfYear;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.lastDayOfYear;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.edgb.cdhcentaure.model.BookingPaymentStats;
import com.edgb.cdhcentaure.model.BookingRoomStats;
import com.edgb.cdhcentaure.model.GraphData;

@Transactional
@Repository
public class BookingStatsDAO implements IBookingStatsDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public BookingPaymentStats paymentStatsByYear(int year) {

		LocalDate start = LocalDate.of(year, Month.JANUARY, 1);
		LocalDate end = LocalDate.of(year + 1, Month.JANUARY, 1);

		return getBookingPaymentStats(start, end, year);

	}

	@Override
	public BookingPaymentStats paymentStatsByMonth(int year, int month) {

		LocalDate start = LocalDate.of(year, month, 1);
		LocalDate end = LocalDate.of(year, month + 1, 1);

		return getBookingPaymentStats(start, end, year);

	}

	@Override
	public BookingRoomStats roomStatsByYear(int year) {

		LocalDate start = LocalDate.of(year, Month.JANUARY, 1);
		LocalDate end = LocalDate.of(year + 1, Month.JANUARY, 1);

		return getBookingRoomStats(start, end);
	}

	@Override
	public BookingRoomStats roomStatsByMonth(int year, int month) {

		LocalDate start = LocalDate.of(year, month, 1);
		LocalDate end = LocalDate.of(year, month + 1, 1);

		return getBookingRoomStats(start, end);
	}

	public BookingPaymentStats getBookingPaymentStats(LocalDate start, LocalDate end, int year) {

		BookingPaymentStats stats = new BookingPaymentStats();

		String request = "SELECT SUM(booking.price) FROM Booking as booking WHERE booking.closed = 0 AND booking.arrival >=:start AND booking.arrival <:end";
		Long totalPayments = (Long) entityManager.createQuery(request).setParameter("start", start)
				.setParameter("end", end).getSingleResult();

		request = "SELECT SUM(booking.price) FROM Booking as booking WHERE booking.payment =:payment AND booking.closed = 0 AND booking.arrival >=:start AND booking.arrival <:end";
		Long paymentCheque = (Long) entityManager.createQuery(request).setParameter("payment", "cheque")
				.setParameter("start", start).setParameter("end", end).getSingleResult();

		request = "SELECT SUM(booking.price) FROM Booking as booking WHERE booking.payment =:payment AND booking.closed = 0 AND booking.arrival >=:start AND booking.arrival <:end";
		Long paymentCash = (Long) entityManager.createQuery(request).setParameter("payment", "especes")
				.setParameter("start", start).setParameter("end", end).getSingleResult();

		request = "SELECT SUM(booking.price) FROM Booking as booking WHERE booking.booking =:booking AND booking.closed = 0 AND booking.arrival >=:start AND booking.arrival <:end";
		Long paymentBooking = (Long) entityManager.createQuery(request).setParameter("booking", true)
				.setParameter("start", start).setParameter("end", end).getSingleResult();

		request = "SELECT SUM(booking.price) FROM Booking as booking WHERE booking.payment =:payment AND booking.closed = 0 AND booking.arrival >=:start AND booking.arrival <:end";
		Long notPayed = (Long) entityManager.createQuery(request).setParameter("payment", "no")
				.setParameter("start", start).setParameter("end", end).getSingleResult();

		Long paymentOther = totalPayments - paymentCheque - paymentCash - notPayed;
		Long totalPayed = paymentCheque + paymentCash + paymentOther;

		List<Long> turnoverRoom1PerMonth = new ArrayList<Long>();
		List<Long> turnoverRoom2PerMonth = new ArrayList<Long>();
		List<Long> turnoverPerMonth = new ArrayList<Long>();
		List<Long> cumulTurnoverRoom1PerMonth = new ArrayList<Long>();
		List<Long> cumulTurnoverRoom2PerMonth = new ArrayList<Long>();
		List<Long> cumulTurnoverPerMonth = new ArrayList<Long>();

		Long cumulRoom1Month = 0L;
		Long cumulRoom2Month = 0L;
		Long cumulMonth = 0L;

		for (int i = 1; i <= 12; i++) {
			LocalDate start1 = LocalDate.of(year, i, 1);
			LocalDate end1;
			if (i < 12) {
				end1 = LocalDate.of(year, i + 1, 1);
			} else {
				end1 = LocalDate.of(year + 1, 1, 1);
			}

			request = "SELECT SUM(booking.room1Price * booking.nights) FROM Booking as booking WHERE booking.room1 =:room1 AND booking.closed = 0 AND booking.arrival >=:start AND booking.arrival <:end";

			Long room1Month = (Long) entityManager.createQuery(request).setParameter("room1", true)
					.setParameter("start", start1).setParameter("end", end1).getSingleResult();

			if (room1Month == null) {
				room1Month = 0L;
			}

			request = "SELECT SUM(booking.room2Price * booking.nights) FROM Booking as booking WHERE booking.room2 =:room2 AND booking.closed = 0 AND booking.arrival >=:start AND booking.arrival <:end";

			Long room2Month = (Long) entityManager.createQuery(request).setParameter("room2", true)
					.setParameter("start", start1).setParameter("end", end1).getSingleResult();

			if (room2Month == null) {
				room2Month = 0L;
			}

			Long totalMonth = room1Month + room2Month;

			cumulRoom1Month += room1Month;
			cumulRoom2Month += room2Month;
			cumulMonth += totalMonth;

			turnoverRoom1PerMonth.add(room1Month);
			turnoverRoom2PerMonth.add(room2Month);
			turnoverPerMonth.add(totalMonth);
			cumulTurnoverRoom1PerMonth.add(cumulRoom1Month);
			cumulTurnoverRoom2PerMonth.add(cumulRoom2Month);
			cumulTurnoverPerMonth.add(cumulMonth);
			
		}

		stats.setTotalPayments(totalPayments);
		stats.setPaymentCheque(paymentCheque);
		stats.setPaymentCash(paymentCash);
		stats.setNotPayed(notPayed);
		stats.setPaymentOther(paymentOther);
		stats.setTotalPayed(totalPayed);
		stats.setPaymentBooking(paymentBooking);
		stats.setTurnoverPerMonth(turnoverPerMonth);
		stats.setTurnoverRoom1(cumulRoom1Month);
		stats.setTurnoverRoom2(cumulRoom2Month);
		stats.setTurnoverRoom1PerMonth(turnoverRoom1PerMonth);
		stats.setTurnoverRoom2PerMonth(turnoverRoom2PerMonth);
		stats.setCumulTurnoverPerMonth(cumulTurnoverPerMonth);
		stats.setCumulTurnoverRoom1PerMonth(cumulTurnoverRoom1PerMonth);
		stats.setCumulTurnoverRoom2PerMonth(cumulTurnoverRoom2PerMonth);

		GraphData gdr1 = new GraphData();
		gdr1.setName("Chambre Rocamaour - " + year + " - mensuel");
		gdr1.setData(turnoverRoom1PerMonth);
		
		GraphData gdcr1 = new GraphData();
		gdcr1.setName("Chambre Rocamaour - " + year + " - cumulative");
		gdcr1.setData(cumulTurnoverRoom1PerMonth);
		
		GraphData gdr2 = new GraphData();
		gdr2.setName("Chambre St Cirq Lapopie - " + year + " - mensuel");
		gdr2.setData(turnoverRoom2PerMonth);
		
		GraphData gdcr2 = new GraphData();
		gdcr2.setName("Chambre St Cirq Lapopie - "+ year + " - cumulative");
		gdcr2.setData(cumulTurnoverRoom2PerMonth);
		
		List<GraphData> list = new ArrayList<GraphData>();
		list.add(gdr1);
		list.add(gdcr1);
		list.add(gdr2);
		list.add(gdcr2);
		stats.setTurnOverGraphData(list);
		
		return stats;

	}

	public BookingRoomStats getBookingRoomStats(LocalDate start, LocalDate end) {

		BookingRoomStats stats = new BookingRoomStats();

		String request = "SELECT SUM(booking.numberPersRoom1 * booking.nights) FROM Booking as booking WHERE booking.room1 =:room1 AND booking.closed = 0 AND booking.arrival >=:start AND booking.arrival <:end";
		Long personsRoom1 = (Long) entityManager.createQuery(request).setParameter("room1", true)
				.setParameter("start", start).setParameter("end", end).getSingleResult();

		request = "SELECT SUM(booking.numberPersRoom2 * booking.nights) FROM Booking as booking WHERE booking.room2 =:room2 AND booking.closed = 0 AND booking.arrival >=:start AND booking.arrival <:end";
		Long personsRoom2 = (Long) entityManager.createQuery(request).setParameter("room2", true)
				.setParameter("start", start).setParameter("end", end).getSingleResult();

		Long totalPersons = personsRoom1 + personsRoom2;

		stats.setPersonsRoom1(personsRoom1);
		stats.setPersonsRoom2(personsRoom2);
		stats.setTotalPersons(totalPersons);

		return stats;

	}
}
