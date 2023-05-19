package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entity.Event;
import com.example.demo.persitance.EventRepo;

@Service
 public class Event_Service {
	  private EventRepo eventrepo;
	   
	   @Autowired
	   public Event_Service(EventRepo eventrepo) {
		super();
		this.eventrepo = eventrepo;
	   }
	   
	   @Transactional
	   public List<Event> displayEvent(Event localEvent) {
	   	return eventrepo.findAll();
	   }
	   @Transactional
	   public void addEvent(Event localEvent) {
	   	eventrepo.save(localEvent);
	   }
	   @Transactional
	   public void updateEvent(Event localEvent) 
	   {
	   	eventrepo.save(localEvent);
	   }
	   
	   @Transactional
	   public void deleteEvent(int id)
	   {
	   	eventrepo.deleteById(id);
	   }
		
	   @Transactional
	   public Event getEvent(int id) 
	   {
	   	return eventrepo.findById(id).get();
	   }
	   
	   @Transactional
	   public List<Event> getEventsByVenueId(int eventId)
	   {
		   return eventrepo.getEventsByVenueId(eventId);
	   }
	   
	   @Transactional
	   public void deleteEventByVenueId(int venueId)
	   {
		   eventrepo.deleteEventByVenueId(venueId);
	   }
	   
	   @Transactional
	   public Event getByNameAndVenueId(String eName, int vId)
	   {
		  return eventrepo.getByNameAndVenueId(eName, vId);
	   }

}
