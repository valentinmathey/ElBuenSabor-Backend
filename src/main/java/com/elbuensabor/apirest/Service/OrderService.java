package com.elbuensabor.apirest.Service;

import com.elbuensabor.apirest.Entity.Order;
import com.elbuensabor.apirest.Exception.MiException;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long id) throws MiException;
    Order createOrder(Order order) throws MiException;
    Order updateOrder(Long id, Order order) throws MiException;
    void deleteOrder(Long id) throws MiException;
}
