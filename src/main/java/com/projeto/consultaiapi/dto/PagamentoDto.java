package com.projeto.consultaiapi.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PagamentoDto(
        Long id,
        @NotNull
        Long consultaId,
        @NotNull
        BigDecimal valor,
        @NotNull
        LocalDateTime dataPagamento,
        @NotNull
        String status
) {}