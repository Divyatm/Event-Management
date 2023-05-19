package com.example.demo.controller;

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
import com.example.demo.entity.Venue;
import com.example.demo.service.Notification_Service;
import com.example.demo.service.Venue_Service;

@RestController
@RequestMapping("/venue")
@CrossOrigin("*")
public class VenueController 
{
	private Venue_Service venserv ;
	private Notification_Service notserv;

	@Autowired
	public VenueController(Venue_Service venserv, Notification_Service notserv) 
	{
		this.venserv = venserv;
		this.notserv = notserv;
	}
	
	@GetMapping("/getVenues")
	public List<Venue> getAllVenue()
	{
		return venserv.getAllVenue();
	}
	
	@PostMapping("/add")
	public void insertVenue(@RequestBody Venue venue) 
	{
		this.notserv.notifyOnVenueAdd(venue);
		venserv.insertVenue(venue);
	}
	
	@PutMapping("/updateVenue")
	public void updateBookings(@RequestBody Venue venue) 
	{
		venserv.updateVenue(venue);
	}
	
	@DeleteMapping("/deleteVenue/{venueId}")
	public void deleteBooking(@PathVariable("venueId")  int id)
	{
		venserv.deleteVenue(id);
	}
	
	@GetMapping("/getVenue/{venueId}")
	public Venue getBookingById(@PathVariable("venueId")  int id)
	{
		return venserv.getVenueById(id);
	}
	
	@GetMapping("/places")
	public List<String> getdistinctPlaces()
	{
		return venserv.getAllDistinctPlaces();
	}
	
	@GetMapping("/getVenues/{place}")
	public List<Venue> getVenueOfPlace(@PathVariable("place")  String place)
	{
		return venserv.getVenueOfPlace(place);
	}
	
	@GetMapping("/organizer/{orgId}")
	public List<Venue> getVenuesByOrganizerId(@PathVariable("orgId") int orgId) {
		return venserv.getVenuesByOrganizerId(orgId);
	}

}
