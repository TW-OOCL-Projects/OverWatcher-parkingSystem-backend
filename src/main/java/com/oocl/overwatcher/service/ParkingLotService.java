package com.oocl.overwatcher.service;

import com.oocl.overwatcher.entities.ParkingLot;
import com.oocl.overwatcher.repositories.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public Optional<ParkingLot> findOne(Long id) {
        return parkingLotRepository.findById(id);
    }

    public List<ParkingLot> finAllParkingLotNoOwner(){
        return parkingLotRepository.findAll().stream().filter(parkingLot -> parkingLot.getUser()==null).collect(Collectors.toList());
    }
}
