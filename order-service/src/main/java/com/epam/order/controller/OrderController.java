package com.epam.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
@Validated
public class OrderController {


    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public ResponseEntity<Order> saveOrder(@RequestBody@Valid OrderRequest order) {
        return new ResponseEntity<>(orderService.saveOrderDetails(order), HttpStatus.OK);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponse>> getAllOrder() {
        return new ResponseEntity<>(orderService.getAllOrderDetails(), HttpStatus.OK);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable(name ="sid", required =true) String id) {
        return new ResponseEntity<>(orderService.getOrderDetailsById(id), HttpStatus.OK);

    }


}
