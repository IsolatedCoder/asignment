/**
 * 
 */
package com.epam.order.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties(ignoreUnknown =true)
public class OrderItem {
    private String productCode;
    private String productName;
    private Integer quantity;
}
