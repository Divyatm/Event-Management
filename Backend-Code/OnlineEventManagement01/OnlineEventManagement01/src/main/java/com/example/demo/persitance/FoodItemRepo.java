package com.example.demo.persitance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.FoodItem;

public interface FoodItemRepo extends JpaRepository<FoodItem, Integer> 
{
	@Query("from FoodItem where venueId=?1")
	public List<FoodItem> getFoodItemsByVenueId(int venueId);
	
	@Query("delete from FoodItem where venueId=?1")
	public void deleteFoodItemsByVenueId(int venueId);

}
