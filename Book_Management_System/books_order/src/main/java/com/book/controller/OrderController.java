package com.book.controller;

import com.book.entry.SaleOrder;
import com.book.mapper.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @PostMapping("/order/insertOrder")
    public ResponseEntity insert(@RequestBody SaleOrder saleOrder){
        saleOrder= orderRepository.save(saleOrder);
        return ResponseEntity.ok(saleOrder);
    }

    @GetMapping("/orders")
    List<SaleOrder> getauthorityEntity() {
        return orderRepository.findAll();
    }


}
