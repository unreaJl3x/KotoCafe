package ru.kototeam.cats_service.Cats;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CatBreedRepository extends JpaRepository<CatBreedModel, String> {
	Optional<CatBreedModel> findById(String name);
}