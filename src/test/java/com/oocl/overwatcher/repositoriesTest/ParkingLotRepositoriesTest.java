package com.oocl.overwatcher.repositoriesTest;

import com.oocl.overwatcher.entities.ParkingLot;
import com.oocl.overwatcher.repositories.ParkingLotRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ParkingLotRepositoriesTest {
    @Autowired
    private ParkingLotRepository parkingLotRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void findAllParkingLot(){
        //given
      testEntityManager.persist(new ParkingLot("东南",20));
        //when
        List<ParkingLot> parkingLotList = parkingLotRepository.findAll();
        assertThat(parkingLotList.size(),equalTo(1));
        assertThat(parkingLotList.get(0).getName(),equalTo("东南"));
        assertThat(parkingLotList.get(0).getSize(),equalTo(20));
    }
}
