package com.projeto.consultaiapi.controller;

import com.projeto.consultaiapi.dto.ProntuarioDto;
import com.projeto.consultaiapi.entity.Prontuario;
import com.projeto.consultaiapi.repository.ProntuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prontuarios")
public class ProntuarioController {

    @Autowired
    private ProntuarioRepository prontuarioRepository;

    @PostMapping
    public void registrarProntuario(@RequestBody ProntuarioDto prontuarioDto) {
        prontuarioRepository.save(new Prontuario(prontuarioDto));
    }

    @DeleteMapping("/{id}")
    public void deletarProntuario(@PathVariable Long id) {
        prontuarioRepository.deleteById(id);
    }
}
