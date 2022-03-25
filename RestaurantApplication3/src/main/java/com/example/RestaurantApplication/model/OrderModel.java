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
	@Column(name = "order_delivery_address")
	private String order_delivery_address;
	@Column(name = "customer_name")
	private String customer_name;
	@Column(name = "quantity")
	private Integer quantity;
	@Column(name = "dish_name")
	private String dish_name;
	@Column(name = "transaction_id")
	private String transaction_id;

	@Enumerated(EnumType.STRING)
	@Column(name = "order_status", columnDefinition = "varchar(255)")
	private OrderStatus order_Status;

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public String getOrder_delivery_address() {
		return order_delivery_address;
	}

	public void setOrder_delivery_address(String order_delivery_address) {
		this.order_delivery_address = order_delivery_address;
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

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public OrderStatus getOrder_Status() {
		return order_Status;
	}

	public void setOrder_Status(OrderStatus order_Status) {
		this.order_Status = order_Status;
	}

	public OrderModel(Integer order_id, String order_delivery_address, String customer_name, Integer quantity, String dish_name, String transaction_id, OrderStatus order_Status) {
		this.order_id = order_id;
		this.order_delivery_address = order_delivery_address;
		this.customer_name = customer_name;
		this.quantity = quantity;
		this.dish_name = dish_name;
		this.transaction_id = transaction_id;
		this.order_Status = order_Status;
	}

	public OrderModel() {}

	@Override
	public String toString() {
		return "OrderModel{" +
				"order_id=" + order_id +
				", order_delivery_address='" + order_delivery_address + '\'' +
				", customer_name='" + customer_name + '\'' +
				", quantity=" + quantity +
				", dish_name='" + dish_name + '\'' +
				", transaction_id='" + transaction_id + '\'' +
				", order_Status=" + order_Status +
				'}';
	}
}