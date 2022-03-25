package com.example.RestaurantApplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu_jrg")
public class MenuModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer dish_id;
	private String dish_name;
	private int dish_availability;
	private int week;
	private int meals_available;


	public MenuModel(Integer dish_id, String dish_name, int dish_availability, int week, int meals_available) {
		this.dish_id = dish_id;
		this.dish_name = dish_name;
		this.dish_availability = dish_availability;
		this.week = week;
		this.meals_available = meals_available;
	}

	public MenuModel() {};

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

	public int getDish_availability() {
		return dish_availability;
	}

	public void setDish_availability(int dish_availability) {
		this.dish_availability = dish_availability;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public int getMeals_available() {
		return meals_available;
	}

	public void setMeals_available(int meals_available) {
		this.meals_available = meals_available;
	}

	@Override
	public String toString() {
		return "MenuModel{" +
				"dish_id=" + dish_id +
				", dish_name='" + dish_name + '\'' +
				", dish_availability=" + dish_availability +
				", week=" + week +
				", meals_available=" + meals_available +
				'}';
	}
}