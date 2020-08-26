package com.epam.order.item.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.epam.order.item.entity.OrderItem;
import com.epam.order.item.repository.OrderItemRepostiroty;
import com.epam.order.item.service.impl.OrderItemServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
 

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTest {

    @InjectMocks
    private OrderItemServiceImpl orderService;

    @Mock
    private OrderItemRepostiroty orderRepostiroty;

    @Test
    public void whenGetAllOrder_thenReturnOrderList() {

        List<OrderItem> orderList = new ArrayList<>();
        OrderItem order = new OrderItem();
        order.setId(1L) ;
      //  order.setDescription("order_desc");
        orderList.add(order);

        Mockito.when(orderRepostiroty.findAll()).thenReturn(orderList);

        List<OrderItem> returnedOrderList = orderService.getAllOrderItem();
        assertEquals(returnedOrderList.size(), orderList.size());


    }
}
