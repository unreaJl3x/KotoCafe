package ru.kototeam.cats_service.Cats;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CatsRepository extends JpaRepository<CatsModel, Integer>{
	public Page<CatsModel> findAll(Pageable page);
}
