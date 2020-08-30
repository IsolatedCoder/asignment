package com.epam.order.service;

import java.util.List;

import javax.validation.Valid;

import com.epam.order.entity.Order;
import com.epam.order.model.OrderRequest;
import com.epam.order.model.OrderResponse;


public interface OrderService {


    Order createOrder(OrderRequest order);

    List<OrderResponse> getAllOrder();

    OrderResponse getOrderById(String id);

    
}
