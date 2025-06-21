package com.projeto.consultaiapi.dto.listagem;

import com.projeto.consultaiapi.entity.Paciente;

public record PacienteListagemDto(Long id,
                                  String nome,
                                  String telefone,
                                  String email,
                                  Boolean ativo) {
    public PacienteListagemDto(Paciente paciente) {
        this(paciente.getId(),
                paciente.getNome(),
                paciente.getTelefone(),
                paciente.getEmail(),
                paciente.getAtivo());
    }
}