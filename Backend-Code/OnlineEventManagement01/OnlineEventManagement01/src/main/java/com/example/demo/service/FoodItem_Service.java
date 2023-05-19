package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.example.demo.entity.FoodItem;
import com.example.demo.persitance.FoodItemRepo;

@Service
public class FoodItem_Service {
	private FoodItemRepo  fooditrepo;
	
    @Autowired
	public FoodItem_Service(FoodItemRepo fooditrepo) {
		super();
		this.fooditrepo = fooditrepo;
	}
 // Add...
    @Transactional
	public void addFoodItem(FoodItem localfooditem) {
    	fooditrepo.save(localfooditem);
	}
 // Update...

	@Transactional
	public void updateFoodItem(FoodItem localfooditem) {
		fooditrepo.save(localfooditem);
		
	}
	// Get...
	@Transactional
	 public FoodItem getFoodItem(int id)
	 {
		 return fooditrepo.findById(id).get();
	 }
	 //Delete 
    @Transactional
    public void deleteFoodItembyId(int id)
    {
    	fooditrepo.deleteById(id);
    }
	// Get food Items by venueId
    @Transactional
    public List<FoodItem> getFoodItemsByVenueId(int venueId)
    {
    	return fooditrepo.getFoodItemsByVenueId(venueId);
    }

    @Transactional
    public void deleteFoodItemsByVenueId(int venueId)
    {
    	fooditrepo.deleteFoodItemsByVenueId(venueId);
    }
    

	
	

}
