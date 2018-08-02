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

    public Orders findByCarId(String carId) {
        return ordersRepository.findBycarId(carId);
    }

    public void updateUserIdById(int orderId, Long boyId) {
        ordersRepository.updateUserIdById(orderId,boyId);
    }

    public void updateStatusById(int orderId,String status) {
        ordersRepository.updateStatusById(orderId,status);
    }

    public void updateParkingLotIdById(int orderId, Long parkinglotId) {
        ordersRepository.updateParkingLotIdById(orderId,parkinglotId);
    }

    public boolean existCarid(String carId) {
        int id=ordersRepository.findBycarId(carId).getId();
        return ordersRepository.existsById(id);
    }

    public List<Orders> findAll() {
        return ordersRepository.findAll();
    }

    public Long getParkingLotId(int id) {
        return Long.valueOf(ordersRepository.findparkinglotIdById(id));
    }
}
