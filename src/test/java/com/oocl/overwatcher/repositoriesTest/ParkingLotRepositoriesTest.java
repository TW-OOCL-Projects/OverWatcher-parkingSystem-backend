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
        assertThat(parkingLotList.size(),equalTo(5));
     assertThat(parkingLotList.get(4).getName(),equalTo("东南"));
       assertThat(parkingLotList.get(4).getSize(),equalTo(20));
    }

    @Test
    public void is_the_parkingBoyId_in_parkingLot_is_null(){
        //given
        testEntityManager.persist(new ParkingLot("东南",20,"open",20));
        //when
        List<ParkingLot> parkingLotList = parkingLotRepository.findAll();
        //then
        assertThat(parkingLotList.get(6).getName(),equalTo("东南"));
        assertThat(parkingLotList.get(6).getSize(),equalTo(20));
        assertThat(parkingLotList.get(6).getUser(),equalTo(null));
    }
}
