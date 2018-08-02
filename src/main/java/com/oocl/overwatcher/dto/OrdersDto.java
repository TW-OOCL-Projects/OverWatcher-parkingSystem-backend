package com.oocl.overwatcher.dto;

import com.oocl.overwatcher.entities.Orders;

import java.time.ZonedDateTime;

public class OrdersDto {
    int id;
    private String type;
    private String status;
    private String carId;
    private String leave;
    private Long parkingLotId;
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

    public String getLeave() {
        return leave;
    }

    public void setLeave(String leave) {
        this.leave = leave;
    }

    public Long getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Long parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }

    public OrdersDto(Orders orders) {
        this.id = orders.getId();
        this.type = orders.getType();
        this.status = orders.getStatus();
        this.carId=orders.getCarId();
        this.parkingLotId=orders.getParkingLot().getId();
        this.usersId=orders.getUser().getId();
        this.time=orders.getCreatedDate();
    }
}
