package com.example.RestaurantApplication.repositories;

import com.example.RestaurantApplication.model.OrderModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;


public interface OrderRepository extends JpaRepository<OrderModel, Integer> {

    @Query(value = "SELECT * FROM orders_jrg WHERE transaction_id = :transaction_id", nativeQuery = true)
    OrderModel getByTransactionId(String transaction_id);

    @Query(value = "SELECT meals_available FROM menu_jrg WHERE dish_name = :dish_name", nativeQuery = true)
    int getByAmount(String dish_name);

    @Transactional
    @Modifying
    @Query(value = "UPDATE menu_jrg SET meals_available = :meals_available WHERE dish_name = :dish_name", nativeQuery = true)
    void updateMealValue(int meals_available, String dish_name);
}