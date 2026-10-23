package ru.kototeam.cats_service.Cats;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.DecimalMax;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="CatStats")
public class CatStats {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@DecimalMin(value="-1.0")
	@DecimalMax(value="1.0")
	private float active;
	
	@DecimalMin(value="-1.0")
	@DecimalMax(value="1.0")
	private float socialy;
	
	@DecimalMin(value="-1.0")
	@DecimalMax(value="1.0")
	private float noises;
	
	@DecimalMin(value="-1.0")
	@DecimalMax(value="1.0")
	private float patience;
}
