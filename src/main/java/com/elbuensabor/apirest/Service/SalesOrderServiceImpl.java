package com.elbuensabor.apirest.Service;

import com.elbuensabor.apirest.Entity.SalesOrder;
import com.elbuensabor.apirest.Exception.MiException;
import com.elbuensabor.apirest.Repository.SalesOrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesOrderServiceImpl implements SalesOrderService {

    @Autowired
    private SalesOrderRepository salesOrderRepository;

    @Override
    public List<SalesOrder> getAllSalesOrders() {
        return salesOrderRepository.findAll();
    }

    @Override
    public SalesOrder getSalesOrderById(Long id) throws MiException {
        return salesOrderRepository.findById(id)
                .orElseThrow(() -> new MiException("SalesOrder not found with id: " + id));
    }

    @Override
    @Transactional
    public SalesOrder createSalesOrder(SalesOrder salesOrder) throws MiException {
        try {
            return salesOrderRepository.save(salesOrder);
        } catch (Exception e) {
            throw new MiException("Error creating SalesOrder!");
        }
    }

    @Override
    @Transactional
    public SalesOrder updateSalesOrder(Long id, SalesOrder salesOrder) throws MiException {
        SalesOrder existingSalesOrder = salesOrderRepository.findById(id)
                .orElseThrow(() -> new MiException("SalesOrder not found with id: " + id));

        existingSalesOrder.setDate(salesOrder.getDate());
        existingSalesOrder.setStatus(salesOrder.getStatus());
        existingSalesOrder.setEstimatedDeliveryTime(salesOrder.getEstimatedDeliveryTime());
        existingSalesOrder.setDeliveryType(salesOrder.getDeliveryType());
        existingSalesOrder.setTotal(salesOrder.getTotal());
        existingSalesOrder.setUser(salesOrder.getUser());
        existingSalesOrder.setAddress(salesOrder.getAddress());
        existingSalesOrder.setClient(salesOrder.getClient());
        existingSalesOrder.setInvoice(salesOrder.getInvoice());
        existingSalesOrder.setSalesOrderDetails(salesOrder.getSalesOrderDetails());

        try {
            return salesOrderRepository.save(existingSalesOrder);
        } catch (Exception e) {
            throw new MiException("Error updating SalesOrder!");
        }
    }

    @Override
    @Transactional
    public void deleteSalesOrder(Long id) throws MiException {
        SalesOrder existingSalesOrder = salesOrderRepository.findById(id)
                .orElseThrow(() -> new MiException("SalesOrder not found with id: " + id));

        try {
            salesOrderRepository.delete(existingSalesOrder);
        } catch (Exception e) {
            throw new MiException("Error deleting SalesOrder!");
        }
    }
}
