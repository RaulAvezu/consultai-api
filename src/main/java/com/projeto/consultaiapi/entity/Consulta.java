package com.projeto.consultaiapi.entity;

import com.projeto.consultaiapi.dto.ConsultaDto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "consulta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private Profissional profissional;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @Enumerated(EnumType.STRING)
    private StatusConsulta status;

    private BigDecimal valor;

    public Consulta(ConsultaDto dto) {
        this.id = dto.id();
        this.dataHora = dto.dataHora();
        this.status = StatusConsulta.valueOf(dto.status());
        this.valor = dto.valor();
    }
}
