/**
 * 
 */
package com.epam.order.model;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
public class OrderRequest {

    @NotEmpty(message = "CUSTOMER NAME CAN NOT BE NULL OR EMPTY")
    private String customerName;
    @NotEmpty(message = "DATE CAN NOT BE NULL OR EMPTY")
    private String date;
    @NotEmpty(message = "SHIPPIING ADDRESS CAN NOT BE NULL OR EMPTY")
    private String shippingAddress;
    @NotNull(message = "TOTAL CAN NOT BE NULL ")
    @Min(value = 0)
    private BigDecimal total;
    @NotEmpty(message = "ORDER ITEM CAN NOT BE NULL OR EMPTY")
    private List<OrderItem> orderItems;
}
