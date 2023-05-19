package com.example.demo.persitance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Member;

public interface MemberRepo extends JpaRepository<Member , Integer> 
{

	@Query("from Member where email=?1 and password=?2")
	public Member findMemberByMailPass(String mail , String pass);
	
	@Query("from Member where email=?1")
	public Member findMemberByMail(String mail);
	
	@Query("select memberId from Venue where venueId=?1")
	public Integer getMemberIdByVenueId(int venueId);
	
	@Query(" from Member where role='user' ")
	public List<Member> getAllUsers();
	
	@Query(" from Member where role='organizer' ")
	public List<Member> getAllOrganizers();
}
