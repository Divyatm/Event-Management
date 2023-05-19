package com.example.demo.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Equipment")
public class Equipment {
	@Id
	@Column(name="equipmentId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int equipmentId;
	@Column(name="equipmentName")
	private String equipmentName;
	@Column(name="equipmentCost")
	private int equipmentCost;
	@Column(name="venueId")
	private int venueId;
	@ManyToOne(targetEntity = Venue.class, fetch=FetchType.EAGER)
	@JoinColumn(name="venueId",insertable = false,updatable = false)
	private Venue venue;
	public int getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(int equipmentId) {
		this.equipmentId = equipmentId;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public int getEquipmentCost() {
		return equipmentCost;
	}
	public void setEquipmentCost(int equipmentCost) {
		this.equipmentCost = equipmentCost;
	}
	
	public int getVenueId() {
		return venueId;
	}
	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}
	public Equipment(int equipmentId, String equipmentName, int equipmentCost, int venueId) {
		super();
		this.equipmentId = equipmentId;
		this.equipmentName = equipmentName;
		this.equipmentCost = equipmentCost;
		this.venueId = venueId;
	}
	
	public Equipment() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Equipment [equipmentId=" + equipmentId + ", equipmentName=" + equipmentName + ", equipmentCost="
				+ equipmentCost + ", venueId=" + venueId + "]";
	}
	
	
		
}
