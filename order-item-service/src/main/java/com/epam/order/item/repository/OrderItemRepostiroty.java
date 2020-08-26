package com.epam.order.item.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.epam.order.item.entity.OrderItem;

 
@Repository
public interface OrderItemRepostiroty extends CrudRepository<OrderItem, String> {
    
    @Query(
	    value = "SELECT * FROM order_items WHERE unique_id=:uniqueId", 
	    nativeQuery = true)
    List<OrderItem> findAllByUid(@Param("uniqueId")String uniqueId);

}
