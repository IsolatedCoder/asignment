package com.epam.order.item.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.epam.order.item.controller.OrderItemController;
import com.epam.order.item.entity.OrderItem;
import com.epam.order.item.repository.OrderItemRepostiroty;
import com.epam.order.item.service.OrderItemService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

 
@RunWith(SpringRunner.class)
@WebMvcTest(OrderItemController.class)
public class OrderControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private OrderItemService orderService;

    @Test
    public void getAllOrderAPI() throws Exception {

        List<OrderItem> orderList = new ArrayList<>();
        OrderItem order = new OrderItem();
        order.setId(1L);
        //order.setDescription("order_desc");
        orderList.add(order);

        when(orderService.getAllOrderItem()).thenReturn(orderList);
        mvc.perform(MockMvcRequestBuilders
                .get("/api/order")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].id").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].id").value("1"));
    }
}
