package com.elbuensabor.apirest.Service;

import com.elbuensabor.apirest.Entity.SalesOrderDetail;
import com.elbuensabor.apirest.Exception.MiException;

import java.util.List;

public interface SalesOrderDetailService {
    List<SalesOrderDetail> getAllSalesOrderDetails();
    SalesOrderDetail getSalesOrderDetailById(Long id) throws MiException;
    SalesOrderDetail createSalesOrderDetail(SalesOrderDetail salesOrderDetail) throws MiException;
    SalesOrderDetail updateSalesOrderDetail(Long id, SalesOrderDetail salesOrderDetail) throws MiException;
    void deleteSalesOrderDetail(Long id) throws MiException;
}
