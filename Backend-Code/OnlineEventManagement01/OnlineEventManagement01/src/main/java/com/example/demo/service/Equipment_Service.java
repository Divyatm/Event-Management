package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Equipment;
import com.example.demo.persitance.EquipmentRepo;

@Service
public class Equipment_Service {
	private EquipmentRepo Equiprepo;

	@Autowired
	public Equipment_Service(EquipmentRepo equiprepo) {
		super();
		Equiprepo = equiprepo;
	}
	// add equipment
	@Transactional
	public void addEquipment(Equipment localequipment) {
		Equiprepo.save(localequipment);
	}
	// update equipment
	@Transactional
	public void updateEquipment(Equipment localequipment) {
		Equiprepo.save(localequipment);
	}
	// get equipment
	@Transactional
	 public Equipment getEquipment(int id)
	 {
		 return Equiprepo.findById(id).get();
	 }
	// delete equipment
    @Transactional
    public void deleteEquipmentbyId(int id)
    {
    	Equiprepo.deleteById(id);
    }
	// get equipment by venueId
    @Transactional
    public List<Equipment> getEquipmentsByVenueId(int venueId)
    {
    	return Equiprepo.getEquipmentsByVenueId(venueId);
    }
    
    @Transactional
    public void deleteEquipmentByVenueId(int venueId)
    {
    	Equiprepo.deleteEquipmentByVenueId(venueId);
    }
}
