package com.elbuensabor.apirest.Controller;

import com.elbuensabor.apirest.Entity.RequestDetail;
import com.elbuensabor.apirest.Service.RequestDetailServiceImpl;
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
    private RequestDetailServiceImpl orderDetailServiceImpl;

    @GetMapping
    public List<RequestDetail> getAllOrderDetails() {
        return orderDetailServiceImpl.getAllOrderDetails();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestDetail> getOrderDetailById(@PathVariable Long id) {
        RequestDetail requestDetail = orderDetailServiceImpl.getOrderDetailById(id);
        return ResponseEntity.ok(requestDetail);
    }

    @PostMapping
    public ResponseEntity<RequestDetail> createOrderDetail(@RequestBody RequestDetail requestDetail) {
        RequestDetail newRequestDetail = orderDetailServiceImpl.createOrderDetail(requestDetail);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRequestDetail);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RequestDetail> updateOrderDetail(@PathVariable Long id, @RequestBody RequestDetail requestDetail) {
        RequestDetail updatedRequestDetail = orderDetailServiceImpl.updateOrderDetail(id, requestDetail);
        return ResponseEntity.ok(updatedRequestDetail);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderDetail(@PathVariable Long id) {
        orderDetailServiceImpl.deleteOrderDetail(id);
        return ResponseEntity.noContent().build();
    }
}

