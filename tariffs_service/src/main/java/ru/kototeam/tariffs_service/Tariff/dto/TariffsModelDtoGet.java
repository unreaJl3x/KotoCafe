package ru.kototeam.tariffs_service.Tariff.dto;
import java.util.List;

public record TariffsModelDtoGet(String name, List<TariffRulesModelDtoGet> rules) {}