/**
 * 
 */
package com.epam.order.model;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class OrderItemRequest {
    private String uniqueId;
    private String productCode;
    private String productName;
    private Integer quantity;
}
