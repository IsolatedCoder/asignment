package com.epam.order.item.model;

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
public class OrderItemRequest {
    @NotEmpty(message = "ID NOT BE NULL OR EMPTY")
    private String uniqueId;
    @NotEmpty(message = "PRODUCT CODE NOT BE NULL OR EMPTY")
    private String productCode;
    @NotEmpty(message = "PRODUCT NAME NOT BE NULL OR EMPTY")
    private String productName;
    @NotNull(message = "QUANTITY CAN NOT BE NULL ")
    @Min(value = 0)
    private Integer quantity;

}
