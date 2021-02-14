package com.enigma.Vcom.services;

import com.enigma.Vcom.entities.Order;
import com.enigma.Vcom.models.OrderModel;

import java.util.List;

public interface OrderService {

    void addOrder(OrderModel order);

    void updateOrder(OrderModel order);

    void deleteOrder(Order order);

    Order findOrderById(Integer id);

    List<Order> findAllOrder();
}
