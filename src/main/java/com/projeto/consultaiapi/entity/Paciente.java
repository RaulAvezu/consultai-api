package com.projeto.consultaiapi.entity;

import com.projeto.consultaiapi.dto.PacienteDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "paciente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    private Boolean ativo;

    public Paciente(PacienteDto dto) {
        this.id = dto.id();
        this.nome = dto.nome();
        this.email = dto.email();
        this.telefone = dto.telefone();
        this.dataNascimento = dto.dataNascimento();
        this.ativo = dto.ativo();
    }
}
