package com.api.parkingcontrol.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.parkingcontrol.dtos.ParkingSpotDto;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.services.ParkingSpotService;

import returns.Returns;

@RestController
@RequestMapping("/parking-spot")
public class ParkingSpotController {

	final ParkingSpotService parkingSpotService;

	public ParkingSpotController(ParkingSpotService parkingSpotService) {
		this.parkingSpotService = parkingSpotService;
	}

	@PostMapping("/getAll")
	public List<ParkingSpotModel> getAllSpots() {
		return parkingSpotService.getAllSpots();
	}

	@PostMapping
	@RequestMapping("/savedSpot")
	public Returns saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto) {
		ParkingSpotModel parkingSpotModel = new ParkingSpotModel();
		Returns retValues = new Returns();
		
		try {
			parkingSpotModel.setApartment(parkingSpotDto.getApartment());
			parkingSpotModel.setBlock(parkingSpotDto.getBlock());
			parkingSpotModel.setBrandCar(parkingSpotDto.getBrandCar());
			parkingSpotModel.setColorCar(parkingSpotDto.getColorCar());
			parkingSpotModel.setLicensePlateCar(parkingSpotDto.getLicensePlateCar());
			parkingSpotModel.setModelCar(parkingSpotDto.getModelCar());
			parkingSpotModel.setParkingSpotNumber(parkingSpotDto.getParkingSpotNumber());
			parkingSpotModel.setResponsibleName(parkingSpotDto.getResponsibleName());
			parkingSpotModel.setRegistrationDateTime(LocalDateTime.now(ZoneId.of("GMT")));
			
			parkingSpotService.save(parkingSpotModel);
			
			retValues.setResult("OK");
			retValues.setMsg("Parking Spot saved correctly.");
			retValues.setCat("201");
			
		} catch (Exception e) {
			
			
			retValues.setResult("ERROR");
			retValues.setMsg(e.getMessage() + "Parking Spot was not saved.");
			retValues.setCat("NO ES BUENO");
		}
		
		return retValues;
	}

	// alterar return qnd nao encontra, retornar JSON, try catch (mm que rebente) || QQ É SUPOSTO RECEBERRRRRRRRRRRR
	@PostMapping("/getParkingSpot")
	public ParkingSpotModel getOneParkingSpot(@RequestBody ParkingSpotModel parkingSpotModel) {
		
		Returns retValues = new Returns();
		
		try { 	
				
		
			if (parkingSpotService.findById(parkingSpotModel.getId()).isPresent()) {
				
				retValues.setMsg("Parking Spot found.");
				return parkingSpotService.findById(parkingSpotModel.getId()).get();
			}
			
		} catch (Exception e){
			
			retValues.setResult("ERROR");
			retValues.setMsg(e.getMessage() + "Parking Spot was not found.");
			retValues.setCat("NO ES BUENITO");
		}
		
		//return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findById(parkingSpotModel.getId()).get());
		return parkingSpotService.findById(parkingSpotModel.getId()).get();
	}
	
	
	
	
	// mesmo do metodo de cima
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteParkingSpot(@PathVariable(value = "id") UUID id) {
		Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
		if (!parkingSpotModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
		}
		parkingSpotService.delete(parkingSpotModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Parking Spot deleted sucessfully!");
	}

	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateParkingSpot(@PathVariable(value = "id") UUID id,
			@RequestBody @Valid ParkingSpotDto parkingSpotDto) {
		Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
		if (!parkingSpotModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
		}

		ParkingSpotModel parkingSpotModel = parkingSpotModelOptional.get();
		parkingSpotModel.setParkingSpotNumber(parkingSpotDto.getParkingSpotNumber());
		parkingSpotModel.setLicensePlateCar(parkingSpotDto.getLicensePlateCar());
		parkingSpotModel.setModelCar(parkingSpotDto.getModelCar());
		parkingSpotModel.setBrandCar(parkingSpotDto.getBrandCar());
		parkingSpotModel.setColorCar(parkingSpotDto.getColorCar());
		parkingSpotModel.setResponsibleName(parkingSpotDto.getResponsibleName());
		parkingSpotModel.setApartment(parkingSpotDto.getApartment());
		parkingSpotModel.setBlock(parkingSpotDto.getBlock());

		return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.save(parkingSpotModel));
	}
}
