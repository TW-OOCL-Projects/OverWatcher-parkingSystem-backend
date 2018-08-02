package com.oocl.overwatcher.controller;

import com.oocl.overwatcher.dto.ParkingLotDetail;
import com.oocl.overwatcher.entities.ParkingLot;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.oocl.overwatcher.service.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author LIULE9
 */
@RestController
    @RequestMapping("/parkingLots")
public class ParkingLotController {

    @Autowired
    private ParkingLotService parkingLotService;

    @GetMapping
//    @PreAuthorize("hasAnyAuthority('admin')")
    public ResponseEntity<List<ParkingLot>> findAll() {
        return ResponseEntity.ok(parkingLotService.findAll());
    }


    @PostMapping
//    @PreAuthorize("hasAnyAuthority('admin')")
    public ResponseEntity<Void> addParkingLot(@NotNull @RequestBody ParkingLot parkingLot) {
        try {
            parkingLotService.save(parkingLot);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 注销
     *
     * @param parkingLot
     * @return
     */
    @PutMapping("/status")
    @PreAuthorize("hasAnyAuthority('admin')")
    public ResponseEntity<Void> updateParkingLotStatus(@RequestBody ParkingLot parkingLot) {
        if (StringUtils.isNotBlank(parkingLot.getStatus()) && parkingLot.getId() != null) {
            parkingLotService.updateStatus(parkingLot);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    /**
     * 修改
     *
     * @param parkingLot
     * @return
     */
    @PutMapping
    @PreAuthorize("hasAnyAuthority('admin')")
    public ResponseEntity<Void> updateParkingLot(@NotNull @RequestBody ParkingLot parkingLot) {
        if (parkingLot.getId() != null) {
            parkingLotService.save(parkingLot);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/statistical")
    @PreAuthorize("hasAnyAuthority('admin')")
    public ResponseEntity<List<ParkingLotDetail>> statisticalAllParkingLotDetail() {
        List<ParkingLot> parkingLots = parkingLotService.findAll();
        List<ParkingLotDetail> collect = parkingLots.stream().map(parkingLot -> new ParkingLotDetail(parkingLot.getName(), parkingLot.getUser().getName() == null ? "暂无" : parkingLot.getUser().getName(), parkingLot.getSize(), parkingLot.getInitSize())).collect(Collectors.toList());
        return ResponseEntity.ok(collect);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('admin')")
    public ResponseEntity<ParkingLot> findOne(@PathVariable("id") Long id) {
        try {
            ParkingLot parkingLot = parkingLotService.findOne(id).orElseThrow(() -> new Exception("没有该停车场"));
            return ResponseEntity.ok(parkingLot);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }


}
