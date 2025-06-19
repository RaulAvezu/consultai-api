package com.projeto.consultaiapi.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PagamentoDto(
        Long id,
        Long consultaId,
        BigDecimal valor,
        LocalDateTime dataPagamento,
        String status
) {}