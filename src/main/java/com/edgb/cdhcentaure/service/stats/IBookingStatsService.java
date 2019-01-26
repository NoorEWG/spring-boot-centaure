package com.edgb.cdhcentaure.service.stats;

import java.util.List;
import com.edgb.cdhcentaure.model.BookingPaymentStats;
import com.edgb.cdhcentaure.model.BookingRoomStats;

public interface IBookingStatsService {
	BookingPaymentStats getPaymentStatsByYear(int year);

	BookingPaymentStats getPaymentStatsByYearAndMonth(int year, int month);

	BookingRoomStats getRoomStatsByYear(int year);

	BookingRoomStats getRoomStatsByYearAndMonth(int year, int month);
}
