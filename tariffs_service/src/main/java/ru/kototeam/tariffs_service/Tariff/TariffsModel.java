package ru.kototeam.tariffs_service.Tariff;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kototeam.tariffs_service.Tariff.dto.TariffsModelDtoGet;
import ru.kototeam.tariffs_service.Tariff.dto.TariffsModelDtoPost;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TariffsModel {
	@Id
	private String name;
	@ManyToMany()
	private List<TariffRulesModel> rules;
	
	public static TariffsModel fromDtoPost(TariffsModelDtoPost post, List<TariffRulesModel> rules) {
		return new TariffsModel(post.name(), rules);
	}
	public static TariffsModelDtoGet toDtoGet(TariffsModel t) {
		return new TariffsModelDtoGet(t.getName(), t.getRules().stream().map(TariffRulesModel::toDtoGet).toList());
	}
}