package com.edgb.cdhcentaure.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.edgb.cdhcentaure.model.Booking;
import com.edgb.cdhcentaure.service.booking.IBookingService;

@Controller
@RequestMapping("api")
public class BookingController {
	
	@Autowired
	private IBookingService bookingService;
	
	@GetMapping("booking/{id}")
	public ResponseEntity<Booking> getById(@PathVariable("id") Integer id) {
		Booking Booking = bookingService.getById(id);
		return new ResponseEntity<Booking>(Booking, HttpStatus.OK);
	}
	
	@GetMapping("bookings")
	public ResponseEntity<List<Booking>> getAll() {
		List<Booking> list = bookingService.getAll();
		return new ResponseEntity<List<Booking>>(list, HttpStatus.OK);
	}
	
	@GetMapping("bookings/{year}")
	public ResponseEntity<List<Booking>> getBookingsByYear(@PathVariable("year") Integer year) {
		List<Booking> list = bookingService.getBookingsByYear(year);
		return new ResponseEntity<List<Booking>>(list, HttpStatus.OK);
	}
	
	@GetMapping("bookings/{year}/{month}")
	public ResponseEntity<List<Booking>> getBookingsByYear(@PathVariable("year") Integer year, @PathVariable("month") Integer month ) {
		List<Booking> list = bookingService.getBookingsByYearAndMonth(year,month);
		return new ResponseEntity<List<Booking>>(list, HttpStatus.OK);
	}
	
	
	@PostMapping("booking")
	public ResponseEntity<Void> addBooking(@RequestBody Booking Booking, UriComponentsBuilder builder) {
                boolean flag = bookingService.add(Booking);
                if (flag == false) {
        	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(builder.path("/booking/{id}").buildAndExpand(Booking.getId()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("booking")
	public ResponseEntity<Booking> updateBooking(@RequestBody Booking Booking) {
		bookingService.update(Booking);
		return new ResponseEntity<Booking>(Booking, HttpStatus.OK);
	}
	
	@DeleteMapping("booking/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		boolean flag = bookingService.delete(id);
		if (flag == false) {
      	  return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
		else {
		  return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}	
}  
