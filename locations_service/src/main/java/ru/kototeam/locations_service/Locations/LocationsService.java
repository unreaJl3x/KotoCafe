package ru.kototeam.locations_service.Locations;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import ru.kototeam.locations_service.Locations.dto.LocationsModelDtoGet;
import ru.kototeam.locations_service.Locations.dto.LocationsModelDtoPost;

import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class LocationsService {
	private final LocationsRepository repo;
	
	public List<LocationsModelDtoGet> findAll(int page,int size) {
		var list = repo.findAll(PageRequest.of(page, size)).map(i->LocationsModel.toDtoGet(i)).toList();
		log.info("Get all locations entity. [%s]".formatted(list.size()));
		return list;
	}
	
	@Transactional
	public LocationsModelDtoGet create(LocationsModelDtoPost post) {
		var loc = repo.save(LocationsModel.fromDtoPost(post));
		log.info("Succseful created location entity with id %s.".formatted(loc.getName()));
		return LocationsModel.toDtoGet(loc);
	}
}