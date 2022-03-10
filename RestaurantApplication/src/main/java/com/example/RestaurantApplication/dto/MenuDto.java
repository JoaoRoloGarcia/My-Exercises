package com.example.RestaurantApplication.dto;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class MenuDto {

	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer dish_id;
	private String dish_name;
	private Boolean dish_availability;
	private Boolean dish_on_sale;
	private Date dish_selling_period;
	
	/////////////////////////////////
	private Integer dish_selling_start;
	private Integer dish_selling_end;
	///////////////////////////////////

	
	public Integer getDish_id() {
		return dish_id;
	}

	public void setDish_id(Integer dish_id) {
		this.dish_id = dish_id;
	}

	
	public String getDish_name() {
		return dish_name;
	}

	public void setDish_name(String dish_name) {
		this.dish_name = dish_name;
	}

	public Boolean getDish_availability() {
		return dish_availability;
	}

	public void setDish_availability(Boolean dish_availability) {
		this.dish_availability = dish_availability;
	}

	public Boolean getDish_on_sale() {
		return dish_on_sale;
	}

	public void setDish_on_sale(Boolean dish_on_sale) {
		this.dish_on_sale = dish_on_sale;
	}

	public Date getDish_selling_period() {
		return dish_selling_period;
	}

	public void setDish_selling_period(Date dish_selling_period) {
		this.dish_selling_period = dish_selling_period;
	}

	public MenuDto() { }

	@Override
	public String toString() {
		return "ModelDto [dish_id=" + dish_id + "]";
	}

	public MenuDto(Integer dish_id, String dish_name, Boolean dish_availability, Boolean dish_on_sale,
			Date dish_selling_period) {
		super();
		this.dish_id = dish_id;
		this.dish_name = dish_name;
		this.dish_availability = dish_availability;
		this.dish_on_sale = dish_on_sale;
		this.dish_selling_period = dish_selling_period;
	}

	////////////////////////////////////////////////////
	
	public Integer getDish_selling_start() {
		return dish_selling_start;
	}

	public void setDish_selling_start(Integer dish_selling_start) {
		this.dish_selling_start = dish_selling_start;
	}

	public Integer getDish_selling_end() {
		return dish_selling_end;
	}

	public void setDish_selling_end(Integer dish_selling_end) {
		this.dish_selling_end = dish_selling_end;
	}
	
	
	
	
}