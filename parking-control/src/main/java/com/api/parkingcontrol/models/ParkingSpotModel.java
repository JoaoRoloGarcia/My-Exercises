package com.api.parkingcontrol.models;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PARKING_SPOT_Joao")
public class ParkingSpotModel implements Serializable {

	private static final long serialVersionID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(nullable = false, unique = true, length = 10)
	private String parkingSpotNumber;
	@Column(nullable = false, unique = true, length = 7)
	private String licensePlateCar;
	@Column(nullable = false, length = 70)
	private String brandCar;
	@Column(nullable = false, length = 70)
	private String modelCar;
	@Column(nullable = false, length = 70)
	private String colorCar;
	@Column(nullable = false)
	private LocalDateTime registrationDateTime;
	@Column(nullable = false, length = 70)
	private String responsibleName;
	@Column(nullable = false, length = 70)
	private String apartment;
	@Column(nullable = false, length = 70)
	private String block;
	
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getParkingSpotNumber() {
		return parkingSpotNumber;
	}
	public void setParkingSpotNumber(String parkingSpotNumber) {
		this.parkingSpotNumber = parkingSpotNumber;
	}
	public String getLicensePlateCar() {
		return licensePlateCar;
	}
	public void setLicensePlateCar(String licensePlateCar) {
		this.licensePlateCar = licensePlateCar;
	}
	public String getBrandCar() {
		return brandCar;
	}
	public void setBrandCar(String brandCar) {
		this.brandCar = brandCar;
	}
	public String getModelCar() {
		return modelCar;
	}
	public void setModelCar(String modelCar) {
		this.modelCar = modelCar;
	}
	public String getColorCar() {
		return colorCar;
	}
	public void setColorCar(String colorCar) {
		this.colorCar = colorCar;
	}
	public LocalDateTime getRegistrationDateTime() {
		return registrationDateTime;
	}
	public void setRegistrationDateTime(LocalDateTime registrationDateTime) {
		this.registrationDateTime = registrationDateTime;
	}
	public String getResponsibleName() {
		return responsibleName;
	}
	public void setResponsibleName(String responsibleName) {
		this.responsibleName = responsibleName;
	}
	public String getApartment() {
		return apartment;
	}
	public void setApartment(String apartment) {
		this.apartment = apartment;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	public static long getSerialversionid() {
		return serialVersionID;
	}
	
	
}
