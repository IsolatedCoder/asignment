/**
 * 
 */
package com.epam.order.item.model;

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
public class OrderItems {

    
   private String productCode;
   private String productName;
   private Integer quantity;

}
