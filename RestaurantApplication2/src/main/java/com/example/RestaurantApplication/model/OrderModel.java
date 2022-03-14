package com.example.RestaurantApplication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders_jrg")
public class OrderModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer order_id;
	@Column(name = "order_delivery_adress")
	private String order_delivery_adress;
	@Column(name = "customer_name")
	private String customer_name;
	@Column(name = "quantity")
	private Integer quantity;
	@Column(name = "dish_name")
	private String dish_name;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "order_status", columnDefinition = "varchar(255)")
	private OrderStatus order_Status;

	public OrderStatus getOrderStatus() {
		return order_Status;
	}

	public void setOrderStatus(OrderStatus order_Status) {
		this.order_Status = order_Status;
	}
	
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDish_name() {
		return dish_name;
	}

	public void setDish_name(String dish_name) {
		this.dish_name = dish_name;
	}
}