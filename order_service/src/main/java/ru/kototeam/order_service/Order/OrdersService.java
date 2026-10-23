package ru.kototeam.order_service.Order;
import ru.kototeam.order_service.Order.web.TariffsClient;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.time.Instant;
import java.util.List;
import lombok.RequiredArgsConstructor;
import ru.kototeam.order_service.Order.Exceptions.TrafficServiceFetchException;
import ru.kototeam.order_service.Order.dto.*;
import lombok.extern.slf4j.Slf4j;
@Service
@RequiredArgsConstructor
@Slf4j
public class OrdersService {
	private final OrdersRepository ordersRepo;
	private final TariffsClient tariffFetch;
	
	public List<OrdersModelDtoGet> findAll(int page, int size) {
		var list = ordersRepo.findAll(PageRequest.of(page, size)).map(OrdersModel::toDtoGet).toList();
		log.info("Get all orders entity. [%s]".formatted(list.size()));
		return null; 
	}
	
	public OrdersModelDtoGet createOrder(OrdersModelDtoPost post, int user)  {
		var order = new OrdersModel(null, Instant.now(), post.locationId(), null, user, post.cats());
		ordersRepo.save(order);
		try {
			var price = tariffFetch.getPrice(order.getId());
			if (price.getStatusCode().isError()) throw new TrafficServiceFetchException("Cannot fetch with TrafficService");
			order.setPrice(price.getBody());
		} catch(RuntimeException e) {
			ordersRepo.delete(order);
			throw e;
		}
		log.info("Succseful created order model with id '%s'.".formatted(order.getId()));
		return OrdersModel.toDtoGet(order);
	}
}
