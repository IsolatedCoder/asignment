package com.epam.order.item.exception;

public class OrderNotFoundException extends RuntimeException{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String message;
    
    public OrderNotFoundException(String message) {
	super(message);
    }

    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	this.message = message;
    }

}
