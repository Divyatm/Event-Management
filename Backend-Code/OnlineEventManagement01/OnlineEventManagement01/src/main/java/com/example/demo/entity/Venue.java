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
@Table(name="Venue")
public class Venue {
	@Id
	@Column(name="venueId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int venueId;
	@Column(name="venueName")
	private String venueName;
	@Column(name="venuePlace")
	private String venuePlace;
	@Column(name="venueContact")
	private String venueContact;
	
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	@Column(name="memberId")
	private int memberId;
	
	@ManyToOne(targetEntity = Member.class, fetch=FetchType.EAGER)
	@JoinColumn(name="memberId",insertable = false,updatable = false)
	private Member member;
	
//	@OneToMany(mappedBy = "venue")
//	private Set<Venue>venue;
	
	public int getVenueId() {
		return venueId;
	}
	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}
	public String getVenueName() {
		return venueName;
	}
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}
	public String getVenuePlace() {
		return venuePlace;
	}
	public void setVenuePlace(String venuePlace) {
		this.venuePlace = venuePlace;
	}
	public String getVenueContact() {
		return venueContact;
	}
	public void setVenueContact(String venueContact) {
		this.venueContact = venueContact;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public Venue(int venueId, String venueName, String venuePlace, String venueContact, int memberId) {
		super();
		this.venueId = venueId;
		this.venueName = venueName;
		this.venuePlace = venuePlace;
		this.venueContact = venueContact;
		this.memberId = memberId;
	}
	public Venue() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Venue [venueId=" + venueId + ", venueName=" + venueName + ", venuePlace=" + venuePlace
				+ ", venueContact=" + venueContact + ", memberId=" + memberId + ", member=" + member 
				 + "]";
	}
	
}
