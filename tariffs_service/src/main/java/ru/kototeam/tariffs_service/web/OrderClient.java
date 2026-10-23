package ru.kototeam.tariffs_service.web;
import ru.kototeam.tariffs_service.Tariff.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="ORDER-SERVICE")
public interface OrderClient {
	@GetMapping("/api/v1/orders/{id}")
	public ResponseEntity<OrdersModelDtoGet> findById(@RequestParam int id);
}
