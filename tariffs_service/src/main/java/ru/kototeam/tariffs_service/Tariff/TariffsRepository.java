package ru.kototeam.tariffs_service.Tariff;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TariffsRepository extends JpaRepository<TariffsModel, String> {
	Page<TariffsModel> findAll(Pageable page);
	Optional<TariffsModel> findById(String id);
}
