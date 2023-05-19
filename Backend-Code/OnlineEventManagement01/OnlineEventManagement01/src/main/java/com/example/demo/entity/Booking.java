package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bookingId")
	private int bookingId;
	@Column(name="date")
	private Date date;
	@Column(name="eventName")
	private String eventName;
	@Column(name="equipmentName")
	private String equipmentName;
	@Column(name="foodItemName")
	private String foodItemName;
	@Column(name="eventCost")
	private int eventCost;
	@Column(name="equipmentCost")
	private int equipmentCost;
	@Column(name="foodItemCost")
	private int foodItemCost;
	@Column(name="totalCost")
	private int totalCost;
	@Column(name="paymentStatus")
	private String paymentStatus;
	@Column(name="delStatus")
	private int delStatus;
	@Column(name="guestCount")
	private int guestCount;
	private String selectedFoodItems;
	private String selectedEquipments;

	@Column(name="memberId")
	private int memberId;
	
	@ManyToOne(targetEntity = Member.class, fetch=FetchType.EAGER)
    @JoinColumn(name="memberId", insertable=false, updatable=false,nullable = true)
    private Member member;
    
	@Column(name="venueId")
	private int venueId;
	
	@ManyToOne(targetEntity = Venue.class, fetch=FetchType.EAGER)
    @JoinColumn(name="venueId", insertable=false, updatable=false,nullable = true)
    private Venue venue;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public String getFoodItemName() {
		return foodItemName;
	}

	public void setFoodItemName(String foodItemName) {
		this.foodItemName = foodItemName;
	}

	public int getEventCost() {
		return eventCost;
	}

	public void setEventCost(int eventCost) {
		this.eventCost = eventCost;
	}

	public int getEquipmentCost() {
		return equipmentCost;
	}

	public void setEquipmentCost(int equipmentCost) {
		this.equipmentCost = equipmentCost;
	}

	public int getFoodItemCost() {
		return foodItemCost;
	}

	public void setFoodItemCost(int foodItemCost) {
		this.foodItemCost = foodItemCost;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getGuestCount() {
		return guestCount;
	}

	public void setGuestCount(int guestCount) {
		this.guestCount = guestCount;
	}

	public String getSelectedFoodItems() {
		return selectedFoodItems;
	}

	public void setSelectedFoodItems(String selectedFoodItems) {
		this.selectedFoodItems = selectedFoodItems;
	}

	public String getSelectedEquipments() {
		return selectedEquipments;
	}

	public void setSelectedEquipments(String selectedEquipments) {
		this.selectedEquipments = selectedEquipments;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public int getVenueId() {
		return venueId;
	}

	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	
	public Booking() 
	{
		
	}

	public Booking(int bookingId, Date date, String eventName, String equipmentName, String foodItemName, int eventCost,
			int equipmentCost, int foodItemCost, int totalCost, String paymentStatus, int delStatus, int guestCount,
			String selectedFoodItems, String selectedEquipments, int memberId, int venueId) {
		super();
		this.bookingId = bookingId;
		this.date = date;
		this.eventName = eventName;
		this.equipmentName = equipmentName;
		this.foodItemName = foodItemName;
		this.eventCost = eventCost;
		this.equipmentCost = equipmentCost;
		this.foodItemCost = foodItemCost;
		this.totalCost = totalCost;
		this.paymentStatus = paymentStatus;
		this.delStatus = delStatus;
		this.guestCount = guestCount;
		this.selectedFoodItems = selectedFoodItems;
		this.selectedEquipments = selectedEquipments;
		this.memberId = memberId;
		this.venueId = venueId;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", date=" + date + ", eventName=" + eventName + ", equipmentName="
				+ equipmentName + ", foodItemName=" + foodItemName + ", eventCost=" + eventCost + ", equipmentCost="
				+ equipmentCost + ", foodItemCost=" + foodItemCost + ", totalCost=" + totalCost + ", paymentStatus="
				+ paymentStatus + ", delStatus=" + delStatus + ", guest_count=" + guestCount + ", selectedFoodItems="
				+ selectedFoodItems + ", selectedEquipments=" + selectedEquipments + ", memberId=" + memberId
				+ ", venueId=" + venueId + "]";
	}
	
	
	
	
	
}
