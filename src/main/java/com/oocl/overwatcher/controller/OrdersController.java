package com.oocl.overwatcher.controller;

import com.oocl.overwatcher.entities.Orders;
import com.oocl.overwatcher.entities.ParkingLot;
import com.oocl.overwatcher.repositories.ParkingLotRepository;
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
    //根据ID查询订单
    @GetMapping("/{id}")
    public Optional<Orders> findById(@PathVariable int id){
        return ordersService.findById(id);
    }

    //根据状车牌态查询订单
    @GetMapping("/carId/{carId}")
    public Orders findByCarId(@PathVariable String carId){
        return ordersService.findByCarId(carId);
    }

    //根据状STATUS态查询订单
    @GetMapping("/status")
    public List<Orders> findByStatus(String status){
        return ordersService.findByStatus(status);
    }


    //创建停车订单
    @PostMapping
    public List<Orders> addParkOrders(@RequestBody Orders orders){
        if(ordersService.existCarid(orders.getCarId())){
            return null;
        }else {
            return ordersService.addOrders(orders);
        }
    }

    //停车：指定停车员给订单
    @PutMapping("/{OrderId}/parkingBoy/{BoyId}")
    public Orders setUsersToOrders(@PathVariable int OrderId,@PathVariable Long BoyId){
        ordersService.updateUserIdById(OrderId,BoyId);
        ordersService.updateStatusById(OrderId,Orders.STATUS_YES);
        return ordersService.findById(OrderId).get();
    }

    //停车：指定停车场给订单
    @PutMapping("/{OrderId}/parkingLot/{ParkingLotId}")
    public Orders setParkingLotToOrders(@PathVariable int OrderId,@PathVariable Long ParkingLotId){
        ordersService.updateParkingLotIdById(OrderId,ParkingLotId);
        int size=parkingLotRepository.findById(ParkingLotId).get().getSize()-1;
        parkingLotRepository.updateSizeById(ParkingLotId,size);
        ordersService.updateStatusById(OrderId,Orders.STATUS_PARK_DONE);
        return ordersService.findById(OrderId).get();
    }

    //用户取车，订单变为取车
    @PostMapping("/unpark/{carId}")
    public List<Orders> addUnParkOrders(@PathVariable String carId){
        if(ordersService.existCarid(carId)){
            Orders orders=ordersService.findByCarId(carId);
            orders.setType(Orders.TYPE__UNPARK);
            //if(ordersService.findByCarId(carId)生病)另一种status
            orders.setStatus(Orders.STATUS_YES);
            ordersService.addOrders(orders);
        }
        return ordersService.getOrders();
    }
    //停车员取车
    @PutMapping("/{carId}")
    public List<Orders> unPark(@PathVariable String carId){
        Orders orders=ordersService.findByCarId(carId);
        ParkingLot parkingLot=parkingLotRepository.findById(ordersService.getParkingLotId(orders.getId())).get();
        Long parkingLotId=parkingLot.getId();
        int size=parkingLotRepository.findById(parkingLotId).get().getSize()+1;
        parkingLotRepository.updateSizeById(parkingLotId,size);
        ordersService.updateStatusById(orders.getId(),Orders.STATUS_UNPARK_DONE);
        return ordersService.getOrders();
    }

}
