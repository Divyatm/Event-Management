package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Member;
import com.example.demo.entity.Venue;
import com.example.demo.persitance.MemberRepo;
import com.example.demo.persitance.VenueRepo;

@Service
public class Venue_Service 
{
	private VenueRepo venrep;
	private FoodItem_Service foodser;
	private Event_Service eventser;
	private Equipment_Service eqserv;
	private MemberRepo memrepo;

	@Autowired
	public Venue_Service(VenueRepo venrep , FoodItem_Service foodser , Event_Service eventser, Equipment_Service eqserv,MemberRepo memrepo) 
	{
		this.venrep = venrep;
		this.foodser=foodser;
		this.eventser=eventser;
		this.eqserv=eqserv;
		this.memrepo=memrepo;
	}
	
	@Transactional
	public List<Venue> getVenuesByOrganizerId(int orgId) {
		return venrep.getVenueByOrganizerId(orgId);
	}

	@Transactional
	public List<Venue> getAllVenue()
	{
		return venrep.findAll();
	}
	
	@Transactional
	public void insertVenue(Venue venue)
	{
		System.out.println(venue.getMemberId()+"-----------------------------------------");
		Member member = memrepo.findById(venue.getMemberId()).get();
		
		venue.setMember(member);
		venrep.save(venue);
	}
	
	@Transactional
	public void updateVenue(Venue venue)
	{
		venrep.save(venue);
	}
	
	public int deleteVenue(int venueId) {
		foodser.deleteFoodItemsByVenueId(venueId);
		eventser.deleteEventByVenueId(venueId);
		eqserv.deleteEquipmentByVenueId(venueId);
		return deleteVenue(venueId);
	}
	
	@Transactional
	public Venue getVenueById(int id)
	{
		return venrep.findById(id).get();
	}
	
	@Transactional
	public List<String> getAllDistinctPlaces()
	{
		return venrep.getAllDistinctPlaces();
	}
	
	@Transactional
	public List<Venue> getVenueOfPlace(String place)
	{
		return venrep.getVenueOfPlace(place);
	}
}
