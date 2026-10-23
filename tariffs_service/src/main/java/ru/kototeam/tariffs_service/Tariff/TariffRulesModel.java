package ru.kototeam.tariffs_service.Tariff;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kototeam.tariffs_service.Tariff.dto.TariffRulesModelDtoGet;
import ru.kototeam.tariffs_service.Tariff.dto.TariffRulesModelDtoPost;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TariffRulesModel {
	@Id
	private String name;
	private String expression;
	
	public static TariffRulesModel fromDtoPost(TariffRulesModelDtoPost post) {
		return new TariffRulesModel(post.name(),post.expression());
	}
	public static TariffRulesModelDtoGet toDtoGet(TariffRulesModel r) {
		return new TariffRulesModelDtoGet(r.name,r.expression); 
	} 
}