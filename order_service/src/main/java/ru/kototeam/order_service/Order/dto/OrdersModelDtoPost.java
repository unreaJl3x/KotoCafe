package ru.kototeam.order_service.Order.dto;
import java.util.List;
import java.util.Set;

public record OrdersModelDtoPost(String locationId, Set<Integer> cats, int peopleCount) {}