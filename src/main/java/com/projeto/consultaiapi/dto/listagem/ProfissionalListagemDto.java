package com.projeto.consultaiapi.dto.listagem;

import com.projeto.consultaiapi.entity.Profissional;

public record ProfissionalListagemDto(Long id,
                                      String nome,
                                      String especialidade,
                                      String crm,
                                      Boolean ativo) {
    public ProfissionalListagemDto (Profissional profissional){
        this(profissional.getId(),
             profissional.getNome(),
             profissional.getEspecialidade(),
             profissional.getCrm(),
             profissional.getAtivo());
    }
}

