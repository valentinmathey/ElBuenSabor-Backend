package com.elbuensabor.apirest.Controller;

import com.elbuensabor.apirest.Entity.SalesOrder;
import com.elbuensabor.apirest.Service.SalesOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/salesorders")
public class SalesOrderController {

    @Autowired
    private SalesOrderServiceImpl orderServiceImpl;

    @GetMapping
    public List<SalesOrder> getAllOrders() {
        return orderServiceImpl.getAllSalesOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalesOrder> getOrderById(@PathVariable Long id) {
        SalesOrder salesOrder = orderServiceImpl.getSalesOrderById(id);
        return ResponseEntity.ok(salesOrder);
    }

    @PostMapping
    public ResponseEntity<SalesOrder> createOrder(@RequestBody SalesOrder salesOrder) {
        SalesOrder newSalesOrder = orderServiceImpl.createSalesOrder(salesOrder);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSalesOrder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalesOrder> updateOrder(@PathVariable Long id, @RequestBody SalesOrder salesOrder) {
        SalesOrder updatedSalesOrder = orderServiceImpl.updateSalesOrder(id, salesOrder);
        return ResponseEntity.ok(updatedSalesOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderServiceImpl.deleteSalesOrder(id);
        return ResponseEntity.noContent().build();
    }
}

