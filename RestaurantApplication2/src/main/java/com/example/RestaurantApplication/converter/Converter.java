package com.example.RestaurantApplication.converter;

import com.example.RestaurantApplication.dto.MenuDto;
import com.example.RestaurantApplication.dto.OrderDto;
import com.example.RestaurantApplication.model.MenuModel;
import com.example.RestaurantApplication.model.OrderModel;

public class Converter {
	
	public MenuModel convertDtoToModel (MenuDto menuDto, MenuModel menuModel) {
		menuModel.setDish_availability(menuDto.getDish_availability());
		menuModel.setDish_name(menuDto.getDish_name());
		menuModel.setDish_on_sale(menuDto.getDish_on_sale());
		menuModel.setDish_selling_period(menuDto.getDish_selling_period());
		return menuModel;
	}
	
	public MenuDto convertModelToDto (MenuModel menuModel, MenuDto menuDto) {
		menuDto.setDish_availability(menuModel.getDish_availability());
		menuDto.setDish_name(menuModel.getDish_name());
		menuDto.setDish_on_sale(menuModel.getDish_on_sale());
		menuDto.setDish_selling_period(menuModel.getDish_selling_period());
		return menuDto;
	}
	
	public OrderModel convertOrderDtoToModel (OrderDto orderDto, OrderModel orderModel) {
		orderModel.setCustomer_name(orderDto.getCustomer_name());
		orderModel.setOrder_delivery_adress(orderDto.getOrder_delivery_adress());
		orderModel.setQuantity(orderDto.getQuantity());
		orderModel.setDish_name(orderDto.getDish_name());
		return orderModel;
	}
	
	public OrderDto convertOrderModelToDto (OrderModel orderModel, OrderDto orderDto) {
		orderDto.setCustomer_name(orderModel.getCustomer_name());
		orderDto.setOrder_id(orderModel.getOrder_id());
		orderDto.setOrder_delivery_adress(orderModel.getOrder_delivery_adress());
		orderDto.setDish_name(orderModel.getDish_name());
		//orderDto.setOrder_status(orderModel.getOrder_status());
		return orderDto;
	}
	
	public OrderModel convert(OrderDto orderDto) {
		OrderModel orderModel = new OrderModel();
		
		orderModel.setDish_name(orderDto.getDish_name());
		orderModel.setCustomer_name(orderDto.getCustomer_name());
		orderModel.setOrder_delivery_adress(orderDto.getOrder_delivery_adress());
		orderModel.setQuantity(orderDto.getQuantity());

		return orderModel;
	}

}