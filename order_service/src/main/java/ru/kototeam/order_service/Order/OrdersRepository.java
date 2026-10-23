package ru.kototeam.order_service.Order;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<OrdersModel, Integer> {
	public Page<OrdersModel> findAll(Pageable page);
}
