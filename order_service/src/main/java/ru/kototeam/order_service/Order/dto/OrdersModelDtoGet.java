package ru.kototeam.order_service.Order.dto;
import java.time.LocalDateTime;

public record OrdersModelDtoGet(int id, LocalDateTime date, String location, Double price) {}