package com.example.RestaurantApplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders_jrg")
public class OrderModel {
	
	//TENHO QUE MANDAR BASE DE DADOS ABAIXO PARA METER NOVAS PROPRIEDADES
	//private Integer dishAmount;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer order_id;
	private String order_delivery_adress;
	private String customer_name;
//	@Enumerated(EnumType.STRING)
	
	//RESOLVER ESTA SITUAÇÃO ORDER STATUS; ESTÁ A LIXAR TODOS OS PEDIDOS
	private FoodStatus order_status;
	
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public FoodStatus getOrder_status() {
		return order_status;
	}
	public void setOrder_status(FoodStatus order_status) {
		this.order_status = order_status;
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
	
	@Override
	public String toString() {
		return "OrderModel [order_id=" + order_id + ", order_status=" + order_status + ", order_delivery_adress="
				+ order_delivery_adress + ", customer_name=" + customer_name + "]";
	}
	
}
