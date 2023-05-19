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
import com.example.demo.service.Equipment_Service;

@RestController
@RequestMapping("/equipment")
@CrossOrigin("*")
public class EquipmentController {
	private Equipment_Service equiserv;
	@Autowired
	public EquipmentController(Equipment_Service equiserv) {
		super();
		this.equiserv = equiserv;
	}
	// Handler for adding new Equipment
	//@PostMapping("/insertEquipments")
	@PostMapping("/add")
	public void insertAllEquipments(@RequestBody Equipment localequipment) 
	{
		equiserv.addEquipment(localequipment);
	}
	// Handler to update Equipment
	@PutMapping("/updateEquipment")
	//@PutMapping("/updateEquipments")
	public void updateEquipments(@RequestBody Equipment localequipment) 
	{
		equiserv.updateEquipment(localequipment);
	}
	// Handler to delete equipment
	//@DeleteMapping("/deleteEquipment/{equipmentId}")
	@DeleteMapping("/deleteEquipment/{equipment_id}")
	public void deleteEquipmentsByEquipmentID(@PathVariable("equipment_id")  int id)
	{
		equiserv.deleteEquipmentbyId(id);
		
	}
	// Handler to get Equipment by ID
	//@GetMapping("/getEquipment/{equipmentId}")
	@GetMapping("getEquipment/{equipment_id}")
	public Equipment getEquipmentById(@PathVariable("equipment_id")  int id)
	{
		 return equiserv.getEquipment(id);
		
	}
	
	//@GetMapping("getEquipmentVenueId/{venueId}")
	// Handler for get equipments by venueId
	//@GetMapping("getEquipmentVenueId/{venueId}")
	@GetMapping("/getEquipments/{venue_id}")
	public List<Equipment> getEquipmentsByVenueId(@PathVariable("venue_id") int venue_id)
	{
		return equiserv.getEquipmentsByVenueId(venue_id);
	}

	@DeleteMapping
	public void deleteEquipmentByVenueId(int venueId)
	{
		equiserv.deleteEquipmentByVenueId(venueId);
	}
	
	
	


}