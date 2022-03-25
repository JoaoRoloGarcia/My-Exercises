package com.example.RestaurantApplication.returns;

import java.time.LocalDateTime;
import java.time.ZoneId;
import com.example.RestaurantApplication.model.OrderModel;
import com.example.RestaurantApplication.model.OrderStatus;

public class OrderResponse extends Response {


	private OrderModel resValues;
	private OrderStatus orderStatus;

	public OrderResponse() {}

	public OrderModel getResValues() {
		return resValues;
	}

	public void setResValues(OrderModel resValues) {
		this.resValues = resValues;
	}


	public OrderStatus getFoodStatus() {
		return orderStatus;
	}

	public void setFoodStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public OrderResponse setPositiveResponse (OrderModel orderModel) {
		OrderResponse retValues = new OrderResponse();
		retValues.setStatus("OK");
		retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
		retValues.setStatusCode("200");
		retValues.setMsg("Everything went well");

		retValues.setResValues(orderModel);
		return retValues;
	}

	public OrderResponse setPositiveResponseTmp (OrderModel orderModel, OrderResponse retValues) {

		retValues.setStatus("OK");
		retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
		retValues.setStatusCode("200");
		retValues.setMsg("Everything went well");

		retValues.setResValues(orderModel);
		return retValues;
	}

	public OrderResponse setNegativeResponse (OrderModel orderModel) {
		OrderResponse retValues = new OrderResponse();
		retValues.setStatus("NOK");
		retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
		retValues.setStatusCode("400");
		retValues.setMsg("Something went wrong.");

		retValues.setResValues(orderModel);
		return retValues;
	}

	public OrderResponse setNegativeResponseNoDTO () {
		OrderResponse retValues = new OrderResponse();
		retValues.setStatus("NOK");
		retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
		retValues.setStatusCode("400");
		retValues.setMsg("Something went wrong.");
		return retValues;
	}

	public OrderResponse setPositiveResponseNoDTO () {
		OrderResponse retValues = new OrderResponse();
		retValues.setStatus("OK");
		retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
		retValues.setStatusCode("200");
		retValues.setMsg("Everything went well");

		return retValues;
	}
	
}