package com.example.RestaurantApplication.returns;

import java.time.LocalDateTime;
import com.example.RestaurantApplication.dto.OrderDto;
import com.example.RestaurantApplication.model.FoodStatus;

public class OrderResponse extends Response {

	private OrderDto resValues;
	private FoodStatus foodStatus;

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

	public FoodStatus getFoodStatus() {
		return foodStatus;
	}

	public void setFoodStatus(FoodStatus foodStatus) {
		this.foodStatus = foodStatus;
	}
	
}