package com.projeto.consultaiapi.controller;

import com.projeto.consultaiapi.dto.ProfissionalDto;
import com.projeto.consultaiapi.entity.Profissional;
import com.projeto.consultaiapi.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @PostMapping
    public void cadastrarProfissional(@RequestBody ProfissionalDto profissionalDto) {
        profissionalRepository.save(new Profissional(profissionalDto));
    }

    @DeleteMapping("/{id}")
    public void deletarProfissional(@PathVariable Long id) {
        profissionalRepository.deleteById(id);
    }
}
