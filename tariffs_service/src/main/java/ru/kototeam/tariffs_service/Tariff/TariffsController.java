package ru.kototeam.tariffs_service.Tariff;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import ru.kototeam.tariffs_service.Tariff.dto.TariffsModelDtoGet;
import ru.kototeam.tariffs_service.Tariff.dto.TariffsModelDtoPost;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
@RestController
@RequestMapping("/api/v1/tariffs")
@RequiredArgsConstructor
public class TariffsController {
	private final  TariffsService tariffsService;
	
	@GetMapping("/ad/")
	public ResponseEntity<List<TariffsModelDtoGet>> findAll(@RequestParam("page") int page, @RequestParam("size") int size) {
		return ResponseEntity.ok(tariffsService.findAll(page,size));
	}
	@PostMapping("/ad/")
	public ResponseEntity<Void> create(@RequestBody TariffsModelDtoPost post) {
		var t = tariffsService.create(post);
		return ResponseEntity.created(
				ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.build()
				.expand(t.name())
				.toUri()
		).build();
	}
	@GetMapping("/ad/{id}")
	public ResponseEntity<TariffsModel> get(@PathVariable String id) {
		return null;
	}
	@GetMapping("/order_price")
	public ResponseEntity<Double> orderPrice(@RequestParam("order_id") int order_id) {
		return ResponseEntity.ok(tariffsService.orderPrice(order_id));
	}
}
