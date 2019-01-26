package com.edgb.cdhcentaure.service.booking;

import java.util.List;

import com.edgb.cdhcentaure.model.Booking;
import com.edgb.cdhcentaure.service.IService;

public interface IBookingService extends IService<Booking> {
	List<Booking> getBookingsByYear(int year);

	List<Booking> getBookingsByYearAndMonth(int year, int month);
}
