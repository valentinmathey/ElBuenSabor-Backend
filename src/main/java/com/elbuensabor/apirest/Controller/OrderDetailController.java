package com.elbuensabor.apirest.Controller;

import com.elbuensabor.apirest.Entity.OrderDetail;
import com.elbuensabor.apirest.Service.OrderDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/orderdetails")
public class OrderDetailController {

    @Autowired
    private OrderDetailServiceImpl orderDetailServiceImpl;

    @GetMapping
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailServiceImpl.getAllOrderDetails();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetail> getOrderDetailById(@PathVariable Long id) {
        OrderDetail orderDetail = orderDetailServiceImpl.getOrderDetailById(id);
        return ResponseEntity.ok(orderDetail);
    }

    @PostMapping
    public ResponseEntity<OrderDetail> createOrderDetail(@RequestBody OrderDetail orderDetail) {
        OrderDetail newOrderDetail = orderDetailServiceImpl.createOrderDetail(orderDetail);
        return ResponseEntity.status(HttpStatus.CREATED).body(newOrderDetail);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDetail> updateOrderDetail(@PathVariable Long id, @RequestBody OrderDetail orderDetail) {
        OrderDetail updatedOrderDetail = orderDetailServiceImpl.updateOrderDetail(id, orderDetail);
        return ResponseEntity.ok(updatedOrderDetail);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderDetail(@PathVariable Long id) {
        orderDetailServiceImpl.deleteOrderDetail(id);
        return ResponseEntity.noContent().build();
    }
}

