package com.example.demo.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entity.Notification;
import com.example.demo.entity.Booking;
import com.example.demo.entity.Member;
import com.example.demo.entity.BookingDetail;
import com.example.demo.entity.Venue;
import com.example.demo.persitance.MemberRepo;
import com.example.demo.persitance.NotificationRepo;

@Service
public class Notification_Service {
    private NotificationRepo notirepo;
    private MemberRepo memrepo;
    private Booking_Service bookserv;
    private Member_Service memeserv;
    @Autowired
	public Notification_Service(NotificationRepo notirepo, MemberRepo memrepo, Booking_Service bookserv, Member_Service memeserv) {
		super();
		this.notirepo = notirepo;
		this.memrepo=memrepo;
		this.bookserv=bookserv;
		this.memeserv=memeserv;
		
	}
    
    public int notificationOnRegistration(Member member) {
		Member newMember =  memrepo.findMemberByMail(member.getEmail());
		Notification notification = new Notification();
		notification.setMemberId(newMember.getMemberId());
		LocalDate localDate = LocalDate.now();
		String localTime = LocalTime.now().truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_LOCAL_TIME);
		notification.setDate(localDate.toString());
		notification.setTime(localTime);
		if (newMember.getRole().equals("user")) {
			String userNoti = "Welcome " + newMember.getFirstName()
					+ ", You have successfully registered on The Event Corp. "
					+ "Now you can book your events on various venues.";
			notification.setMessage(userNoti);
		} else {
			String orgNoti = "Welcome " + member.getFirstName()
					+ ", You have successfully registered on The Event Corp. "
					+ "Now you can add your venues on the portal";
			notification.setMessage(orgNoti);
		}

		insertNotification(notification);
		return 1;
	}

	// Generate notification On Booking//##
	public int notifyOnBooking(Booking booking) {
		Notification notification = new Notification();

		notification.setMemberId(booking.getMemberId());
		LocalDate localDate = LocalDate.now();
		String localTime = LocalTime.now().truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_LOCAL_TIME);

		notification.setDate(localDate.toString());
		notification.setTime(localTime);

		String userNoti = "Dear User, Your booking data is stored temprory, Please make it fixed by completing payment";

		notification.setMessage(userNoti);
		insertNotification(notification);
		return 1;

	}

	// Generate notification On payment//##
	public int notifyOnPayment(int bookingId) {

		BookingDetail singleBooking = this.bookserv.bookingDetail(bookingId);

		int memberId = memeserv.getMemberIdByVenueId(singleBooking.getVenueId());

		Member member = memeserv.getMemberbyId(memberId);

		String userNoti = "Dear " + singleBooking.getFirstName() + ", Your payment of Rs. "
				+ singleBooking.getTotalCost() + " for booking ID " + singleBooking.getBookingId()
				+ " is processed successfully." + "Your " + singleBooking.getEventName()
				+ " event is booked on Venue Name " + singleBooking.getVenueName() + " at "
				+ singleBooking.getVenuePlace() + " on date " + singleBooking.getDate();

		String orgNoti = "Dear " + member.getFirstName() + ", Your venue " + singleBooking.getVenueName()
				+ " is booked by user " + singleBooking.getFirstName() + " " + singleBooking.getLastName()
				+ " for an event of " + singleBooking.getEventName() + " on date " + singleBooking.getDate();

		Notification notification = new Notification();
		notification.setMemberId(singleBooking.getMemberId());
		LocalDate localDate = LocalDate.now();
		String localTime = LocalTime.now().truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_LOCAL_TIME);

		notification.setDate(localDate.toString());
		notification.setTime(localTime);
		notification.setMessage(userNoti);

		insertNotification(notification);

		Notification notification2 = new Notification();
		notification2.setMemberId(memberId);
		LocalDate localDate2 = LocalDate.now();
		String localTime2 = LocalTime.now().truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_LOCAL_TIME);

		notification2.setDate(localDate2.toString());
		notification2.setTime(localTime2);
		notification2.setMessage(orgNoti);
		insertNotification(notification2);
		return 1;

	}

	// Genetate notification on New Venue Add//##
	public int notifyOnVenueAdd(Venue venue) {

		Member member = memeserv.getMemberbyId(venue.getMemberId());

		String orgNoti = "Dear " + member.getFirstName() + " Your venue with name " + venue.getVenueName()
				+ " at place " + venue.getVenuePlace() + " is Successfully added. ";

		Notification notification = new Notification();
		notification.setMemberId(venue.getMemberId());
		LocalDate localDate = LocalDate.now();
		String localTime = LocalTime.now().truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_LOCAL_TIME);
		notification.setDate(localDate.toString());
		notification.setTime(localTime);
		notification.setMessage(orgNoti);
		insertNotification(notification);
		return 1;

	}

	@Transactional
    public List<Notification> displayNotification() {
    	return notirepo.findAll();
    }
    @Transactional
    public Notification insertNotification(Notification noti) {
    	 return notirepo.save(noti);
    }
    @Transactional
    public void updateNotification(Notification noti) 
    {
    	notirepo.save(noti);
    }
    
    @Transactional
    public void deleteNotification(int id)
    {
    	 notirepo.deleteById(id);
    }
	
    @Transactional
    public List<Notification> getNotificationByMemberId(int id) 
    {
    	return notirepo.getnotificationByMemberId(id);
    }
}