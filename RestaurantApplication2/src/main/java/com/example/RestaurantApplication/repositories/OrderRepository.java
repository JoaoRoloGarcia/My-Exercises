package com.example.RestaurantApplication.repositories;

import com.example.RestaurantApplication.model.OrderModel;

import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderRepository extends JpaRepository<OrderModel, Integer> {

}