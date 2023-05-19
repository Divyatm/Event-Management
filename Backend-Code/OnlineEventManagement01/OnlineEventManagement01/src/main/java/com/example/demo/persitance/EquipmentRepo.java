package com.example.demo.persitance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Equipment;

public interface EquipmentRepo extends JpaRepository<Equipment, Integer> 
{
	@Query("from Equipment where venueId=?1")
	public List<Equipment> getEquipmentsByVenueId(int venueId);

	@Query("delete from Equipment where venueId=?1")
	public void deleteEquipmentByVenueId(int venueId);

}
