package com.projeto.consultaiapi.dto;

public record ProfissionalDto(
        Long id,
        String nome,
        String especialidade,
        String crm,
        String email,
        String telefone,
        Boolean ativo
) {}
