package com.example.RestaurantApplication.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import com.example.RestaurantApplication.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping("/addOrder")
    public OrderResponse addOrder(@RequestBody OrderModel orderModel) {
        OrderResponse retValues = new OrderResponse();
        try {
            if (orderService.isAvailable(orderModel)) {

                orderModel.setOrder_Status(OrderStatus.ACCEPTED);
                orderService.save(orderModel);
                retValues.setStatus("OK");
                retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
                retValues.setStatusCode("200");
                retValues.setMsg("Order submitted successfully!");
                retValues.setResValues(orderModel);
            }
        } catch (Exception e) {
            retValues.setStatus("NOK");
            retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
            retValues.setStatusCode("400");
            retValues.setMsg("Could not add the order.");
            retValues.setMsg("Something went wrong: " + e.getMessage());
        }
        return retValues;
    }

    //IT'S WORKING GGGGGGGGGGGGGGGGGGGGGGGG (again)
    @PostMapping("/updateOrder")
    public OrderResponse updateOrder(@RequestBody OrderModel order) {
        OrderResponse retValues = new OrderResponse();
        OrderModel oldOrder;

        try {

            oldOrder = orderService.getByTransaction(order);

            if (!oldOrder.getTransaction_id().isEmpty() && orderService.verification(order, oldOrder)) {
                if(order.getOrder_Status().equals(OrderStatus.CANCELED)) {
                    orderService.canceledOrder(order);
                }
                orderService.save(order);

                retValues.setStatus("OK");
                retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
                retValues.setStatusCode("200");
                retValues.setMsg("Order updated successfully!");
                retValues.setResValues(order);

            } else {
                retValues.setStatus("NOK");
                retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
                retValues.setStatusCode("404");
                retValues.setMsg("Transaction Id not found or changes not allowed");
                retValues.setResValues(order);
            }

        } catch (Exception e) {

            retValues.setStatus("ERROR: " + e.getMessage());
            retValues.setSentOn(LocalDateTime.now(ZoneId.of("GMT")));
            retValues.setStatusCode("500");
            retValues.setMsg("Menu ID was not found");
        }
        return retValues;
    }

    // Done || É só introduzir o ID
    @DeleteMapping("/{id}")
    public OrderResponse cancelOrder(@PathVariable(value = "id") @RequestBody Integer id) {
        Optional<OrderModel> orderModelOptional = orderService.findById(id);
        OrderResponse retValues = new OrderResponse();
        if (orderModelOptional.isEmpty()) {
            return retValues.setNegativeResponseNoDTO();
        }
        orderService.delete(orderModelOptional.get());
        return retValues.setPositiveResponseNoDTO();
    }
}