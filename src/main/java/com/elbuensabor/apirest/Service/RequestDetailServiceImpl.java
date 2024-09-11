package com.elbuensabor.apirest.Service;

import com.elbuensabor.apirest.Entity.RequestDetail;
import com.elbuensabor.apirest.Exception.MiException;
import com.elbuensabor.apirest.Repository.RequestDetailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestDetailServiceImpl implements RequestDetailService {

    @Autowired
    private RequestDetailRepository requestDetailRepository;

    @Override
    public List<RequestDetail> getAllOrderDetails() {
        return requestDetailRepository.findAll();
    }

    @Override
    public RequestDetail getOrderDetailById(Long id) throws MiException {
        return requestDetailRepository.findById(id)
                .orElseThrow(() -> new MiException("OrderDetail not found with id: " + id));
    }

    @Override
    @Transactional
    public RequestDetail createOrderDetail(RequestDetail requestDetail) throws MiException {
        try {
            return requestDetailRepository.save(requestDetail);
        } catch (Exception e) {
            throw new MiException("Error creating OrderDetail!", e);
        }
    }

    @Override
    @Transactional
    public RequestDetail updateOrderDetail(Long id, RequestDetail requestDetail) throws MiException {
        RequestDetail existingRequestDetail = requestDetailRepository.findById(id)
                .orElseThrow(() -> new MiException("OrderDetail not found with id: " + id));

        existingRequestDetail.setQuantity(requestDetail.getQuantity());
        existingRequestDetail.setSubtotal(requestDetail.getSubtotal());
        existingRequestDetail.setRequest(requestDetail.getRequest());
        existingRequestDetail.setProduct(requestDetail.getProduct());

        try {
            return requestDetailRepository.save(existingRequestDetail);
        } catch (Exception e) {
            throw new MiException("Error updating OrderDetail!", e);
        }
    }

    @Override
    @Transactional
    public void deleteOrderDetail(Long id) throws MiException {
        RequestDetail existingRequestDetail = requestDetailRepository.findById(id)
                .orElseThrow(() -> new MiException("OrderDetail not found with id: " + id));

        try {
            requestDetailRepository.delete(existingRequestDetail);
        } catch (Exception e) {
            throw new MiException("Error deleting OrderDetail!", e);
        }
    }
}
