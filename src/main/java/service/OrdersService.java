package service;

import com.oocl.overwatcher.entities.Orders;
import com.oocl.overwatcher.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrdersService {

    private OrdersRepository ordersRepository;

    public OrdersService() {
    }

    @Autowired
    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public List<Orders> getOrders(){
        return ordersRepository.findAll();
    }

    public List<Orders> addOrders(Orders orders) {
        ordersRepository.save(orders);
        return ordersRepository.findAll();
    }
}
