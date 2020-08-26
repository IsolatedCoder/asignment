package com.epam.order.entity;

import java.math.BigDecimal;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
 
@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order { 
    @Id
    private String id;
    private String customerName;
    private String date;
    private String shippingAddress;
    private BigDecimal total;
   
 
    
}
