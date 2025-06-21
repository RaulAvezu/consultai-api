package com.projeto.consultaiapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PacienteDto(
        Long id,
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        String telefone,
        LocalDate dataNascimento,
        @NotNull
        Boolean ativo
) {}