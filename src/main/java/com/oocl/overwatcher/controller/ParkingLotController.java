package com.oocl.overwatcher.controller;

import com.oocl.overwatcher.entities.ParkingLot;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.oocl.overwatcher.service.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author LIULE9
 */
@RestController
@RequestMapping("/parkingLots")
public class ParkingLotController {

    @Autowired
    private ParkingLotService parkingLotService;

    @GetMapping
    @PreAuthorize("hasAuthority('admin')")
    public ResponseEntity<List<ParkingLot>> findAll() {
        return ResponseEntity.ok(parkingLotService.findAll());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin')")
    public ResponseEntity<Void> addParkingLot(@NotNull @RequestBody ParkingLot parkingLot) {
        try {
            parkingLotService.save(parkingLot);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/status")
    @PreAuthorize("hasAuthority('admin')")
    public ResponseEntity<Void> updateParkingLotStatus(@RequestBody ParkingLot parkingLot) {
        if (StringUtils.isNotBlank(parkingLot.getStatus()) && StringUtils.isNotBlank(parkingLot.getId() + "")) {
            parkingLotService.updateStatus(parkingLot);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


}
