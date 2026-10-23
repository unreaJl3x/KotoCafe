package ru.kototeam.cats_service.Cats;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.RequiredArgsConstructor;
import ru.kototeam.cats_service.Cats.dto.CatsModelDtoGet;
import ru.kototeam.cats_service.Cats.dto.CatsModelDtoPost;

@RestController
@RequestMapping("/api/v1/cats")
@RequiredArgsConstructor
public class CatsController {
	private final CatsService catsService; 
	
	@GetMapping()
	public ResponseEntity<List<CatsModelDtoGet>> findAll(@RequestParam("page") int page, @RequestParam("count") int count) {
		return ResponseEntity.ok(catsService.findAll(page, count));
	}
	@PostMapping()
	public ResponseEntity<Void> create(@RequestBody CatsModelDtoPost post)  {
		var cat = catsService.create(post);
		
		return ResponseEntity
				.created(
						ServletUriComponentsBuilder
							.fromCurrentRequest()
							.path("/{id}")
							.build()
							.expand(cat.id())
							.toUri()
			    )
				.build();
	}
	@GetMapping("/{id}")
	public ResponseEntity<CatsModelDtoGet> findById(@PathVariable Integer id) {
		return ResponseEntity.ok(catsService.findById(id));
	}
}