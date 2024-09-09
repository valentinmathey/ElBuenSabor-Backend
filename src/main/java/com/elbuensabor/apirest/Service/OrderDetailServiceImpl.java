package com.elbuensabor.apirest.Service;

import com.elbuensabor.apirest.Entity.OrderDetail;
import com.elbuensabor.apirest.Exception.MiException;
import com.elbuensabor.apirest.Repository.OrderDetailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

    @Override
    public OrderDetail getOrderDetailById(Long id) throws MiException {
        return orderDetailRepository.findById(id)
                .orElseThrow(() -> new MiException("OrderDetail not found with id: " + id));
    }

    @Override
    @Transactional
    public OrderDetail createOrderDetail(OrderDetail orderDetail) throws MiException {
        try {
            return orderDetailRepository.save(orderDetail);
        } catch (Exception e) {
            throw new MiException("Error creating OrderDetail!", e);
        }
    }

    @Override
    @Transactional
    public OrderDetail updateOrderDetail(Long id, OrderDetail orderDetail) throws MiException {
        OrderDetail existingOrderDetail = orderDetailRepository.findById(id)
                .orElseThrow(() -> new MiException("OrderDetail not found with id: " + id));

        existingOrderDetail.setQuantity(orderDetail.getQuantity());
        existingOrderDetail.setSubtotal(orderDetail.getSubtotal());
        existingOrderDetail.setOrder(orderDetail.getOrder());
        existingOrderDetail.setProduct(orderDetail.getProduct());

        try {
            return orderDetailRepository.save(existingOrderDetail);
        } catch (Exception e) {
            throw new MiException("Error updating OrderDetail!", e);
        }
    }

    @Override
    @Transactional
    public void deleteOrderDetail(Long id) throws MiException {
        OrderDetail existingOrderDetail = orderDetailRepository.findById(id)
                .orElseThrow(() -> new MiException("OrderDetail not found with id: " + id));

        try {
            orderDetailRepository.delete(existingOrderDetail);
        } catch (Exception e) {
            throw new MiException("Error deleting OrderDetail!", e);
        }
    }
}
