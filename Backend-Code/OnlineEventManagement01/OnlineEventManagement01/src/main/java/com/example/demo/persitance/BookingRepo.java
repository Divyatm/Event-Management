package com.example.demo.persitance;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Booking;
import com.example.demo.entity.BookingDetail;


@Repository
public interface BookingRepo extends JpaRepository<Booking,Integer> 
{
//	@Query("SELECT b.member_id, b.venue_id, b.bookingId, b.date, b.eventName, b.equimentName, b.foodItemName, b.eventCost, b.equimentCost, b.foodItemCost, b.totalCost, b.paymentStatus, m.firstName, m.lastName, m.email, m.phoneNumber, v.venueName, v.venuePlace, v.venueContact, b.delStatus \r\n"
//			+ "FROM Booking b \r\n"
//			+ "INNER JOIN b.member m \r\n"
//			+ "INNER JOIN b.venue v \r\n"
//			+ "WHERE b.bookingId = ?1")
	

	//@Query("select Booking.member_id,Booking.venue_id,Booking.booking_id,Booking.date,Booking.event_name,Booking.equiment_name,Booking.food_item_name,Booking.event_cost,Booking.equiment_cost,Booking.food_item_cost,Booking.total_cost,Booking.payment_status,Member.first_name,Member.last_name,Member.email,Member.phone_number,Venue.venue_name,Venue.venue_place,Venue.venue_contact,Booking.del_status FROM Booking INNER JOIN Member INNER JOIN Venue WHERE Booking.booking_id=?1")
//	@Query("Select Booking.member_id,Booking.venue_id,Booking.booking_id,Booking.date,Booking.event_name,Booking.equiment_name,Booking.food_item_name,Booking.event_cost,Booking.equiment_cost,Booking.food_item_cost,Booking.total_cost,Booking.payment_status,Member.first_name,Member.last_name,Member.email,Member.phone_number,Venue.venue_name,Venue.venue_place,Venue.venue_contact,Booking.del_status FROM Booking INNER JOIN Member where Booking.member_id in (select Member.member_id from Member) INNER JOIN Venue AND Booking.venue_id in (select Venue.venue_id from Venue) AND Booking.booking_id=?1")
//	public BookingDetail getBookingdetailsById(int id);
	
	@Modifying
	@Query("update Booking set payment_status='processed' where bookingId= ?1")
	public void doPayment(int bookingId);
	
	@Query("select date from Booking where venueId = ?1 and payment_status='processed' order by date asc")
	public List<Date> getBookedDatesByVenueId(int venueId);

	@Query("from Booking where memberId=?1")
	public List<Booking> findByMemberId(int memberId);

	@Query("from Booking where venueId=?1")
	public List<Booking> findByVenueId(int venueId);

	@Query("from Booking where venueId=?1")
	public List<BookingDetail> getBookingByVenueId(int venueId);

	

}
