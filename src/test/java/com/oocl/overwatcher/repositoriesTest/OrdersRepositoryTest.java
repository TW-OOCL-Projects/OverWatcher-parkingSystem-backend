package com.oocl.overwatcher.repositoriesTest;

import com.oocl.overwatcher.entities.Orders;
import com.oocl.overwatcher.entities.User;
import com.oocl.overwatcher.repositories.OrdersRepository;
import com.oocl.overwatcher.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
@RunWith(SpringRunner.class)
@DataJpaTest
public class OrdersRepositoryTest {

        @Autowired
        private OrdersRepository ordersRepository;
        @Autowired
        private TestEntityManager testEntityManager;

        @Test
        public void findAll() {
            //given
            testEntityManager.persist(new Orders("park","parking","A001"));
            testEntityManager.persist(new Orders("unPark","noUnParking","A002"));

            //when
            List<Orders> companiesList = ordersRepository.findAll();

            //then
            assertThat(companiesList.get(1).getId(), is(2));
            assertThat(companiesList.get(1).getStatus(), is("noUnParking"));
            assertThat(companiesList.get(1).getType(), is("unPark"));

        }
    }

