package ru.kototeam.tariffs_service.Tariff.dto;
import java.util.List;

public record TariffsModelDtoPost (String name, List<TariffRulesModelDtoGet> rules) {}