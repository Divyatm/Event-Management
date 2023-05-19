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

import com.example.demo.entity.Equipment;
import com.example.demo.entity.FoodItem;
import com.example.demo.persitance.FoodItemRepo;
import com.example.demo.service.FoodItem_Service;

@RestController
@RequestMapping("/foodItem")
@CrossOrigin("*")
public class FoodItemController 
{
	private FoodItem_Service fooditemserv;
	@Autowired
	public FoodItemController(FoodItem_Service fooditemserv) {
		super();
		this.fooditemserv = fooditemserv;
	}
	// Add Food Item
	//@PostMapping("/insertFoodItems")
	@PostMapping("/add")
	public void insertAllFoodItem(@RequestBody FoodItem localfooditem) 
	{
		fooditemserv.addFoodItem(localfooditem);
	}
	// Update Food Item
	//@PutMapping("/updateFoodItems")
	@PutMapping("/updateFoodItem")
	public void updateFood(@RequestBody FoodItem localfooditem) 
	{
		fooditemserv.updateFoodItem(localfooditem);
	}
	// Delete food item
	//@DeleteMapping("/deleteFoodItems/{food_item_id}")
	@DeleteMapping("/deleteFoodItem/{food_item_id}")
	public void deleteFoodByFoodId(@PathVariable("food_item_id")  int id)
	{
		fooditemserv.deleteFoodItembyId(id);
		
	}
	// Get Food Item by Id
	//@GetMapping("getFoodItems/{food_item_id}")
	@GetMapping("/getFoodItem/{food_item_id}")
	public FoodItem getFoodByFoodId(@PathVariable("food_item_id")  int id)
	{
		 return fooditemserv.getFoodItem(id);
		
	}
	// Handler for get food Items by venueId
	//@GetMapping("getfooditembyvenueid/{venueid}")
	
	@GetMapping("/getFoodItems/{venue_id}")
	public List<FoodItem> getFoodItemsByVenueId(@PathVariable("venue_id")  int venueId) 
	{
		return fooditemserv.getFoodItemsByVenueId(venueId);
	}
	
	@DeleteMapping("deletefooditembyvenue/{venueid}")
	public void deleteFoodItemsByVenueId(@PathVariable("venueid") int venueId)
    {
		fooditemserv.deleteFoodItemsByVenueId(venueId);
    }

}