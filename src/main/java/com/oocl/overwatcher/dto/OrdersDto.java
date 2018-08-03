package com.oocl.overwatcher.dto;

import com.oocl.overwatcher.entities.Orders;

import java.time.ZonedDateTime;

public class OrdersDto {
    int id;
    private String type;
    private String status;
    private String carId;
    private String name;
    private Long usersId;
    private ZonedDateTime time;

    public ZonedDateTime getTime() {
        return time;
    }

    public void setTime(ZonedDateTime time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrdersDto(Orders orders) {
        this.id = orders.getId();
        this.type = orders.getType();
        this.status = orders.getStatus();
        this.carId=orders.getCarId();
        this.name=orders.getParkingLot().getName();
        this.time=orders.getCreatedDate();
    }
}
