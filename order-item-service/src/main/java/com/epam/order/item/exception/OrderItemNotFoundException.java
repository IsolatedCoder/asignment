package com.epam.order.item.exception;

public class OrderItemNotFoundException extends RuntimeException{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String message;
    
    public OrderItemNotFoundException(String message) {
	super(message);
    }

    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	this.message = message;
    }

}
