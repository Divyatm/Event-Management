package com.example.demo.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.Tuple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Booking;
import com.example.demo.entity.BookingDetail;
import com.example.demo.service.Booking_Service;
import com.example.demo.service.Notification_Service;

@RestController
@RequestMapping("/booking")
@CrossOrigin("*")
public class BookingController {
	private Booking_Service bookingserv;
	private Notification_Service notserv;
	
	@Autowired
	public BookingController(Booking_Service bookingserv,Notification_Service notserv) {
		this.bookingserv = bookingserv;
		this.notserv = notserv;
	}
	
	@GetMapping("/list")
	 public List<Booking> getAllBook()
    {
    	return bookingserv.getAllBook();
    }
	
	@PostMapping("/add")
	public int addBooking(@RequestBody Booking booking) {
		// Check if booking is available or not , 
		// if available then convert raw data into good format and store to database and return 1
		// otherwise return zero
		// After adding booking data , generate notification
		if (this.bookingserv.isAvailable(booking)) {
			this.bookingserv.rectifyBooking(booking);
			this.notserv.notifyOnBooking(booking);
			return 1;
		} else {
			return 0;
		}
	}
	
//	@PutMapping("/updateBooking")
//	public void updateBookings(@RequestBody Booking localbooking) 
//	{
//		bookingserv.updateBooking(localbooking);
//	}
	
	@DeleteMapping("/deleteBooking/{bookingId}")
	public void deleteBooking(@PathVariable("bookingId")  int id)
	{
		bookingserv.deleteBooking(id);
	}
	
	@GetMapping("/getBooking/{bookingId}")
	public Booking getBookingById(@PathVariable("bookingId")  int id)
	{
		return bookingserv.getBookingbyId(id);
	}
	
	@GetMapping("/doPayment/{bookingId}")
	public int doPayment(@PathVariable("bookingId") int id ) 
	{
		if (this.bookingserv.isAvailableForPayment(id)) {
			this.bookingserv.doPayment(id);
			this.notserv.notifyOnPayment(id);
			return 1;
		} else {
			return 0;
		}
	}
	
	@GetMapping("/getDates/{venueId}")
	public List<Date> getBookedDatesByVenueId(@PathVariable("venueId")  int venueId)
	{
		 return bookingserv.getBookedDatesByVenue_id(venueId);
	}
	

	@GetMapping("/getAllBookings")
	public List<BookingDetail> getBookingDetails() {
		return bookingserv.getBookingDetail();
	}
	

	// Handler to get list of bookings for USER
	@GetMapping("/bookingsByUserId/{userId}")
	public List<BookingDetail> getBookingsByUserId(@PathVariable("userId") int userId) {
		return bookingserv.getBookingsByUserId(userId);
	}

	// Handler to get Booking Detail by Booking ID 
	@GetMapping("/bookingDetail/{bookingId}")
	public BookingDetail bookingDetail(@PathVariable("bookingId") int bookingId) {
		return bookingserv.bookingDetail(bookingId);
	}

	// Request handler to get List of Upcoming Bookings only
		@GetMapping("/upcomingBookings/{orgId}")
		public List<BookingDetail> getBookingsByOrgId(@PathVariable("orgId") int orgId) {
			return bookingserv.getBookingDetailByOrganizerId(orgId,"Future");
		}

		// Request handler to get Previous bookings only
		@GetMapping("/previousBookings/{orgId}")
		public List<BookingDetail> getPreviousBookingsByOrgId(@PathVariable("orgId") int orgId) {
			return bookingserv.getBookingDetailByOrganizerId(orgId,"Past");
		}
}
