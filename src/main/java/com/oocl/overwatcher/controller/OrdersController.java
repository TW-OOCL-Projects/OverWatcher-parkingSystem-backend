package com.oocl.overwatcher.controller;

import com.oocl.overwatcher.entities.Orders;
import com.oocl.overwatcher.repositories.UserRepository;
import com.oocl.overwatcher.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final OrdersService ordersService;
//    private final UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
//        this.userService=userService;
    }

    @GetMapping
    public HttpEntity<List<Orders>> getOrders() {
        return new ResponseEntity<>(ordersService.getOrders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Orders> findById(@PathVariable int id){
        return ordersService.findById(id);
    }

    @PostMapping
    public List<Orders> addOrders(@RequestBody Orders orders){
        return ordersService.addOrders(orders);
    }

    @PutMapping("/{OrderId}/{BoyId}")
    public Orders setOrdersToUsers(@PathVariable int OrderId,@PathVariable Long BoyId){
        Orders orders=ordersService.findById(OrderId).get();
        orders.setUser(userRepository.findById(BoyId).get());
        return  orders;
    }
}
