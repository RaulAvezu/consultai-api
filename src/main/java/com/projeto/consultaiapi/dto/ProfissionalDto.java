package com.projeto.consultaiapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ProfissionalDto(
        Long id,
        @NotBlank
        String nome,
        @NotBlank
        String especialidade,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotBlank
        @Email
        String email,
        String telefone,
        Boolean ativo
) {}
