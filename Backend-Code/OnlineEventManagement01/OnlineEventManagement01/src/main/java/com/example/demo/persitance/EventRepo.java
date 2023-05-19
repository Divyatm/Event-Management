package com.example.demo.persitance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Event;

public interface EventRepo extends JpaRepository<Event, Integer> 
{
	@Query("from Event where venueId = ?1")
	public List<Event> getEventsByVenueId(int eventId);

	@Query("delete from Event where venueId=?1")
	public void deleteEventByVenueId(int venueId);
	
	@Query("from Event where eventName=?1 and venueId=?2")
	public Event getByNameAndVenueId(String eName, int vId);
}
