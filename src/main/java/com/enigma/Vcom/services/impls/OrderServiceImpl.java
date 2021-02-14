package com.enigma.Vcom.services.impls;

import com.enigma.Vcom.entities.Order;
import com.enigma.Vcom.models.OrderModel;
import com.enigma.Vcom.repositories.OrderRepository;
import com.enigma.Vcom.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void addOrder(OrderModel order) {
        orderRepository.save(order);
    }

    @Override
    public void updateOrder(OrderModel order) {
        orderRepository.update(order);
    }

    @Override
    public void deleteOrder(Order order) {
        orderRepository.delete(order);
    }

    @Override
    public Order findOrderById(Integer id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> findAllOrder() {
        return orderRepository.findAll();
    }
}
