package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.FoodItem;
import com.example.demo.entity.Member;
import com.example.demo.service.Member_Service;
import com.example.demo.service.Notification_Service;

@RestController
@RequestMapping("/member")
@CrossOrigin("*")
public class MemberController {
	
	private Member_Service memserv;
	private Notification_Service notserv;
	
	public MemberController(Member_Service memserv , Notification_Service notserv) 
	{
		this.memserv = memserv;
		this.notserv=notserv;
	}
	
	@PostMapping("/add")
	public Member addMember(@RequestBody Member member) {
		
		this.memserv.addMember(member);
		
		notserv.notificationOnRegistration(member);
		
		return member;
	}
	
	@GetMapping("/list")
	public List<Member> getAllMembers()
	{
		return memserv.displayAll();
	}
	
	@GetMapping("/{username}/{password}")
    public Member Authenticate(@PathVariable(value = "username") String username,@PathVariable(value = "password") String password)
        throws ResourceNotFoundException {
		
		try {
			return memserv.findMemberByMailPass(username, password);
		}
		catch(Exception e){
			throw new ResourceNotFoundException("Member/User with given value is not found");
		}
	  
    }
	
	@PutMapping("/updateMember/{member}")
	public void updateMember(@PathVariable("member") Member member) 
	{
		memserv.updateMember(member);
	}
	
    @DeleteMapping("/deleteMember/{memberId}")
	public void deleteMemberByEquipmentID(@PathVariable("memberId")int id)
	{
		memserv.deleteMemberbyId(id);
		
	}
	
	@GetMapping("/getMember/{memberId}")
	public Member getMemberById(@PathVariable("memberId")  int id)
	{
		 return memserv.getMemberbyId(id);
		
	}
	
	@GetMapping("/getmember/{mail}")
	public Member getMemberByMail(@PathVariable("mail") String mail)
	{
		return memserv.findMemberByMail(mail);
	}
	
	@GetMapping("/gememberbyvenue/{venueId}")
	public Integer getMemberidByVenueid(@PathVariable("venueId") int id)
	{
		return memserv.getMemberIdByVenueId(id);
	}
	
	@GetMapping("/getAllUsers")
	public List<Member> getAllUsers()
	{
		return memserv.getAllUsers();
	}
	
	 @GetMapping("/getAllOrganizers")
	public List<Member> getAllOrganisers()
	{
		return memserv.getAllOrganisers();
	}

	
	

}
