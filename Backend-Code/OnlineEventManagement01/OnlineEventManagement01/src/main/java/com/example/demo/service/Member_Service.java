package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entity.Member;
import com.example.demo.persitance.MemberRepo;

@Service
public class Member_Service {
	private MemberRepo memrepo;

	@Autowired
	public Member_Service(MemberRepo memrepo) 
	{
		this.memrepo = memrepo;
	}

	@Transactional
	public List<Member> displayAll()
	{
		return memrepo.findAll();
	}
	
	@Transactional
	public void addMember(Member member) {
		memrepo.save(member);

	}

	@Transactional
	public void updateMember(Member member) {
		memrepo.save(member);

	}

	@Transactional
	public Member getMemberbyId(int id) {
		return memrepo.findById(id).get();
	}

	@Transactional
	public void deleteMemberbyId(int id) {
		memrepo.deleteById(id);
	}

	@Transactional
	public Member findMemberByMailPass(String mail, String pass)
	{
		return memrepo.findMemberByMailPass(mail,pass);
	}
	
	@Transactional
	public Member findMemberByMail(String mail)
	{
		return memrepo.findMemberByMail(mail);
	}

	@Transactional
	public Integer getMemberIdByVenueId(int venueId)
	{
		return memrepo.getMemberIdByVenueId(venueId);
	}

	@Transactional
	public List<Member> getAllUsers()
	{
		return memrepo.getAllUsers();
	}
	
	@Transactional
	public List<Member> getAllOrganisers()
	{
		return memrepo.getAllOrganizers();
	}
	
}
