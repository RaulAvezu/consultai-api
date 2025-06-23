package com.projeto.consultaiapi.service;

import com.projeto.consultaiapi.dto.ProfissionalDto;
import com.projeto.consultaiapi.dto.listagem.ProfissionalListagemDto;
import com.projeto.consultaiapi.entity.Profissional;
import com.projeto.consultaiapi.repository.ProfissionalRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfissionalService {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Transactional
    public void cadastrarProfissional(ProfissionalDto dto) {
        profissionalRepository.save(new Profissional(dto));
    }

    @Transactional
    public void deletarProfissional(Long id) {
        if (!profissionalRepository.existsById(id)) {
            throw new EntityNotFoundException("Profissional não encontrado");
        }
        profissionalRepository.deleteById(id);
    }

    public Page<ProfissionalListagemDto> listarProfissionais(Pageable paginacao) {
        return profissionalRepository.findAll(paginacao).
                map(ProfissionalListagemDto::new);

    }

    @Transactional
    public void atualizarProfissional(Long id, ProfissionalDto dto) {
        Profissional profissional = profissionalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profissional não encontrado"));
        profissional.setNome(dto.nome());
        profissional.setEspecialidade(dto.especialidade());
        profissional.setCrm(dto.crm());
        profissional.setEmail(dto.email());
        profissional.setTelefone(dto.telefone());
        profissional.setAtivo(dto.ativo());
        profissionalRepository.save(profissional);
    }
}
