package com.example.RestaurantApplication.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import javax.transaction.Transactional;

import com.example.RestaurantApplication.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RestaurantApplication.model.OrderStatus;
import com.example.RestaurantApplication.model.OrderModel;
import com.example.RestaurantApplication.repositories.OrderRepository;

@Service
public class OrderService {

    @Autowired
    final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public OrderModel save(OrderModel orderModel) {
        orderModel.setTransaction_id(UUID.randomUUID().toString());
        return orderRepository.saveAndFlush(orderModel);
    }

    public List<OrderModel> getAll() {
        return orderRepository.findAll();
    }

    public Optional<OrderModel> findById(Integer id) {
        return orderRepository.findById(id);
    }

    @Transactional
    public void delete(OrderModel orderModel) {
        orderRepository.delete(orderModel);
    }

    public OrderStatus getOrderStatus(Integer id) {
        OrderModel orderModel = orderRepository.getById(id);
        return orderModel.getOrder_Status();
    }

    public OrderModel getByTransaction(OrderModel order) {
        return orderRepository.getByTransactionId(order.getTransaction_id());
    }

    public Boolean changesPermission(OrderModel order) {
        return order.getDish_name() != null && order.getCustomer_name() != null;
    }

    public Boolean nameChange(OrderModel order, OrderModel order1) {
        return Objects.equals(order.getDish_name(), order1.getDish_name());
    }

    public Boolean customerName(OrderModel order, OrderModel order1) {
        return Objects.equals(order.getCustomer_name(), order1.getCustomer_name());
    }

    public Boolean verification(OrderModel order, OrderModel order1) {
        return nameChange(order, order1) && customerName(order, order1) && changesPermission(order);
    }

    public boolean isAvailable(OrderModel orderModel) {
        int amountDish = orderRepository.getByAmount(orderModel.getDish_name());
        if (amountDish >= orderModel.getQuantity()) {
            int meal = amountDish - orderModel.getQuantity();
            orderRepository.updateMealValue(meal, orderModel.getDish_name());
            return true;
        }
        return false;
    }

    public void canceledOrder (OrderModel orderModel) {
       int meal = orderRepository.getByAmount(orderModel.getDish_name()) + orderModel.getQuantity();
       orderRepository.updateMealValue(meal, orderModel.getDish_name());
    }
}