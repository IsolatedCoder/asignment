package com.epam.order.item.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.epam.order.entity.Order;
import com.epam.order.repository.OrderRepostiroty;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepostiroty orderRepostiroty;


    @Test
    public void test_SaveOrder() {

        Order order = new Order();
        order.setId("1");
        order.setCustomerName("abhinav");
       
        orderRepostiroty.save(order);

        Order savedOrder = orderRepostiroty.findById("1").get();

        assertNotNull(savedOrder);
        assertEquals(savedOrder.getCustomerName(), order.getCustomerName());
    }

    @Test(expected = NoSuchElementException.class)
    public void test_OrderIsNotPresent() {

        Order order = new Order();
        order.setId("1");
        order.setCustomerName("abhinav");
        orderRepostiroty.save(order);

        orderRepostiroty.findById("2").get();
    }

}
