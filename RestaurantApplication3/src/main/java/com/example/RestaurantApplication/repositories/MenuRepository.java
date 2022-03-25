package com.example.RestaurantApplication.repositories;

import com.example.RestaurantApplication.model.MenuModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface MenuRepository extends JpaRepository<MenuModel, Integer> {

    @Query(value = "SELECT * FROM menu_jrg WHERE dish_name = :dish_name", nativeQuery = true)
    MenuModel getByDishName(String dish_name);

    @Query(value = "SELECT * FROM menu_jrg WHERE dish_availability = 1 AND week = :current_week", nativeQuery = true)
    List<MenuModel> getByWeek(int current_week);




}