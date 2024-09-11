package com.elbuensabor.apirest.Service;

import com.elbuensabor.apirest.Entity.RequestDetail;
import com.elbuensabor.apirest.Exception.MiException;

import java.util.List;

public interface RequestDetailService {
    List<RequestDetail> getAllOrderDetails();
    RequestDetail getOrderDetailById(Long id) throws MiException;
    RequestDetail createOrderDetail(RequestDetail requestDetail) throws MiException;
    RequestDetail updateOrderDetail(Long id, RequestDetail requestDetail) throws MiException;
    void deleteOrderDetail(Long id) throws MiException;
}
