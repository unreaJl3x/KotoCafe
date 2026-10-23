package ru.kototeam.cats_service.Cats.dto;

import java.time.LocalDate;

public record CatsModelDtoPost(
		int age, 
		String name,
		String breed, 
		LocalDate date, 
		float active, 
		float socialy, 
		float noises, 
		float patience
) {}