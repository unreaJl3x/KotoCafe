package ru.kototeam.locations_service.Locations;

import org.springframework.data.domain.*;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationsRepository extends JpaRepository<LocationsModel,String> {
	public Page<LocationsModel> findAll(Pageable page);
	public Optional<LocationsModel> findById(String id);
}
