package com.example.RestaurantApplication.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.RestaurantApplication.converter.Converter;
import com.example.RestaurantApplication.dto.OrderDto;
import com.example.RestaurantApplication.model.OrderStatus;
import com.example.RestaurantApplication.model.OrderModel;
import com.example.RestaurantApplication.returns.OrderResponse;
import com.example.RestaurantApplication.service.OrderService;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

	@Autowired
	final OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping("/getOrder")
	public List<OrderModel> getOrder() {
		return orderService.getAll();
	}

	// PERGUNTAR SE QUANDO TEMOS VÁRIOS OBJECTOS DO MESMO TIPO INSTANCIADO EM
	// MÉTODOS DIFERENTES; BOA PRÁTICA METE-LOS COMO PROP?
	@PostMapping("/addOrder")
	public OrderResponse addOrder(@RequestBody OrderDto orderDto) {
		OrderResponse retValues = new OrderResponse();
		Converter converter = new Converter();
		OrderModel orderModel = new OrderModel();
		try {
			retValues.setStatus("OK");
			retValues.setStatusCode("200");
			retValues.setMsg("Order added succesfully!");
			retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
			orderModel.setOrderStatus(OrderStatus.ACCEPTED);
			retValues.setResValues(orderDto);
			orderService.save(converter.convertOrderDtoToModel(orderDto, orderModel));
			return retValues;

		} catch (Exception e) {
			
			retValues.setStatus("NOK");
			retValues.setStatusCode("400");
			retValues.setMsg("You are doing something wrong: " + e);
			retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
			retValues.setResValues(orderDto);
			e.getMessage();
		}
		return retValues;
	}

	// FEITOOOOOO
	@PostMapping("/{id}")
	public OrderResponse updateOrder(@PathVariable(value = "id") Integer id, @RequestBody OrderDto orderDto) {
		Optional<OrderModel> orderModelOptional = orderService.findById(id);
		OrderResponse retValues = new OrderResponse();
		Converter converter = new Converter();
		try {
			if (orderModelOptional.isEmpty()) {
				retValues.setStatus("NOK");
				retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
				retValues.setStatusCode("500");
				retValues.setMsg("Order ID was not found");
				retValues.setResValues(orderDto);
			}
			OrderModel orderModel = orderModelOptional.get();

			retValues.setStatus("OK");
			retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
			retValues.setStatusCode("200");
			retValues.setMsg("Order updated succesfully!");
			orderService.save(converter.convertOrderDtoToModel(orderDto, orderModel));
			retValues.setResValues(orderDto);

			return retValues;
		} catch (Exception e) {
			retValues.setMsg("Something is wrong: " + e);
			e.getMessage();
		}
		return retValues;
	}

	// NÃO FEITO, PERCEBER LÓGICA DE MEXER EM ENUMS   || "order_Status" cannot be null
	@PostMapping("/orderStatus")
	public OrderModel changeFoodStatus(@RequestBody OrderDto orderDto) {
		OrderResponse retValues = new OrderResponse();
		OrderStatus orderStatus = orderService.getOrderStatus(orderDto.getOrder_id());
		Converter converter = new Converter();
		
		OrderModel orderModel = orderService.save(converter.convert(orderDto));

		switch (orderStatus) {
		case ACCEPTED:
			retValues.setFoodStatus(OrderStatus.PREPARING);
			retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
			break;
		case PREPARING:
			retValues.setFoodStatus(OrderStatus.DELIVERING);
			retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
			break;
		case DELIVERING:
			retValues.setFoodStatus(OrderStatus.DELIVERED);
			retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
		default:
			retValues.setMsg("Your order is being processed. Please wait");
			break;
		}
		return orderService.save(orderModel);
	}

	// Done || É só introduzir o ID
	@DeleteMapping("/{id}")
	public OrderResponse cancelOrder(@PathVariable(value = "id") @RequestBody Integer id) {
		Optional<OrderModel> orderModelOptional = orderService.findById(id);
		OrderResponse retValues = new OrderResponse();
		if (orderModelOptional.isEmpty()) {
			retValues.setStatus("NOK");
			retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
			retValues.setStatusCode("500");
			retValues.setMsg("Could not find the ID you provided.");
			return retValues;
		}
		orderService.delete(orderModelOptional.get());
		retValues.setStatus("OK");
		retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
		retValues.setStatusCode("200");
		retValues.setMsg("Your order was succesfully canceled.");
		return retValues;
	}
}