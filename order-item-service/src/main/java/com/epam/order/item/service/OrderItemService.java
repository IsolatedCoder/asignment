package com.epam.order.item.service;

import java.util.List;

import com.epam.order.item.entity.OrderItem;
import com.epam.order.item.model.OrderItemRequest;
import com.epam.order.item.model.OrderItems;


public interface OrderItemService {


    OrderItem createOrderItem(OrderItemRequest order);

    List<OrderItem> getAllOrderItem();

    List<OrderItems> getOrderItemById(String id);
   
}
