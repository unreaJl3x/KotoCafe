package ru.kototeam.order_service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ru.kototeam.order_service.Order.Exceptions.TrafficServiceFetchException;

@RestControllerAdvice
public class RestControllerExceptionHandler {
	@ExceptionHandler(TrafficServiceFetchException.class)
	public ResponseEntity<Void> tariffFetch() {
		
		return ResponseEntity
				.status(HttpStatus.BAD_GATEWAY)
				.build();
	}	
}
