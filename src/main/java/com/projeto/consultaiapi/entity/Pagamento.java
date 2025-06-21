package com.projeto.consultaiapi.entity;

import com.projeto.consultaiapi.dto.PagamentoDto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "consulta_id")
    private Consulta consulta;

    private BigDecimal valor;

    @Column(name = "data_pagamento")
    private LocalDateTime dataPagamento;

    @Enumerated(EnumType.STRING)
    private StatusPagamento status;

    public Pagamento(PagamentoDto dto) {
        this.id = dto.id();
        this.valor = dto.valor();
        this.dataPagamento = dto.dataPagamento();
        this.status = StatusPagamento.valueOf(dto.status());
        // consulta deve ser setada externamente porque vem só o ID no dto
    }
    public Pagamento(PagamentoDto dto, Consulta consulta) {
        this(dto);
        this.consulta = consulta;
    }
}
