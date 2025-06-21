package com.projeto.consultaiapi.controller;

import com.projeto.consultaiapi.dto.listagem.ProfissionalListagemDto;
import com.projeto.consultaiapi.dto.ProfissionalDto;
import com.projeto.consultaiapi.service.ProfissionalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {

    @Autowired
    private ProfissionalService profissionalService;

    @PostMapping
    public void cadastrarProfissional(@RequestBody @Valid ProfissionalDto profissionalDto) {
        profissionalService.cadastrarProfissional(profissionalDto);
    }

    @DeleteMapping("/{id}")
    public void deletarProfissional(@PathVariable Long id) {
        profissionalService.deletarProfissional(id);
    }

    @GetMapping
    public Page<ProfissionalListagemDto> listarProfissionais(Pageable paginacao) {
        return profissionalService.listarProfissionais(paginacao);
    }

    @PutMapping("/{id}")
    public void atualizarProfissional(@PathVariable Long id, @RequestBody ProfissionalDto dto) {
        profissionalService.atualizarProfissional(id, dto);
    }
}
