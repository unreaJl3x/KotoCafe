package ru.kototeam.order_service.Order.web;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="TRAFFICS_SERVICE")
public interface TariffsClient {
	@GetMapping("/api/v1/tariffs/order_price?order_id={id}")
	public ResponseEntity<Double> getPrice(@RequestParam int id);
}
