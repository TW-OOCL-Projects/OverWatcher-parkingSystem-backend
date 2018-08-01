package com.oocl.overwatcher.repositoriesTest;

import com.oocl.overwatcher.entities.Orders;
import com.oocl.overwatcher.repositories.OrdersRepository;
import org.junit.After;
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

    @After
    public void tearDown() throws Exception {
        testEntityManager.clear();
    }

        @Test
        public void findAll() {
            //given
            testEntityManager.persist(new Orders(Orders.TYPE__PARK,Orders.STATUS_YES,"A001",Orders.NOT_LEAVE));
            testEntityManager.persist(new Orders(Orders.TYPE__UNPARK,Orders.STATUS_NO,"A002",Orders.NOT_LEAVE));

            //when
            List<Orders> ordersList = ordersRepository.findAll();

            //then
            assertThat(ordersList.get(1).getId(), is(2));
            assertThat(ordersList.get(1).getStatus(), is(Orders.STATUS_NO));
            assertThat(ordersList.get(1).getType(), is(Orders.TYPE__UNPARK));

        }

    @Test
    public void add() {
        //given

        //when
        Orders orders=new Orders(Orders.TYPE__PARK,Orders.STATUS_YES,"A001",Orders.NOT_LEAVE);
        ordersRepository.save(orders);
        List<Orders> ordersList = ordersRepository.findAll();

        //then
        assertThat(ordersList.size(), is(1));
        assertThat(ordersList.get(0).getStatus(), is(Orders.STATUS_YES));
        assertThat(ordersList.get(0).getType(), is(Orders.TYPE__PARK));
    }

    @Test
    public void findById() {
        //given

        //when
        ordersRepository.save(new Orders(Orders.TYPE__PARK,Orders.STATUS_YES,"A001",Orders.NOT_LEAVE));
        ordersRepository.save(new Orders(Orders.TYPE__UNPARK,Orders.STATUS_NO,"A002",Orders.NOT_LEAVE));
        Orders orders = ordersRepository.findBycarId("A001");

        //then
        assertThat(orders.getStatus(), is(Orders.STATUS_YES));
        assertThat(orders.getType(), is(Orders.TYPE__PARK));
    }
    }

