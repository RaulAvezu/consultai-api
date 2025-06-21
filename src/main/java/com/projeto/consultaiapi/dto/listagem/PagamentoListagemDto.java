package com.projeto.consultaiapi.dto.listagem;

import com.projeto.consultaiapi.entity.Pagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PagamentoListagemDto(Long id,
                                   BigDecimal valor,
                                   String status,
                                   LocalDateTime dataPagamento,
                                   Long consultaId,
                                   LocalDateTime dataConsulta) {

    public PagamentoListagemDto(Pagamento pagamento) {
        this(pagamento.getId(),
                pagamento.getValor(),
                pagamento.getStatus().toString(),
                pagamento.getDataPagamento(),
                pagamento.getConsulta().getId(),
                pagamento.getConsulta().getDataHora());
    }
}