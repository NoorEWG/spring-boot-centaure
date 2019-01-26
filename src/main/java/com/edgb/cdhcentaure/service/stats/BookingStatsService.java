package com.edgb.cdhcentaure.service.stats;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgb.cdhcentaure.DAO.stats.IBookingStatsDAO;
import com.edgb.cdhcentaure.model.BookingPaymentStats;
import com.edgb.cdhcentaure.model.BookingRoomStats;

@Service
public class BookingStatsService implements IBookingStatsService {

	@Autowired
	private IBookingStatsDAO bookingStatsDAO;

	@Override
	public BookingPaymentStats getPaymentStatsByYear(int year) {
		return bookingStatsDAO.paymentStatsByYear(year);
	}

	@Override
	public BookingPaymentStats getPaymentStatsByYearAndMonth(int year, int month) {
		return bookingStatsDAO.paymentStatsByMonth(year, month);
	}

	@Override
	public BookingRoomStats getRoomStatsByYear(int year) {
		return bookingStatsDAO.roomStatsByYear(year);
	}

	@Override
	public BookingRoomStats getRoomStatsByYearAndMonth(int year, int month) {
		return bookingStatsDAO.roomStatsByMonth(year, month);
	}

}