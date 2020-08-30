package com.epam.order.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.epam.order.exception.model.OrderNotFoundException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER =LoggerFactory.getLogger(GlobalExceptionHandler.class);
    
    
    @ExceptionHandler({ OrderNotFoundException.class })
    public ResponseEntity<String> handleOrderNotFoundException(OrderNotFoundException e) {
	 
	return error(HttpStatus.NO_CONTENT, e);
    }
    
    @ExceptionHandler({ MethodArgumentNotValidException.class })
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
	 
	return error(HttpStatus.BAD_REQUEST, e);
    }
    @ExceptionHandler({ RuntimeException.class })
    public ResponseEntity<String> handleRunTimeException(RuntimeException e) {
	 
	return error(INTERNAL_SERVER_ERROR, e);
    }

  
    private ResponseEntity<String> error(HttpStatus status, Exception e) {
	LOGGER.error("Exception : ", e);
	return ResponseEntity.status(status).body(e.getMessage());
    }
}