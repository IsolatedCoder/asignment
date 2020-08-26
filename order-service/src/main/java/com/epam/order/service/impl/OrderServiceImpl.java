package com.epam.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.epam.order.entity.Order;
import com.epam.order.exception.model.OrderNotFoundException;
import com.epam.order.model.OrderItem;
import com.epam.order.model.OrderItemRequest;
import com.epam.order.model.OrderRequest;
import com.epam.order.model.OrderResponse;
import com.epam.order.repository.OrderRepostiroty;
import com.epam.order.service.OrderService;
import com.epam.order.service.RemoteCallService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepostiroty orderRepostiroty;
    
    @Autowired
    private RemoteCallService  service;

    @Override
    public Order createOrder(OrderRequest orderRequest) {

	String uniqueId = UUID.randomUUID().toString();
	Order order = new Order(uniqueId, orderRequest.getCustomerName(), orderRequest.getDate(),
		orderRequest.getShippingAddress(), orderRequest.getTotal());
	orderRequest.getOrderItems().forEach(item ->{
	    service.postData(new OrderItemRequest(uniqueId, item.getProductCode(), item.getProductName(), item.getQuantity()));
	});
	return orderRepostiroty.save(order);
    }

    @Override
    public List<Order> getAllOrder() {
	return (List<Order>) orderRepostiroty.findAll();
    }

    @Override
    public OrderResponse getOrderById(String id) {
	OrderResponse resp = new OrderResponse(); 
	Optional<Order> dbOrder = orderRepostiroty.findById(id);
	List<OrderItem> list =service.getData(id);
	Order order =dbOrder.orElse(null);
	if(order!=null&&!CollectionUtils.isEmpty(list)) {
	    resp.setOrderItems(list);
	    resp.setTotal(order.getTotal());
	    resp.setShippingAddress(order.getShippingAddress()) ;
	   resp.setDate(order.getDate());
	   resp.setCustomerName(order.getCustomerName());
	}else {
	    throw new OrderNotFoundException("No Order available with respect to the given id "+id);
	}
	return resp ;
    }

    @Override
    public boolean deleteOrderById(String id) {
	orderRepostiroty.deleteById(id);
	return getOrderById(id) == null;
    }
}
