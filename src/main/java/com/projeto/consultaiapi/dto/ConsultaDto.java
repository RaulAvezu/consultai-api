package com.projeto.consultaiapi.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ConsultaDto(
        Long id,
        LocalDateTime dataHora,
        @NotNull
        Long profissionalId,
        @NotNull
        Long pacienteId,
        @NotNull
        String status,
        BigDecimal valor
) {}