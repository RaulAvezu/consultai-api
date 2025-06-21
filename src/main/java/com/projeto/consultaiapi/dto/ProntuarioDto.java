package com.projeto.consultaiapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ProntuarioDto(
        Long id,
        @NotNull
        Long pacienteId,
        @NotNull
        Long profissionalId,
        LocalDateTime dataRegistro,
        @NotBlank
        String descricao
) {
}
