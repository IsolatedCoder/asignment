package com.epam.order.item.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.epam.order.item.entity.OrderItem;
import com.epam.order.item.repository.OrderItemRepostiroty;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderRepositoryTest {

    @Autowired
    private OrderItemRepostiroty orderRepostiroty;


    @Test
    public void test_SaveOrder() {

        OrderItem order = new OrderItem();
        order.setId(1L);
       
        orderRepostiroty.save(order);

        OrderItem savedOrder = orderRepostiroty.findById("1").get();

        assertNotNull(savedOrder);
       // assertEquals(savedOrder.getName(), order.getName());
    }

    @Test(expected = NoSuchElementException.class)
    public void test_OrderIsNotPresent() {

        OrderItem order = new OrderItem();
        order.setId(1L);
     
        orderRepostiroty.save(order);

        orderRepostiroty.findById("2").get();
    }

}
