package com.elbuensabor.apirest.Service;

import com.elbuensabor.apirest.Entity.SalesOrderDetail;
import com.elbuensabor.apirest.Exception.MiException;
import com.elbuensabor.apirest.Repository.SalesOrderDetailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesOrderDetailServiceImpl implements SalesOrderDetailService {

    @Autowired
    private SalesOrderDetailRepository salesOrderDetailRepository;

    @Override
    public List<SalesOrderDetail> getAllSalesOrderDetails() {
        return salesOrderDetailRepository.findAll();
    }

    @Override
    public SalesOrderDetail getSalesOrderDetailById(Long id) throws MiException {
        return salesOrderDetailRepository.findById(id)
                .orElseThrow(() -> new MiException("SalesOrderDetail not found with id: " + id));
    }

    @Override
    @Transactional
    public SalesOrderDetail createSalesOrderDetail(SalesOrderDetail salesOrderDetail) throws MiException {
        try {
            return salesOrderDetailRepository.save(salesOrderDetail);
        } catch (Exception e) {
            throw new MiException("Error creating SalesOrderDetail!", e);
        }
    }

    @Override
    @Transactional
    public SalesOrderDetail updateSalesOrderDetail(Long id, SalesOrderDetail salesOrderDetail) throws MiException {
        SalesOrderDetail existingSalesOrderDetail = salesOrderDetailRepository.findById(id)
                .orElseThrow(() -> new MiException("SalesOrderDetail not found with id: " + id));

        existingSalesOrderDetail.setQuantity(salesOrderDetail.getQuantity());
        existingSalesOrderDetail.setSubtotal(salesOrderDetail.getSubtotal());
        existingSalesOrderDetail.setSalesOrder(salesOrderDetail.getSalesOrder());
        existingSalesOrderDetail.setProduct(salesOrderDetail.getProduct());

        try {
            return salesOrderDetailRepository.save(existingSalesOrderDetail);
        } catch (Exception e) {
            throw new MiException("Error updating SalesOrderDetail!", e);
        }
    }

    @Override
    @Transactional
    public void deleteSalesOrderDetail(Long id) throws MiException {
        SalesOrderDetail existingSalesOrderDetail = salesOrderDetailRepository.findById(id)
                .orElseThrow(() -> new MiException("OrderDetail not found with id: " + id));

        try {
            salesOrderDetailRepository.delete(existingSalesOrderDetail);
        } catch (Exception e) {
            throw new MiException("Error deleting SalesOrderDetail!", e);
        }
    }
}
