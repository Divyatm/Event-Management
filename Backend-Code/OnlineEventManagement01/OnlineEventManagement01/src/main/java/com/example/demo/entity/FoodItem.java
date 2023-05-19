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
@Table(name="FoodItem")
public class FoodItem {
	@Id
	@Column(name="foodItemId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int foodItemId;
	@Column(name="foodItemName")
	private String foodItemName;
	@Column(name="foodItemCost")
	private int foodItemCost;
	@Column(name="venueId")
	private int venueId;
	@ManyToOne(targetEntity = Venue.class, fetch=FetchType.EAGER)
	@JoinColumn(name="venueId",insertable = false,updatable = false)
	private Venue venue;
	
	public int getFoodItemId() {
		return foodItemId;
	}
	public void setFoodItemId(int foodItemId) {
		this.foodItemId = foodItemId;
	}
	public String getFoodItemName() {
		return foodItemName;
	}
	public void setFoodItemName(String foodItemName) {
		this.foodItemName = foodItemName;
	}
	public int getFoodItemCost() {
		return foodItemCost;
	}
	public void setFoodItemCost(int foodItemCost) {
		this.foodItemCost = foodItemCost;
	}
	public int getVenueId() {
		return venueId;
	}
	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}
	public FoodItem(int foodItemId, String foodItemName, int foodItemCost, int venueId) {
		super();
		this.foodItemId = foodItemId;
		this.foodItemName = foodItemName;
		this.foodItemCost = foodItemCost;
		this.venueId = venueId;
	}
	public FoodItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "FoodItem [foodItemId=" + foodItemId + ", foodItemName=" + foodItemName + ", foodItemCost="
				+ foodItemCost + ", venueId=" + venueId + "]";
	}
	
	
	
}
