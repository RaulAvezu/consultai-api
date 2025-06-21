package com.projeto.consultaiapi.dto.listagem;

import com.projeto.consultaiapi.entity.Prontuario;

import java.time.LocalDateTime;

public record ProntuarioListagemDto(Long id,
                                    LocalDateTime dataRegistro,
                                    String descricao,
                                    Long pacienteId,
                                    String pacienteNome,
                                    Long profissionalId,
                                    String profissionalNome) {

    public ProntuarioListagemDto(Prontuario prontuario) {
        this(prontuario.getId(),
                prontuario.getDataRegistro(),
                prontuario.getDescricao(),
                prontuario.getPaciente().getId(),
                prontuario.getPaciente().getNome(),
                prontuario.getProfissional().getId(),
                prontuario.getProfissional().getNome());
    }
}