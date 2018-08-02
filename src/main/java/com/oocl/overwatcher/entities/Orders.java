package com.oocl.overwatcher.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
public class Orders {
    public static String TYPE__UNPARK="取车";
    public static String TYPE__PARK="存车";
    public static String STATUS_YES="存取中";
    public static String STATUS_NO="无人处理";
    public static String STATUS_PARK_DONE="存车完成";
    public static String STATUS_UNPARK_DONE="取车完成";



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    private String type;
    private String status;
    private String carId;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="parkinglot_id")
    private ParkingLot parkingLot;

    @CreatedDate
    private ZonedDateTime createdDate = ZonedDateTime.now();

    public static String getType_unpark() {
        return TYPE__UNPARK;
    }

    public static void setType_unpark(String type_unpark) {
        TYPE__UNPARK = type_unpark;
    }

    public static String getType_park() {
        return TYPE__PARK;
    }

    public static void setType_park(String type_park) {
        TYPE__PARK = type_park;
    }

    public static String getStatusYes() {
        return STATUS_YES;
    }

    public static void setStatusYes(String statusYes) {
        STATUS_YES = statusYes;
    }

    public static String getStatusNo() {
        return STATUS_NO;
    }

    public static void setStatusNo(String statusNo) {
        STATUS_NO = statusNo;
    }

    public Orders() {
    }

    public Orders(String type, String status, String carId) {
        this.type=type;
        this.status=status;
        this.carId=carId;

    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
