package com.elbuensabor.apirest.Controller;

import com.elbuensabor.apirest.Entity.Request;
import com.elbuensabor.apirest.Service.RequestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private RequestServiceImpl orderServiceImpl;

    @GetMapping
    public List<Request> getAllOrders() {
        return orderServiceImpl.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Request> getOrderById(@PathVariable Long id) {
        Request request = orderServiceImpl.getOrderById(id);
        return ResponseEntity.ok(request);
    }

    @PostMapping
    public ResponseEntity<Request> createOrder(@RequestBody Request request) {
        Request newRequest = orderServiceImpl.createOrder(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Request> updateOrder(@PathVariable Long id, @RequestBody Request request) {
        Request updatedRequest = orderServiceImpl.updateOrder(id, request);
        return ResponseEntity.ok(updatedRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderServiceImpl.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}

