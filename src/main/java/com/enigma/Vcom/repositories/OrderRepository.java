package com.enigma.Vcom.repositories;

import com.enigma.Vcom.entities.Order;
import com.enigma.Vcom.models.OrderModel;

import java.util.List;

public interface OrderRepository {

    boolean save(OrderModel order);

    boolean update(OrderModel order);

    boolean delete(Order order);

    Order findById(Integer id);

    List<Order> findAll();
}
