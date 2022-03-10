package com.example.RestaurantApplication.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class OrderDto {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer order_id;
	private String order_delivery_adress;
	private String customer_name;
	
	public Integer getDish_id() {
		return order_id;
	}

	public void setDish_id(Integer dish_id) {
		this.order_id = dish_id;
	}

	public String getOrder_delivery_adress() {
		return order_delivery_adress;
	}

	public void setOrder_delivery_adress(String order_delivery_adress) {
		this.order_delivery_adress = order_delivery_adress;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	
	public OrderDto(Integer dish_id, String order_delivery_adress, String customer_name) {
		super();
		this.order_id = dish_id;
		this.order_delivery_adress = order_delivery_adress;
		this.customer_name = customer_name;
	}

	public OrderDto() { }

	@Override
	public String toString() {
		return "OrderDto [dish_id=" + order_id + "]";
	}
}
