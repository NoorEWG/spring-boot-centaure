package com.edgb.cdhcentaure.DAO.booking;

import java.util.List;

import com.edgb.cdhcentaure.DAO.IDAO;
import com.edgb.cdhcentaure.model.Booking;

public interface IBookingDAO extends IDAO<Booking> {

  List<Booking> getBookingsByYear(int year);
  List<Booking> getBookingsByYearAndMonth(int year, int month);
} 
	

