package com.epam.order.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.epam.order.entity.Order;

 
@Repository
public interface OrderRepostiroty extends CrudRepository<Order, String> {

}
