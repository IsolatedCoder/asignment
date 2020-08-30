package com.epam.order.item.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.epam.order.item.entity.OrderItem;
import com.epam.order.item.exception.OrderItemNotFoundException;
import com.epam.order.item.model.OrderItemRequest;
import com.epam.order.item.model.OrderItems;
import com.epam.order.item.repository.OrderItemRepostiroty;
import com.epam.order.item.service.OrderItemService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepostiroty itemRepostiroty;


    @Override
    public OrderItem createOrderItem(OrderItemRequest order) {
	OrderItem item = new OrderItem();
	item.setProductCode(order.getProductCode());
	item.setQuantity(order.getQuantity());
	
	item.setUniqueId(order.getUniqueId());
        return itemRepostiroty.save(item);
    }

    @Override
    public List<OrderItem> getAllOrderItem() {
        return (List<OrderItem>) itemRepostiroty.findAll();
    }

    @Override
    public List<OrderItems> getOrderItemById(String id) {
        List<OrderItem> dbOrder = itemRepostiroty.findAllByUid(id);
        List<OrderItems> items = new ArrayList<OrderItems>();
        if(!CollectionUtils.isEmpty(dbOrder)) {
            items= dbOrder.stream().map(item->new OrderItems(  item.getProductCode(), item.getProductName(), item.getQuantity())).collect(Collectors.toList())  ; 
        }
        else {
            throw new OrderItemNotFoundException("Order items not available :::"+id);
        }
        return items;
    }
 
}
