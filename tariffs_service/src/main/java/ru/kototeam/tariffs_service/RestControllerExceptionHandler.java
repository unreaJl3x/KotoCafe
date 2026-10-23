package ru.kototeam.tariffs_service;

import ru.kototeam.tariffs_service.Exceptions.OrderServiceFetchException;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class RestControllerExceptionHandler {
	@ExceptionHandler(OrderServiceFetchException.class)
	public ResponseEntity<Void> orderFetchException() {
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
	}
}
