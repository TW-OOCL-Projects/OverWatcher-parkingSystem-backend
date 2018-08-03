package com.oocl.overwatcher.controller;

import com.oocl.overwatcher.dto.EmployeeDto;
import com.oocl.overwatcher.entities.ParkingLot;
import com.oocl.overwatcher.entities.User;
import com.oocl.overwatcher.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> findAllUser() {
        List<EmployeeDto> employeeDtos = userService.findAllUser().stream().map(EmployeeDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(employeeDtos);
    }

    @PostMapping
    public ResponseEntity addUser(@RequestBody User user) {
        user.getRoleList().forEach(role -> {
            role.getUsers().add(user);
        });
        if (userService.addUser(user)) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/{parkingBoyId}/parkingLotId/{parkingLotId}")
    public ResponseEntity addParkingLotToParkingBoy(@PathVariable Long parkingBoyId,@PathVariable Long parkingLotId){
        if (userService.addParkingLotToParkingBoy(parkingBoyId,parkingLotId)){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("{id}/parkingLots")
    public ResponseEntity<List<ParkingLot>> finAllParkingLotByEmployeeId(@PathVariable Long id){
        return ResponseEntity.ok(userService.finAllParkingLotByEmployeeId(id));
    }

    @PutMapping("/status")
    public ResponseEntity<Void> updateUserStatus(@RequestBody User user) {
        if (StringUtils.isNotBlank(user.getStatus()) && StringUtils.isNotBlank(user.getId() + "")) {
            if (userService.updateStatus(user)) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @GetMapping("/onWork")
    public List<User> findAllEmployeesOnWork(){
        return userService.findAllEmployeesOnWork();
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('admin')")
    public ResponseEntity<EmployeeDto> findOne(@PathVariable("id") Long id) {
        try {
            User user = userService.findOne(id).orElseThrow(() -> new Exception("找不到该用户"));
            return ResponseEntity.ok(new EmployeeDto(user));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/name")
//    @PreAuthorize("hasAnyAuthority('admin')")
    public ResponseEntity<List<EmployeeDto>> findUsersByName(String name) {
        try {
            if (StringUtils.isNotBlank(name)) {
                List<User> users = userService.findByName(name);
                List<EmployeeDto> collect = users.stream().map(EmployeeDto::new).collect(Collectors.toList());
                return ResponseEntity.ok(collect);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


    @GetMapping("/email")
    //    @PreAuthorize("hasAnyAuthority('admin')")
    public ResponseEntity<List<EmployeeDto>> findUsersByEmail(String email) {
        try {
            if (StringUtils.isNotBlank(email)) {
                List<User> users = userService.findByEmail(email);
                List<EmployeeDto> collect = users.stream().map(EmployeeDto::new).collect(Collectors.toList());
                return ResponseEntity.ok(collect);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


    @GetMapping("/phone")
    //    @PreAuthorize("hasAnyAuthority('admin')")
    public ResponseEntity<List<EmployeeDto>> findUsersByPhone(String phone) {
        try {
            if (StringUtils.isNotBlank(phone)) {
                List<User> users = userService.findByPhone(phone);
                List<EmployeeDto> collect = users.stream().map(EmployeeDto::new).collect(Collectors.toList());
                return ResponseEntity.ok(collect);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/role")
    //    @PreAuthorize("hasAnyAuthority('admin')")
    public ResponseEntity<List<EmployeeDto>> findUsersByRole(String role) {
        try {
            if (StringUtils.isNotBlank(role)) {
                List<User> users = userService.findAllUser();
                List<EmployeeDto> collect = users.stream()
                        .filter(user -> user.getRoleList() != null && user.getRoleList().size() > 0 && role.equals(user.getRoleList().get(0).getName()))
                        .map(EmployeeDto::new).collect(Collectors.toList());
                return ResponseEntity.ok(collect);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping
    public ResponseEntity updateBasicMessageOfEmployees(@RequestBody User user) {
        if (StringUtils.isNotBlank(user.getId() + "")) {
            if (userService.updateBasicMessageOfEmployees(user)) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
