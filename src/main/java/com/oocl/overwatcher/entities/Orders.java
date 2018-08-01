package com.oocl.overwatcher.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Orders {
    public static String TYPE__UNPARK="park";
    public static String TYPE__PARK="unpark";
    public static String STATUS_YES="yes";
    public static String STATUS_NO="no";
    public static String LEAVE="leave";
    public static String NOT_LEAVE="not leave";

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
    private String leave;

    public Orders() {
    }

    public Orders(String type, String status, String carId,String leave) {
        this.type=type;
        this.status=status;
        this.carId=carId;
        this.leave=leave;
    }

    public String getLeave() {
        return leave;
    }

    public void setLeave(String leave) {
        this.leave = leave;
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
