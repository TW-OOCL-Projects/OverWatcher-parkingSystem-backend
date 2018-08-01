package com.oocl.overwatcher.repositories;

import com.oocl.overwatcher.entities.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long> {

    @Query(value = "update Parking_Lot set `status` = ?2 where id = ?1", nativeQuery = true)
    @Modifying
    void updateStatusById( Long id, String status);
}