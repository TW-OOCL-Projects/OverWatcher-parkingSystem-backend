package com.oocl.overwatcher.repositories;

import com.oocl.overwatcher.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders,Integer> {
    Orders findBycarId(String carId);
}
