package com.example.demo.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Booking;
import com.example.demo.entity.BookingDetail;
import com.example.demo.entity.Equipment;
import com.example.demo.entity.Event;
import com.example.demo.entity.Member;
import com.example.demo.entity.Venue;
import com.example.demo.entity.FoodItem;
import com.example.demo.persitance.BookingRepo;
import com.example.demo.persitance.MemberRepo;
import com.example.demo.persitance.VenueRepo;
@Service
public class Booking_Service 
{
	Booking newBooking = new Booking();
	private BookingRepo bookrepo;
	private VenueRepo venuRepo;
	private MemberRepo memrepo;
	private FoodItem_Service foodserv;
	private Equipment_Service eqserv;
	private Event_Service eventser;
	List<BookingDetail> upcomingBookings;
	List<BookingDetail> historyBookings;
	int foodItemCost;
	int equipmentCost;
	int eventCost;
	int totalCost;
	String foodNames;
	String equipmentNames;

    @Autowired
	public Booking_Service(BookingRepo bookrepo , VenueRepo venuRepo, MemberRepo memrepo,FoodItem_Service foodserv,Equipment_Service eqserv,Event_Service eventser) {
		super();
		this.bookrepo = bookrepo;
		this.venuRepo=venuRepo;
		this.memrepo=memrepo;
		this.foodserv=foodserv;
		this.eqserv=eqserv;
		this.eventser=eventser;
		
	}
    
    @Transactional
    public List<Booking> getAllBook()
    {
    	return bookrepo.findAll();
    }
    
    @Transactional
    public Booking rectifyBooking(Booking localBooking) {
		this.foodItemCost = 0;
		this.equipmentCost = 0;
		this.eventCost = 0;
		this.totalCost = 0;
		this.foodNames = " ";
		this.equipmentNames = " ";

		// Get array of selected food Item Id in string format
		String[] selFood = localBooking.getSelectedFoodItems().trim().split(",");

		// Get food Items Cost and Names
		for (String f : selFood) {
			if (!(f.equals(""))) 
			{
				int fId = Integer.parseInt(f);
				FoodItem food = this.foodserv.getFoodItem(fId);
				int ownCost = food.getFoodItemCost();
				this.foodItemCost = this.foodItemCost + ownCost;
				this.foodNames = this.foodNames + " " + food.getFoodItemName();
				;
			}

		}

		// Get array of selected Equipments id in string format
		String[] selEquip = localBooking.getSelectedEquipments().split(",");

		// Get Equipment Cost and Names
		for (String e : selEquip) {
			if (!(e.equals(""))) {

				int eId = Integer.parseInt(e);
				Equipment equip = this.eqserv.getEquipment(eId);
				int ownCost = equip.getEquipmentCost();
				this.equipmentCost = this.equipmentCost + ownCost;
				this.equipmentNames = this.equipmentNames + " " + equip.getEquipmentName();
			}
		}

		// Get Event Cost
		
		String eventName = localBooking.getEventName();
		int VenueId = localBooking.getVenueId();
		List<Event> events = this.eventser.getEventsByVenueId(VenueId);
		for (Event e : events) {
			
			if (eventName.equals(e.getEventName())) {
				this.eventCost = e.getEventCost();
			}
		}

		// Final Food Item and Total Cost
		this.foodItemCost = this.foodItemCost * localBooking.getGuestCount();
		this.totalCost = this.foodItemCost + this.equipmentCost + this.eventCost;

		newBooking.setBookingId(localBooking.getBookingId());
		newBooking.setDate(localBooking.getDate());
		newBooking.setGuestCount(localBooking.getGuestCount());
		newBooking.setEventName(localBooking.getEventName());
		newBooking.setSelectedFoodItems(localBooking.getSelectedFoodItems());
		newBooking.setSelectedEquipments(localBooking.getSelectedEquipments());
		newBooking.setEquipmentName(this.equipmentNames);
		newBooking.setFoodItemName(this.foodNames);
		newBooking.setEventCost(localBooking.getEventCost());
		newBooking.setEquipmentCost(this.equipmentCost);
		newBooking.setFoodItemCost(this.foodItemCost);
		newBooking.setTotalCost(this.totalCost);
		newBooking.setPaymentStatus(localBooking.getPaymentStatus());
		newBooking.setMemberId(localBooking.getMemberId());
		newBooking.setVenueId(localBooking.getVenueId());
		newBooking.setDelStatus(1);

		return this.insertBooking(newBooking);

	}

    
    @Transactional
    public List<Booking> displayBooking() 
    {
    	return bookrepo.findAll();
    }
    
