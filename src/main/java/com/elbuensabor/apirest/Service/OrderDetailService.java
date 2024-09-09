package com.elbuensabor.apirest.Service;

import com.elbuensabor.apirest.Entity.OrderDetail;
import com.elbuensabor.apirest.Exception.MiException;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetail> getAllOrderDetails();
    OrderDetail getOrderDetailById(Long id) throws MiException;
    OrderDetail createOrderDetail(OrderDetail orderDetail) throws MiException;
    OrderDetail updateOrderDetail(Long id, OrderDetail orderDetail) throws MiException;
    void deleteOrderDetail(Long id) throws MiException;
}
