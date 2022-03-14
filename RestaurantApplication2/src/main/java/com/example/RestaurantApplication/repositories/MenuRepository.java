package com.example.RestaurantApplication.repositories;

import com.example.RestaurantApplication.model.MenuModel;

import org.springframework.data.jpa.repository.JpaRepository;



public interface MenuRepository extends JpaRepository<MenuModel, Integer> {

	
}