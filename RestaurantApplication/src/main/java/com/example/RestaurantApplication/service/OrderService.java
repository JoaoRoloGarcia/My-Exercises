package com.example.RestaurantApplication.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RestaurantApplication.model.FoodStatus;
import com.example.RestaurantApplication.model.OrderModel;
import com.example.RestaurantApplication.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	final OrderRepository orderRepository;
	
	public OrderService (OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	@Transactional
	public OrderModel save(OrderModel orderModel) {
		return orderRepository.saveAndFlush(orderModel);
	}
	
	public List<OrderModel> getAll() {
	return orderRepository.findAll();
	}

	public Optional<OrderModel> findById(Integer id) {
		return orderRepository.findById(id);
	}

	@Transactional
	public void delete(OrderModel orderModel) {
		orderRepository.delete(orderModel);
	}
	public FoodStatus getOrderStatus(Integer id) {	
		OrderModel orderModel = orderRepository.getById(id);
		return orderModel.getOrder_status();
	}

}