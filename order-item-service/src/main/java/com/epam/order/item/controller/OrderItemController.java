package com.epam.order.item.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.order.item.entity.OrderItem;
import com.epam.order.item.model.OrderItemRequest;
import com.epam.order.item.model.OrderItems;
import com.epam.order.item.service.OrderItemService;

@RestController
@RequestMapping("/api")
@Validated
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/orderItems")
    public ResponseEntity<OrderItem> saveOrderItem(@RequestBody@Valid OrderItemRequest order) {
	return new ResponseEntity<>(orderItemService.createOrderItem(order), HttpStatus.OK);
    }

    @GetMapping("/orderItems")
    public ResponseEntity<List<OrderItem>> getAllOrderItems() {
	return new ResponseEntity<>(orderItemService.getAllOrderItem(), HttpStatus.OK);
    }

    @GetMapping("/orderItems/{id}")
    public ResponseEntity<List<OrderItems>> getOrderItemById(@PathVariable(name ="id",required =true) String id) {
	return new ResponseEntity<>(orderItemService.getOrderItemById(id), HttpStatus.OK);

    }

}
