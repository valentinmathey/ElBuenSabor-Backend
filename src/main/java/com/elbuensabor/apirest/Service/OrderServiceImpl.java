package com.elbuensabor.apirest.Service;

import com.elbuensabor.apirest.Entity.Order;
import com.elbuensabor.apirest.Exception.MiException;
import com.elbuensabor.apirest.Repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) throws MiException {
        return orderRepository.findById(id)
                .orElseThrow(() -> new MiException("Order not found with id: " + id));
    }

    @Override
    @Transactional
    public Order createOrder(Order order) throws MiException {
        try {
            return orderRepository.save(order);
        } catch (Exception e) {
            throw new MiException("Error creating order!");
        }
    }

    @Override
    @Transactional
    public Order updateOrder(Long id, Order order) throws MiException {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new MiException("Order not found with id: " + id));

        existingOrder.setDate(order.getDate());
        existingOrder.setStatus(order.getStatus());
        existingOrder.setEstimatedDeliveryTime(order.getEstimatedDeliveryTime());
        existingOrder.setDeliveryType(order.getDeliveryType());
        existingOrder.setTotal(order.getTotal());
        existingOrder.setUser(order.getUser());
        existingOrder.setAddress(order.getAddress());
        existingOrder.setClient(order.getClient());
        existingOrder.setInvoice(order.getInvoice());
        existingOrder.setOrderDetails(order.getOrderDetails());

        try {
            return orderRepository.save(existingOrder);
        } catch (Exception e) {
            throw new MiException("Error updating order!");
        }
    }

    @Override
    @Transactional
    public void deleteOrder(Long id) throws MiException {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new MiException("Order not found with id: " + id));

        try {
            orderRepository.delete(existingOrder);
        } catch (Exception e) {
            throw new MiException("Error deleting order!");
        }
    }
}
