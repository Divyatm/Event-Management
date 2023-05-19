package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Notification;
import com.example.demo.service.Notification_Service;

@RestController
@RequestMapping("/notification")
@CrossOrigin("*")
public class NotificationController 
{
    private  Notification_Service notiserv;
    @Autowired
	public NotificationController(Notification_Service notiserv) {
		super();
		this.notiserv = notiserv;
	}
    
    @GetMapping("/getNotification/{memberId}")
	public List<Notification> getNotifications(@PathVariable("memberId") int memberId) {
		return notiserv.getNotificationByMemberId(memberId);
	}

	// Delete Notifications
	@DeleteMapping("/deleteNotification/{notificationId}")
	public void deleteNotification(@PathVariable("notificationId") int notificationId) {
		 notiserv.deleteNotification(notificationId);
	}
//    @GetMapping("/getAllNotification")
//	public List<Notification> getNotification() {
//		
//		return notiserv.displayNotification();
//	}
//	@PostMapping("/insertNotification")
//	public void insertAllNotification(@RequestBody Notification noti) {
//		notiserv.insertNotification(noti);
//	}
//	@PutMapping("/updateNotification")
//	public void updateNotification(@RequestBody Notification noti) 
//	{
//		notiserv.updateNotification(noti);
//	}
//	
//	@DeleteMapping("/deleteNotification/{notificationId}")
//	public void deleteNotification(@PathVariable("notificationId")  int id)
//	{
//		notiserv.deleteNotification(id);
//	}
//	@GetMapping("getNotificationbymemberid/{memberId}")
//	public List<Notification> getNotificationByMemberId(@PathVariable("memberId")  int id)
//	{
//		return notiserv.getNotificationByMemberId(id);
//	}

}
