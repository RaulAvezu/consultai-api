package com.projeto.consultaiapi.dto.listagem;

import com.projeto.consultaiapi.entity.Consulta;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ConsultaListagemDto(Long id,
                                  LocalDateTime dataHora,
                                  String status,
                                  Long pacienteId,
                                  String pacienteNome,
                                  Long profissionalId,
                                  String profissionalNome) {
    public ConsultaListagemDto(Consulta consulta) {
        this(consulta.getId(),
                consulta.getDataHora(),
                consulta.getStatus().toString(),
                consulta.getPaciente().getId(),
                consulta.getPaciente().getNome(),
                consulta.getProfissional().getId(),
                consulta.getProfissional().getNome());
    }
}
