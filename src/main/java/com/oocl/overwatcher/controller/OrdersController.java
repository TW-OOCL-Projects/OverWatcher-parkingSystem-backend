package com.oocl.overwatcher.controller;

import com.oocl.overwatcher.dto.OrdersDto;
import com.oocl.overwatcher.entities.Orders;
import com.oocl.overwatcher.entities.ParkingLot;
import com.oocl.overwatcher.entities.User;
import com.oocl.overwatcher.repositories.ParkingLotRepository;
import com.oocl.overwatcher.repositories.UserRepository;
import com.oocl.overwatcher.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    private final OrdersService ordersService;
//    private final UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
//        this.userService=userService;
    }

    //查询所有订单
    @GetMapping

    public HttpEntity<List<Orders>> getOrders() {
        return new ResponseEntity<>(ordersService.getOrders(), HttpStatus.OK);
    }

    //查询所有抢单后的订单
    @GetMapping("/after/{boyId}")

    public HttpEntity<List<OrdersDto>> findAfterOreder(@PathVariable int boyId) {
        return new ResponseEntity<>(ordersService.findAfterOreder(boyId).stream().map(x->new OrdersDto(x)).collect(Collectors.toList()), HttpStatus.OK);
    }

    //根据ID查询订单
    @GetMapping("/{id}")

    public ResponseEntity<ArrayList<Orders>> findById(@PathVariable Integer id) {
        try {
            Orders orders = ordersService.findById(id).get();
            return ResponseEntity.ok(new ArrayList<Orders>() {{
                add(orders);
            }});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //根据车牌carid查询还在停车场的订单
    @GetMapping("/carId")

    public Orders findByCarId(String carId) {
        return ordersService.findByCarId(carId);
    }

    //根据车牌carid查询该车牌的所有订单
    @GetMapping("/carIds")

    public List<Orders> findByCarIds(String carId) {
        return ordersService.findByCarIds(carId);
    }

    //根据状态STATUS查询订单
    @GetMapping("/status")

    public List<Orders> findByStatus(String status) {
        return ordersService.findByStatus(status);
    }

    //根据类型type查询订单
    @GetMapping("/type")

    public List<Orders> findByType(String type) {
        return ordersService.findByType(type);
    }

    //根据条件查询
    @GetMapping("condition")

    public List<Orders> findByCondition(String condition, String value) {
        return ordersService.findByCondition(condition, value);
    }


    //创建停车订单
    @PostMapping

    public List<Orders> addParkOrders(@RequestBody Orders orders) {
        if (ordersService.existCarid(orders.getCarId())) {
            return null;
        } else {
            return ordersService.addOrders(orders);
        }
    }

    //停车：指定停车员给订单
    @PutMapping("/{OrderId}/parkingBoy/{BoyId}")

    public OrdersDto setUsersToOrders(@PathVariable int OrderId, @PathVariable Long BoyId) {
        User boy = userRepository.findById(BoyId).get();
        List<ParkingLot> parkingLots = boy.getParkingLotList();
        Orders orders=ordersService.findById(OrderId).get();
        orders.setUser(boy);
        if (parkingLots.stream().filter(x -> x.getSize() != 0).collect(Collectors.toList()).size() != 0) {
            ordersService.updateUserIdById(OrderId, BoyId);
            ordersService.updateStatusById(OrderId, Orders.STATUS_YES);
        }
        return new OrdersDto(orders);
    }

    //停车：指定停车场给订单
    @PutMapping("/{OrderId}/parkingLot/{ParkingLotId}")

    public OrdersDto setParkingLotToOrders(@PathVariable int OrderId, @PathVariable Long ParkingLotId) {
        ordersService.updateParkingLotIdById(OrderId, ParkingLotId);
        int size = parkingLotRepository.findById(ParkingLotId).get().getSize() - 1;
        parkingLotRepository.updateSizeById(ParkingLotId, size);
        ordersService.updateStatusById(OrderId, Orders.STATUS_PARK_DONE);
        return new OrdersDto(ordersService.findById(OrderId).get());
    }

    //用户取车，订单变为取车

    @PostMapping("/userUnParkCarId")
    public OrdersDto addUnParkOrders(String userUnParkCarId) {
        if (ordersService.existCarid(userUnParkCarId)) {
            Orders orders = ordersService.findByCarId(userUnParkCarId);
            orders.setType(Orders.TYPE__UNPARK);
            //if(ordersService.findByCarId(carId)生病)另一种status
            orders.setStatus(Orders.STATUS_YES);
            ordersService.addOrders(orders);
        }
        Orders orders = ordersService.findByCarId(userUnParkCarId);
        return new OrdersDto(orders);
    }

    //停车员取车
    @PutMapping("/boyUnParkCarId")

    public OrdersDto unPark(String boyUnParkCarId) {
        Orders orders = ordersService.findByCarId(boyUnParkCarId);
        ParkingLot parkingLot = parkingLotRepository.findById(ordersService.getParkingLotId(orders.getId())).get();
        Long parkingLotId = parkingLot.getId();
        int size = parkingLotRepository.findById(parkingLotId).get().getSize() + 1;
        parkingLotRepository.updateSizeById(parkingLotId, size);
        ordersService.updateStatusById(orders.getId(), Orders.STATUS_UNPARK_DONE);
        orders.setStatus(Orders.STATUS_UNPARK_DONE);
        orders.setParkingLot(parkingLot);
        return new OrdersDto(orders);
    }

    //根据订单ID查看停车场ID
//    @GetMapping("/id")
//
//    public Long findParkingLotIdByOrderId(int id) {
//        return ordersService.getParkingLotId(id);
//    }

    //根据停车员ID查看历史订单
    @GetMapping("/parkingBoy/{userId}")

    public List<Orders> getHistoryByUserId(@PathVariable Long userId) {
        return ordersService.getHistoryByUserId(userId);
    }

}
