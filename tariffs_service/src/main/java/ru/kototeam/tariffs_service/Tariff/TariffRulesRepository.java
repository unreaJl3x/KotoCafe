package ru.kototeam.tariffs_service.Tariff;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TariffRulesRepository extends JpaRepository<TariffRulesModel, String> {
	List<TariffRulesModel> findAllById(Iterable<String> ids);
}
