package com.example.demo.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Event")
public class Event {
	@Id
	@Column(name="eventId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eventId;
	@Column(name="eventName")
	private String eventName;
	@Column(name="eventCost")
	private int eventCost;
	@Column(name="venueId")
	private int venueId;
	@ManyToOne(targetEntity = Venue.class, fetch=FetchType.EAGER)
	@JoinColumn(name="venueId",insertable = false,updatable = false)
	private Venue venue;
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public int getEventCost() {
		return eventCost;
	}
	public void setEventCost(int eventCost) {
		this.eventCost = eventCost;
	}
	public int getVenueId() {
		return venueId;
	}
	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}
	
	public Event(int eventId, String eventName, int eventCost, int venueId) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventCost = eventCost;
		this.venueId = venueId;
	}
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventName=" + eventName + ", eventCost=" + eventCost + ", venueId="
				+ venueId + "]";
	}
	
	
}
