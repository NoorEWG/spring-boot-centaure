package com.edgb.cdhcentaure.DAO.stats;

import com.edgb.cdhcentaure.model.BookingPaymentStats;
import com.edgb.cdhcentaure.model.BookingRoomStats;

public interface IBookingStatsDAO {
	public BookingPaymentStats paymentStatsByYear(int year);
	public BookingPaymentStats paymentStatsByMonth(int year, int month);
	public BookingRoomStats roomStatsByYear(int year);
	public BookingRoomStats roomStatsByMonth(int year, int month);
}
