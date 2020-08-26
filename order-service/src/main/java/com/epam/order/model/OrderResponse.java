/**
 * 
 */
package com.epam.order.model;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Computer
 *
 */
@Data
@ToString
@Getter
@Setter
public class OrderResponse {

    private String customerName;

    private String date;

    private String shippingAddress;

    private BigDecimal total;

    private List<OrderItem> orderItems;

}
