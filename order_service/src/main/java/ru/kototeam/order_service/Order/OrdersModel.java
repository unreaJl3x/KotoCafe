package ru.kototeam.order_service.Order;

import lombok.*;
import ru.kototeam.order_service.Order.dto.*;

import java.time.Instant;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import java.util.List;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="orders")
public class OrdersModel {
	@Id
	private Integer id;
	private Instant date;
	private String locationId;
	private Double price;
	private int userId;
	
	public static OrdersModel fromDtoPost(OrdersModelDtoPost post) {
		return null;
	}
	public static OrdersModelDtoGet toDtoGet(OrdersModel order) {
		return new OrdersModelDtoGet(
				order.getId(),
				LocalDateTime.ofInstant(order.getDate(),ZoneId.systemDefault()),
				order.getLocationId(),
				order.getPrice()
		);
	}
	
	@ElementCollection()
	@CollectionTable(joinColumns=@JoinColumn(name="user_id"))
	@Column(name="cat_id")
	private Set<Integer> cats;
}
