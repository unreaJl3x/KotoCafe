package ru.kototeam.cats_service.Cats;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CatStatsRepository extends JpaRepository<CatStats, Integer> {

}