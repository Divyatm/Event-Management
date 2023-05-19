package com.example.demo.entity;

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
@Table(name="Notification")
public class Notification {
	@Id
	@Column(name="notificationId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int notificationId; 
	@Column(name="time")
	private String time;
	@Column(name="date")
	private String date;
	@Column(name="message")
	private String message;

	@Column(name="memberId")
	private int memberId;
	@ManyToOne(targetEntity = Member.class, fetch=FetchType.EAGER)
	@JoinColumn(name="memberId",insertable = false,updatable = false)
	private Member member;
	public int getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public Notification(int notificationId, String time, String date, String message, int memberId) {
		super();
		this.notificationId = notificationId;
		this.time = time;
		this.date = date;
		this.message = message;
		this.memberId = memberId;
	}
	
	
	public Notification() 
	{
		
	}
	
	@Override
	public String toString() {
		return "Notification [notificationId=" + notificationId + ", time=" + time + ", date=" + date + ", message="
				+ message + ", memberId=" + memberId + "]";
	}
	
	
	
}
