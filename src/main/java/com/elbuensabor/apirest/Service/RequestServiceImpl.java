package com.elbuensabor.apirest.Service;

import com.elbuensabor.apirest.Entity.Request;
import com.elbuensabor.apirest.Exception.MiException;
import com.elbuensabor.apirest.Repository.RequestRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Override
    public List<Request> getAllOrders() {
        return requestRepository.findAll();
    }

    @Override
    public Request getOrderById(Long id) throws MiException {
        return requestRepository.findById(id)
                .orElseThrow(() -> new MiException("Order not found with id: " + id));
    }

    @Override
    @Transactional
    public Request createOrder(Request request) throws MiException {
        try {
            return requestRepository.save(request);
        } catch (Exception e) {
            throw new MiException("Error creating order!");
        }
    }

    @Override
    @Transactional
    public Request updateOrder(Long id, Request request) throws MiException {
        Request existingRequest = requestRepository.findById(id)
                .orElseThrow(() -> new MiException("Order not found with id: " + id));

        existingRequest.setDate(request.getDate());
        existingRequest.setStatus(request.getStatus());
        existingRequest.setEstimatedDeliveryTime(request.getEstimatedDeliveryTime());
        existingRequest.setDeliveryType(request.getDeliveryType());
        existingRequest.setTotal(request.getTotal());
        existingRequest.setUser(request.getUser());
        existingRequest.setAddress(request.getAddress());
        existingRequest.setClient(request.getClient());
        existingRequest.setInvoice(request.getInvoice());
        existingRequest.setRequestDetails(request.getRequestDetails());

        try {
            return requestRepository.save(existingRequest);
        } catch (Exception e) {
            throw new MiException("Error updating order!");
        }
    }

    @Override
    @Transactional
    public void deleteOrder(Long id) throws MiException {
        Request existingRequest = requestRepository.findById(id)
                .orElseThrow(() -> new MiException("Order not found with id: " + id));

        try {
            requestRepository.delete(existingRequest);
        } catch (Exception e) {
            throw new MiException("Error deleting order!");
        }
    }
}
