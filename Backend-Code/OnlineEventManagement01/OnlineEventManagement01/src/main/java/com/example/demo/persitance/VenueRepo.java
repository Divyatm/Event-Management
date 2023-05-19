package com.example.demo.persitance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Venue;

public interface VenueRepo extends JpaRepository<Venue, Integer> 
{
	
	@Query("from Venue where memberId = ?1")
	public List<Venue> getVenueByOrganizerId(int orgId);
	
	@Query("select distinct venuePlace from Venue ")
	public List<String> getAllDistinctPlaces(); 
	
	@Query("from Venue where venuePlace =?1")
	public List<Venue> getVenueOfPlace(String place);

	@Query("from Venue where memberId=?1 ")
	public List<Venue> findByMemberId(int orgId);
}
