package com.oocl.overwatcher.controller;

import com.oocl.overwatcher.entities.Orders;
import com.oocl.overwatcher.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping
    public HttpEntity<List<Orders>> getOrders() {
        return new ResponseEntity<>(ordersService.getOrders(), HttpStatus.OK);
    }

    @PostMapping
    public List<Orders> addOrders(@RequestBody Orders orders){
        return ordersService.addOrders(orders);
    }
}
