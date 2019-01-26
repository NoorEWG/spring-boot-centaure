package com.edgb.cdhcentaure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edgb.cdhcentaure.model.BookingPaymentStats;
import com.edgb.cdhcentaure.model.BookingRoomStats;
import com.edgb.cdhcentaure.service.stats.IBookingStatsService;

@Controller
@RequestMapping("stats")
public class BookingStatsController {

	@Autowired
	private IBookingStatsService bookingStatsService;
	
	@GetMapping("booking/payments/{year}")
	public ResponseEntity<BookingPaymentStats> getPaymentsByYear(@PathVariable("year") Integer year) {
		BookingPaymentStats bookingStats = bookingStatsService.getPaymentStatsByYear(year);
		return new ResponseEntity<BookingPaymentStats>(bookingStats, HttpStatus.OK);
	}
	
	@GetMapping("booking/payments/{year}/{month}")
	public ResponseEntity<BookingPaymentStats> getPaymentsByYearAndMonth(@PathVariable("year") Integer year,@PathVariable("month") Integer month) {
		BookingPaymentStats bookingStats = bookingStatsService.getPaymentStatsByYearAndMonth(year,month);
		return new ResponseEntity<BookingPaymentStats>(bookingStats, HttpStatus.OK);
	}
	
	@GetMapping("booking/persons/{year}")
	public ResponseEntity<BookingRoomStats> getPersonsByYear(@PathVariable("year") Integer year) {
		BookingRoomStats roomStats = bookingStatsService.getRoomStatsByYear(year);
		return new ResponseEntity<BookingRoomStats>(roomStats, HttpStatus.OK);
	}
	
	@GetMapping("booking/persons/{year}/{month}")
	public ResponseEntity<BookingRoomStats> getPersonsByYearAndMonth(@PathVariable("year") Integer year,@PathVariable("month") Integer month) {
		BookingRoomStats roomStats = bookingStatsService.getRoomStatsByYearAndMonth(year,month);
		return new ResponseEntity<BookingRoomStats>(roomStats, HttpStatus.OK);
	}
}
