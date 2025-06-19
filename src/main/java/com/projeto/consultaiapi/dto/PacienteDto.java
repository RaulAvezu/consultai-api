package com.projeto.consultaiapi.dto;

import java.time.LocalDate;

public record PacienteDto(
        Long id,
        String nome,
        String email,
        String telefone,
        LocalDate dataNascimento,
        Boolean ativo
) {}