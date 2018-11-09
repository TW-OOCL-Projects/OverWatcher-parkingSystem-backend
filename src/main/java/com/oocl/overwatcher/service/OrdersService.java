package com.oocl.overwatcher.service;

import com.oocl.overwatcher.entities.Orders;
import com.oocl.overwatcher.enums.OrderStatusEnum;
import com.oocl.overwatcher.repositories.OrdersRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    public List<Orders> getOrders() {
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
        ordersRepository.updateUserIdById(orderId, boyId);
    }

    public void updateStatusById(int orderId, String status) {
        ordersRepository.updateStatusById(orderId, status);
    }

    public void updateParkingLotIdById(int orderId, Long parkinglotId) {
        ordersRepository.updateParkingLotIdById(orderId, parkinglotId);
    }

    public boolean existCarid(String carId) {
        return ordersRepository.findBycarId(carId) != null && !ordersRepository.findBycarId(carId).getOrderStatus().equals(OrderStatusEnum.UNPARK_DONE.getMessage());
    }

    public Long getParkingLotId(int id) {
        return ordersRepository.findParkinglotIdById(id);
    }

    public List<Orders> findByStatus(String status) {
        return ordersRepository.findByStaus(status);
    }

    public List<Orders> findByType(String type) {
        return ordersRepository.findByType(type);
    }

    public List<Orders> findByCarIds(String carId) {
        return ordersRepository.findByCarIds(carId);
    }

    public List<Orders> findAfterOreder(int boyId) {
        return ordersRepository.findAfterOreder(boyId);
    }

    public List<Orders> findByCondition(String condition, String value) {
        return ordersRepository.findAll((Specification<Orders>) (root, query, criteriaBuilder) -> {
            Predicate predicate = null;
            if(StringUtils.isNotBlank(condition)&& "type".equals(condition)){
                predicate = criteriaBuilder.equal(root.get("type").as(String.class), value);
            }else if(StringUtils.isNotBlank(condition)&&"status".equals(condition)){
                predicate = criteriaBuilder.equal(root.get("status").as(String.class),value);
            }
            return predicate;
        });
    }

    public List<Orders> getHistoryByUserId(Long userId) {
        return ordersRepository.getHistoryByUserId(userId);
    }
}
