package ru.kototeam.cats_service.Cats;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.kototeam.cats_service.Cats.dto.CatsModelDtoGet;
import ru.kototeam.cats_service.Cats.dto.CatsModelDtoPost;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Positive;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="Cats")
public class CatsModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Positive
	private Integer age;
	@Column(length=26,unique=true)
	private String name;
	private LocalDate date;
	@OneToOne()
	private CatStats stats;
	@ManyToOne()
	private CatBreedModel breed;
	
	public static CatsModelDtoGet toDtoGet(CatsModel cat) {
		return new CatsModelDtoGet(
						cat.getId(),
						cat.getAge(),
						cat.getName(),
						cat.getBreed().getName(),
						cat.getDate(),
						cat.getStats().getActive(),
						cat.getStats().getSocialy(),
						cat.getStats().getNoises(),
						cat.getStats().getPatience()
		);
	}
	
	public static CatsModel fromDtoPost(CatsModelDtoPost post, CatStats stats, CatBreedModel breed) {
		return new CatsModel(
				null,
				post.age(),
				post.name(),
				post.date(),
				stats,
				breed
		);
	}
}
