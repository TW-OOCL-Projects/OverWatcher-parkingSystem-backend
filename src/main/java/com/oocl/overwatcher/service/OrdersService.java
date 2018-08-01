package com.oocl.overwatcher.service;

import com.oocl.overwatcher.entities.Orders;
import com.oocl.overwatcher.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    public List<Orders> getOrders(){
        return ordersRepository.findAll();
    }

    public List<Orders> addOrders(Orders orders) {
        ordersRepository.save(orders);
        return ordersRepository.findAll();
    }

    public Optional<Orders> findById(int id) {
        return ordersRepository.findById(id);
    }
}
