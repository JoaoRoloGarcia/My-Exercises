package com.api.parkingcontrol.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;

@Service
public class ParkingSpotService {

	
	final ParkingSpotRepository parkingSpotRepository;
	
	public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
		this.parkingSpotRepository = parkingSpotRepository;
	}
	
	// usado em metodos contrutivos/destrutivos, permite fazer o rollback
	@Transactional
	public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
		return parkingSpotRepository.saveAndFlush(parkingSpotModel);
	}
	
	public List<ParkingSpotModel> getAllSpots() {
	return parkingSpotRepository.findAll();
	}

	public Optional<ParkingSpotModel> findById(UUID id) {
		return parkingSpotRepository.findById(id);
	}

	@Transactional
	public void delete(ParkingSpotModel parkingSpotModel) {
		parkingSpotRepository.delete(parkingSpotModel);
	}
	
}