    @Transactional
    public Booking insertBooking(Booking localBooking) 
    {
    	return bookrepo.save(localBooking);
    }
    
    @Transactional
    public void updateBooking(Booking localBooking) 
    {
    	bookrepo.save(localBooking);
    }
    
    @Transactional
    public void deleteBooking(int id)
    {
    	bookrepo.deleteById(id);
    }
	
    @Transactional
    public Booking getBookingbyId(int id)
    {
    	return bookrepo.findById(id).get();
    }
    
    @Transactional
    public void doPayment(int bookingId)
    {
    	bookrepo.doPayment(bookingId);
    }
    
    @Transactional
    public List<Date> getBookedDatesByVenue_id(int venueId)
    {
    	return bookrepo.getBookedDatesByVenueId(venueId);
    }
    
    @Transactional
    public List<BookingDetail> getBookingDetail() {

		List<Booking> bookingList = (List<Booking>) bookrepo.findAll();

		return copyDataFromBookingToBookingDetail(bookingList);
	}
    
    @Transactional
    private List<BookingDetail> copyDataFromBookingToBookingDetail(List<Booking> bookingList) {

		List<BookingDetail> localList = new ArrayList<BookingDetail>();

		for (Booking b : bookingList) {

			BookingDetail bookingD = copySingleBookingToDetails(b);

			localList.add(bookingD);
		}
		return localList;
	}

	private BookingDetail copySingleBookingToDetails(Booking b) {
		BookingDetail bkDetail = new BookingDetail();
		bkDetail.setBookingId(b.getBookingId());
		
		Member member = memrepo.findById(b.getMemberId()).get();
		Venue venue = venuRepo.findById(b.getVenueId()).get();
		bkDetail.setMemberId(member.getMemberId());
		bkDetail.setVenueId(venue.getVenueId());
		bkDetail.setDate(b.getDate());
		bkDetail.setEventName(b.getEventName());
		bkDetail.setEquipmentName(b.getEquipmentName());
		bkDetail.setFirstName(b.getFoodItemName());
		bkDetail.setEquipmentCost(b.getEquipmentCost());
		bkDetail.setFoodItemCost(b.getFoodItemCost());
		bkDetail.setFoodItemName(b.getFoodItemName());
		bkDetail.setEventCost(b.getEventCost());
		bkDetail.setTotalCost(b.getTotalCost());
		bkDetail.setPaymentStatus(b.getPaymentStatus());
		bkDetail.setFirstName(member.getFirstName());
		bkDetail.setLastName(member.getLastName());
		bkDetail.setEmail(member.getEmail());
		bkDetail.setPhoneNumber(member.getPhoneNumber());
		bkDetail.setVenueName(venue.getVenueName());
		bkDetail.setVenuePlace(venue.getVenuePlace());
		bkDetail.setVenueContact(venue.getVenueContact());
		bkDetail.setDelStatus(b.getDelStatus());
		return bkDetail;
	}
	
	 @Transactional
	public List<BookingDetail> getBookingsByUserId(int userId) {

		List<Booking> bookingList = bookrepo.findByMemberId(userId);

		return copyDataFromBookingToBookingDetail(bookingList);
	}

	 @Transactional
	public LocalDate sqlToLocalDateConverter(Date sqlDate) {
		return Date.valueOf(sqlDate.toString()).toLocalDate();
	}

	// Service to get Booking Detail by Booking ID//####

