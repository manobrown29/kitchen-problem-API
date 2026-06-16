package com.bytesMenu.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CriarPratoDTO(
        @NotBlank(message = "Nome é obrigatório")
        String name,
        String description,

        @NotNull(message = "O valor não pode ser negativo.")
        @Min(value = 0, message = "Quantidade não pode ser negativa")
        BigDecimal price

) {
}
