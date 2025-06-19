package com.projeto.consultaiapi.entity;

import com.projeto.consultaiapi.dto.ProfissionalDto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "profissional")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String especialidade;

    private String crm;

    private String email;

    private String telefone;

    private Boolean ativo;

    public Profissional(ProfissionalDto profissionalDto) {
        this.id = profissionalDto.id();
        this.nome = profissionalDto.nome();
        this.especialidade = profissionalDto.especialidade();
        this.crm = profissionalDto.crm();
        this.email = profissionalDto.email();
        this.telefone = profissionalDto.telefone();
        this.ativo = profissionalDto.ativo();
    }
}
