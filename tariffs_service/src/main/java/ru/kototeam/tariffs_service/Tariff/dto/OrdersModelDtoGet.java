package ru.kototeam.tariffs_service.Tariff.dto;


import java.time.LocalDateTime;
import java.util.Set;

public record OrdersModelDtoGet(int id, LocalDateTime date, String location, Double price) {}