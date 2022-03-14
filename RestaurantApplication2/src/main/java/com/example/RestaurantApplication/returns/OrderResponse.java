package com.example.RestaurantApplication.returns;

import java.time.LocalDateTime;
import com.example.RestaurantApplication.dto.OrderDto;
import com.example.RestaurantApplication.model.OrderStatus;

public class OrderResponse extends Response {

	private OrderDto resValues;
	private OrderStatus orderStatus;

	public OrderResponse(String status, LocalDateTime sentOn, String statusCode, String transactionID, String msg) {
		super(status, sentOn, statusCode, transactionID, msg);
	}
	
	public OrderResponse() {}

	public OrderDto getResValues() {
		return resValues;
	}

	public void setResValues(OrderDto resValues) {
		this.resValues = resValues;
	}

	public OrderStatus getFoodStatus() {
		return orderStatus;
	}

	public void setFoodStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	
}