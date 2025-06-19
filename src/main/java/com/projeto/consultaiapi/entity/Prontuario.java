package com.projeto.consultaiapi.entity;

import com.projeto.consultaiapi.dto.ProntuarioDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "prontuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private Profissional profissional;

    @Column(name = "data_registro")
    private LocalDateTime dataRegistro;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    public Prontuario(ProntuarioDto dto) {
        this.id = dto.id();
        this.dataRegistro = dto.dataRegistro();
        this.descricao = dto.descricao();
        // paciente e profissional devem ser setados externamente porque vem só o ID no dto
    }
}