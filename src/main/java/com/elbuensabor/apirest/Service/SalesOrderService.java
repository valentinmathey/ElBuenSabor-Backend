package com.elbuensabor.apirest.Service;

import com.elbuensabor.apirest.Entity.SalesOrder;
import com.elbuensabor.apirest.Exception.MiException;

import java.util.List;

public interface SalesOrderService {
    List<SalesOrder> getAllSalesOrders();
    SalesOrder getSalesOrderById(Long id) throws MiException;
    SalesOrder createSalesOrder(SalesOrder salesOrder) throws MiException;
    SalesOrder updateSalesOrder(Long id, SalesOrder salesOrder) throws MiException;
    void deleteSalesOrder(Long id) throws MiException;
}
