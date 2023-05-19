package com.example.demo.controller;

import java.util.List;

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
import com.example.demo.entity.Event;
import com.example.demo.service.Event_Service;

@RestController
@RequestMapping("/event")
@CrossOrigin("*")
public class EventController 
{
	private Event_Service eventser;

    @Autowired
	public EventController(Event_Service eventser) {
		super();
		this.eventser = eventser;
	}
    @GetMapping("/getAllEvent")
	public List<Event> getBookings(Event localEvent) {
		
		return eventser.displayEvent(localEvent);
	}
	@PostMapping("/add")
	public void insertAllEvent(@RequestBody Event localEvent) {
		eventser.addEvent(localEvent);
	}
	@PutMapping("/updateEvent")
	public void updateEvent(@RequestBody Event localEvent) 
	{
		eventser.updateEvent(localEvent);
	}
	
	@DeleteMapping("/deleteEvent/{eventId}")
	public void deleteEvent(@PathVariable("eventId")  int id)
	{
		eventser.deleteEvent(id);
	}
	@GetMapping("getEvent/{eventId}")
	public Event getEventById(@PathVariable("eventId")  int id)
	{
		return eventser.getEvent(id);
	}

	@GetMapping("getEvents/{venueid}")
	public List<Event> getEventsByVenueId(@PathVariable("venueid")  int venueId)
	{
		return eventser.getEventsByVenueId(venueId);
	}
	
	@GetMapping("getOne/{eventname}/{venueid}")
	public Event getEventByNameAndVenueId( @PathVariable ("eventname") String name ,@PathVariable("venueid") int venueid)
	{
		return eventser.getByNameAndVenueId(name, venueid);
	}
	
	@DeleteMapping("deletebyvenue/{venueid}")
	public void deleteEventByVenueId(@PathVariable("venueid") int venueid)
	{
		eventser.deleteEventByVenueId(venueid);
	}

}