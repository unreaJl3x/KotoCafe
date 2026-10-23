package ru.kototeam.order_service.Order;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ru.kototeam.order_service.Order.dto.*;

@RestController("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
	private final OrdersService service;
	@GetMapping("/ad/")
	public ResponseEntity<List<OrdersModelDtoGet>> findAll(@RequestParam("page") int page, @RequestParam("count") int count) {
		return ResponseEntity.ok().body(service.findAll(page, count));
	}
	@GetMapping("/ad/{id}")
	public ResponseEntity<OrdersModelDtoGet> findById(@PathVariable int id) {
		return null;
	}
	@PostMapping("/create")
	public ResponseEntity<OrdersModelDtoGet> createOrder(@RequestBody OrdersModelDtoPost order, @CookieValue(value="userId",required=true) int user) {
		return ResponseEntity.ok(service.createOrder(order, user));
	}
}
