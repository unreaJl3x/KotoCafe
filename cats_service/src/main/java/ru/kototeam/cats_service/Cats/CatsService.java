package ru.kototeam.cats_service.Cats;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.persistence.Transient;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Stream;

import lombok.RequiredArgsConstructor;
import ru.kototeam.cats_service.Cats.dto.CatsModelDtoGet;
import ru.kototeam.cats_service.Cats.dto.CatsModelDtoPost;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CatsService {
	private final CatsRepository catsRepo;
	private final CatStatsRepository catStatsRepo;
	private final CatBreedRepository catBreedRepo;

	public List<CatsModelDtoGet> findAll (int page,int count) {
		var list = this.catsRepo.findAll(PageRequest.of(page, count)).stream().map(CatsModel::toDtoGet).toList();
		log.info("Get all cats entity. [%s]".formatted(list.size()));
		return list;
	}
	
	@Transactional
	public CatsModelDtoGet create(CatsModelDtoPost post) {
		var stats = catStatsRepo.save(new CatStats(null, post.active(), post.socialy(), post.noises(), post.patience()));
		var breed = catBreedRepo
				.findById(post.breed())
				.orElseGet(() -> {
					return catBreedRepo.save(new CatBreedModel(post.breed()));
				 });
		var cat = catsRepo.save(CatsModel.fromDtoPost(post, stats, breed));
		log.info("Succseful created cat model with id %s.".formatted(cat.getId()));
		return CatsModel.toDtoGet(cat);
	}
	
	public CatsModelDtoGet findById(int id) {
		log.info("");
		return CatsModel.toDtoGet(catsRepo.findById(id).orElseThrow());
	}
}
