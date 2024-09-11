package com.elbuensabor.apirest.Service;

import com.elbuensabor.apirest.Entity.Request;
import com.elbuensabor.apirest.Exception.MiException;

import java.util.List;

public interface RequestService {
    List<Request> getAllOrders();
    Request getOrderById(Long id) throws MiException;
    Request createOrder(Request request) throws MiException;
    Request updateOrder(Long id, Request request) throws MiException;
    void deleteOrder(Long id) throws MiException;
}
