package com.epam.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.epam.order.entity.Order;
import com.epam.order.model.OrderRequest;
import com.epam.order.model.OrderResponse;
import com.epam.order.repository.OrderRepostiroty;
import com.epam.order.service.OrderService;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;


@RestController
@RequestMapping("/api")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<Order> saveOrder(@RequestBody@Valid OrderRequest order) {
        return new ResponseEntity<>(orderService.createOrder(order), HttpStatus.OK);
    }

    @GetMapping("/order")
    public ResponseEntity<List<Order>> getAllOrder() {
        return new ResponseEntity<>(orderService.getAllOrder(), HttpStatus.OK);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable String id) {
        return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);

    }


}
