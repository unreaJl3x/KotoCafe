package ru.kototeam.tariffs_service.Tariff;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.kototeam.tariffs_service.Tariff.dto.OrdersModelDtoGet;
import ru.kototeam.tariffs_service.Tariff.dto.TariffRulesModelDtoGet;
import ru.kototeam.tariffs_service.Tariff.dto.TariffRulesModelDtoPost;
import ru.kototeam.tariffs_service.Tariff.dto.TariffsModelDtoGet;
import ru.kototeam.tariffs_service.Tariff.dto.TariffsModelDtoPost;
import ru.kototeam.tariffs_service.web.OrderClient;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
@Slf4j
public class TariffsService {
	private final OrderClient orderFetch;
	private final TariffsRepository tariffsRepo;
	private final TariffRulesRepository tariffRulesRepo;
	private final SpelExpressionParser parser = new SpelExpressionParser();
	
	public List<TariffsModelDtoGet> findAll(int page, int size) {
		var list = tariffsRepo.findAll(PageRequest.of(page, size)).map(TariffsModel::toDtoGet).toList();
		log.info("Get all tariffes entity. [%s]".formatted(list));
		return list;
	}
	
	public TariffsModelDtoGet findById(String id) {
		var obj = tariffsRepo.findById(id).orElseThrow();
		log.info("Get tariff entity by id. [%s]".formatted(obj.getName()));
		return TariffsModel.toDtoGet(obj);
	}
	
	@Transactional
	public TariffsModelDtoGet create(TariffsModelDtoPost post) {
		var rules = tariffRulesRepo.findAllById( (Iterable<String>) post.rules().stream().map(TariffRulesModelDtoGet::name).toList());
		var obj = tariffsRepo.save(TariffsModel.fromDtoPost(post,rules));
		log.info("Succseful created tariff model with id %s.".formatted(obj.getName()));
		return TariffsModel.toDtoGet(obj);
	}
	
	public Double orderPrice(int order_id) {
		var order = orderFetch.findById(order_id);
		
		EvaluationContext context = new StandardEvaluationContext(order);
		
		var val = tariffsRepo.findById("DEFAULT").get().getRules().stream()
			.map(i->{
				return parser.parseExpression(i.getExpression()).getValue(context, Double.class);
			}).reduce( (a,b) -> a+b ).get();
		log.info("Succseful processed request for order %s.".formatted(order_id));
		return val;
	}
}