	public BookingDetail bookingDetail(int bookingId) {
		Booking booking = bookrepo.findById(bookingId).get();
		return copySingleBookingToDetails(booking);
	}

	 
	List<Date> allDates;
	List<Date> requiredDates;
	@Transactional
	public List<Date> getUpcomingBookedDates(int venueId) {
		requiredDates = new ArrayList<>();
		LocalDate today = LocalDate.now();
		this.allDates = this.bookrepo.getBookedDatesByVenueId(venueId);
		for (Date d : allDates) {
			LocalDate bookedDate = sqlToLocalDateConverter(d);
			if ((today.isBefore(bookedDate) || today.isEqual(bookedDate))) {
				this.requiredDates.add(d);
			}
		}
		return this.requiredDates;
	}
	
	Boolean flag;
	// Check if date is already booked and Payment is Done.//####
	// return false if date is already booked or return true
	 @Transactional
	public Boolean isAvailable(Booking tempBooking) {
		flag = true;
		String stringTempDate = tempBooking.getDate().toString();
		int venueId = tempBooking.getVenueId();
		List<Date> alreadyBookedDates = this.getUpcomingBookedDates(venueId);

		for (Date bookedate : alreadyBookedDates) {

			String stringbookedate = bookedate.toString();
			if (stringbookedate.equals(stringTempDate)) {
				this.flag = false;
			}
		}

		return this.flag;
	}
	
	 @Transactional
	public Boolean isAvailableForPayment(int tempBookingId) {
		flag = true;
		// get details of booking by booking id
		BookingDetail bookingDetail = bookingDetail(tempBookingId);
		// get the date of booking
		Date bDate = bookingDetail.getDate();
		// get venue id from booking
		int venueId = bookingDetail.getVenueId();
		// call service get upcoming booking dates
		List<Date> alreadyBookedDates = this.getUpcomingBookedDates(venueId);
		// convert date to string
		String stringBDate = bDate.toString();
		// if the date matches with the already booked and paid dates then return false
		// otherwise return true
		for (Date bookedDate : alreadyBookedDates) {

			String stringBookedDate = bookedDate.toString();
			if (stringBookedDate.equals(stringBDate)) {
				this.flag = false;
			}
		}
		return this.flag;
	}

	 @Transactional
	public List<BookingDetail> getBookingDetailByOrganizerId(int orgId, String tense) {

		List<Venue> venueList = venuRepo.findByMemberId(orgId);

		this.upcomingBookings = new ArrayList<>();
		this.historyBookings = new ArrayList<>();

		for (Venue v : venueList) {

			int venueId = v.getVenueId();

			List<Booking> bookingList = bookrepo.findByVenueId(venueId);

			List<BookingDetail> localList = copyDataFromBookingToBookingDetail(bookingList);

			for (BookingDetail bd : localList) {
				// int delStatus = bd.getDelStatus();
				LocalDate todayDate = LocalDate.now();
				LocalDate bookingDate = sqlToLocalDateConverter(bd.getDate());
				String paymentStatus = bd.getPaymentStatus();
				if ((todayDate.isBefore(bookingDate) || todayDate.isEqual(bookingDate))
						&& paymentStatus.equalsIgnoreCase("Processed")) {

					this.upcomingBookings.add(bd);
				} else if (todayDate.isAfter(bookingDate) && paymentStatus.equalsIgnoreCase("Processed")) {
					/* && (delStatus==1 || delStatus==11 || delStatus==110 || delStatus==111 ) */
					this.historyBookings.add(bd);

				}
			}
		}
		if (tense.equals("Past")) {
			return this.historyBookings;
		} else {
			return this.upcomingBookings;
		}

	}
	
	 @Transactional
	public int checkActiveBookings(int venueId) {
		int i=0;
		
		List<BookingDetail> localList = this.bookrepo.getBookingByVenueId(venueId);
		for (BookingDetail bd : localList) {
			LocalDate todayDate = LocalDate.now();
			LocalDate bookingDate = sqlToLocalDateConverter(bd.getDate());
			String paymentStatus = bd.getPaymentStatus();
			if ((todayDate.isBefore(bookingDate) || todayDate.isEqual(bookingDate))
					&& paymentStatus.equals("Processed")) {
				i = 1;
			} 
		}
		return i;
	}
}
