package com.example.demo.persitance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Notification;

public interface NotificationRepo extends JpaRepository<Notification, Integer> 
{
	@Query("from Notification where memberId=?1")
	public List<Notification> getnotificationByMemberId(int id);
}
