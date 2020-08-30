package com.epam.order.service;

import java.util.List;

import javax.validation.Valid;

import com.epam.order.entity.Order;
import com.epam.order.model.OrderRequest;
import com.epam.order.model.OrderResponse;


public interface OrderService {


    Order saveOrderDetails(OrderRequest order);

    List<OrderResponse> getAllOrderDetails();

    OrderResponse getOrderDetailsById(String id);

    
}
