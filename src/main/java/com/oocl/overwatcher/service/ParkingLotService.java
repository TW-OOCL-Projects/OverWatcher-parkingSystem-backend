package com.oocl.overwatcher.service;

import com.oocl.overwatcher.entities.ParkingLot;
import com.oocl.overwatcher.repositories.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author LIULE9
 */
@Service
@Transactional
public class ParkingLotService {

    @Autowired
    private ParkingLotRepository parkingLotRepository;


    public List<ParkingLot> findAll() {
        return parkingLotRepository.findAll();
    }


    public void save(ParkingLot parkingLot) {
        parkingLotRepository.save(parkingLot);
    }


    public void updateStatus(ParkingLot parkingLot) {
        parkingLotRepository.updateStatusById(parkingLot.getId(),parkingLot.getStatus());
    }
}
