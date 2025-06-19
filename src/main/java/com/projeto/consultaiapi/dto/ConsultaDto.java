package com.projeto.consultaiapi.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ConsultaDto(
        Long id,
        LocalDateTime dataHora,
        Long profissionalId,
        Long pacienteId,
        String status,
        BigDecimal valor
) {}