package com.projeto.consultaiapi.dto;

import java.time.LocalDateTime;

public record ProntuarioDto(
        Long id,
        Long pacienteId,
        Long profissionalId,
        LocalDateTime dataRegistro,
        String descricao
) {
}
