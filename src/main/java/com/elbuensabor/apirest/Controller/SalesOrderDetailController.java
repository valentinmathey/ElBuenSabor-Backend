package com.elbuensabor.apirest.Controller;

import com.elbuensabor.apirest.Entity.SalesOrderDetail;
import com.elbuensabor.apirest.Service.SalesOrderDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/salesorderdetails")
public class SalesOrderDetailController {

    @Autowired
    private SalesOrderDetailServiceImpl orderDetailServiceImpl;

    @GetMapping
    public List<SalesOrderDetail> getAllOrderDetails() {
        return orderDetailServiceImpl.getAllSalesOrderDetails();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalesOrderDetail> getOrderDetailById(@PathVariable Long id) {
        SalesOrderDetail salesOrderDetail = orderDetailServiceImpl.getSalesOrderDetailById(id);
        return ResponseEntity.ok(salesOrderDetail);
    }

    @PostMapping
    public ResponseEntity<SalesOrderDetail> createOrderDetail(@RequestBody SalesOrderDetail salesOrderDetail) {
        SalesOrderDetail newSalesOrderDetail = orderDetailServiceImpl.createSalesOrderDetail(salesOrderDetail);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSalesOrderDetail);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalesOrderDetail> updateOrderDetail(@PathVariable Long id, @RequestBody SalesOrderDetail salesOrderDetail) {
        SalesOrderDetail updatedSalesOrderDetail = orderDetailServiceImpl.updateSalesOrderDetail(id, salesOrderDetail);
        return ResponseEntity.ok(updatedSalesOrderDetail);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderDetail(@PathVariable Long id) {
        orderDetailServiceImpl.deleteSalesOrderDetail(id);
        return ResponseEntity.noContent().build();
    }
}

