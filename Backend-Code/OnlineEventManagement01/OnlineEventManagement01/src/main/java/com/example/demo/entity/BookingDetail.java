package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;

import org.springframework.stereotype.Component;

@Component
public class BookingDetail {
	

	private int bookingId;
	private Date date;
	private String eventName;
	private String equipmentName;
	private String foodItemName;
	private int eventCost;
	private int equipmentCost;
	private int foodItemCost;
	private int totalCost;
	private String paymentStatus;
	private int delStatus;
	private int venueId;
	private int memberId;
	private int guestCount;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	
	private String venueName;
	private String venuePlace;
	private String venueContact;
	
	
	
	public BookingDetail() 
	{
		
	}



	public BookingDetail(int bookingId, Date date, String eventName, String equipmentName, String foodItemName,
			int eventCost, int equipmentCost, int foodItemCost, int totalCost, String paymentStatus, int delStatus,
			int venueId, int memberId, int guestCount, String firstName, String lastName, String phoneNumber,
			String email, String venueName, String venuePlace, String venueContact) {
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
		this.venueId = venueId;
		this.memberId = memberId;
		this.guestCount = guestCount;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.venueName = venueName;
		this.venuePlace = venuePlace;
		this.venueContact = venueContact;
	}



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



	public int getVenueId() {
		return venueId;
	}



	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}



	public int getMemberId() {
		return memberId;
	}



	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}



	public int getGuestCount() {
		return guestCount;
	}



	public void setGuestCount(int guestCount) {
		this.guestCount = guestCount;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
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



	@Override
	public String toString() {
		return "BookingDetail [bookingId=" + bookingId + ", date=" + date + ", eventName=" + eventName
				+ ", equipmentName=" + equipmentName + ", foodItemName=" + foodItemName + ", eventCost=" + eventCost
				+ ", equipmentCost=" + equipmentCost + ", foodItemCost=" + foodItemCost + ", totalCost=" + totalCost
				+ ", paymentStatus=" + paymentStatus + ", delStatus=" + delStatus + ", venueId=" + venueId
				+ ", memberId=" + memberId + ", guestCount=" + guestCount + ", firstName=" + firstName + ", lastName="
				+ lastName + ", phoneNumber=" + phoneNumber + ", email=" + email + ", venueName=" + venueName
				+ ", venuePlace=" + venuePlace + ", venueContact=" + venueContact + "]";
	}


	

}
