package com.epam.order.feign.impl;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.order.model.OrderItem;
import com.epam.order.model.OrderItemRequest;

@FeignClient(name="item-fetcher")
public interface OrderItemServiceClient {
	@RequestMapping(method=RequestMethod.GET, value="/api/orderItem/{id}")
	public List<OrderItem> getItemsFromOrderItem(@PathVariable String id);
	
	@RequestMapping(method=RequestMethod.POST, value="/api/orderItem")
	public OrderItem saveItemsInOrdeItem(@RequestBody OrderItemRequest orderItem);

}
