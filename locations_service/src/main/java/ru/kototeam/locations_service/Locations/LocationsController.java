package ru.kototeam.locations_service.Locations;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import ru.kototeam.locations_service.Locations.dto.LocationsModelDtoGet;
import ru.kototeam.locations_service.Locations.dto.LocationsModelDtoPost;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/locations")
@RequiredArgsConstructor
public class LocationsController {
	private final LocationsService locationsService;
	
	@GetMapping()
	public ResponseEntity<List<LocationsModelDtoGet>> findAll(@RequestParam("page") int page, @RequestParam("count") int count) {
		return ResponseEntity.ok(locationsService.findAll(page, count));
	}
	@PostMapping()
	public ResponseEntity<Void> create(@RequestBody LocationsModelDtoPost post) {
		var loc = locationsService.create(post);
		return ResponseEntity
				.created(ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.build()
						.expand(loc.name())
						.toUri()
				)
				.build();
	}
}
