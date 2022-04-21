package com.ait.controller;

import com.ait.entry.SaleOrder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Component
@FeignClient(value = "order-server")
public interface OrderFeign {
    @RequestMapping(value = "order/insertOrder", method = RequestMethod.POST)
    public ResponseEntity insertOrder(@RequestBody SaleOrder saleOrder);
}
