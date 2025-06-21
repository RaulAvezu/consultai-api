package com.projeto.consultaiapi.controller;

import com.projeto.consultaiapi.dto.ProntuarioDto;
import com.projeto.consultaiapi.dto.listagem.ProntuarioListagemDto;
import com.projeto.consultaiapi.entity.Prontuario;
import com.projeto.consultaiapi.repository.ProntuarioRepository;
import com.projeto.consultaiapi.service.ProntuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prontuarios")
public class ProntuarioController {

    @Autowired
    private ProntuarioService prontuarioService;

    @PostMapping
    public void registrarProntuario(@RequestBody @Valid ProntuarioDto prontuarioDto) {
        prontuarioService.registrarProntuario(prontuarioDto);
    }

    @DeleteMapping("/{id}")
    public void deletarProntuario(@PathVariable Long id) {
        prontuarioService.deletarProntuario(id);
    }

    @GetMapping
    public List<ProntuarioListagemDto> listarProntuarios() {
        return prontuarioService.listarProntuarios();
    }

    //importante ressaltar que deverá ser feito um DTO só pra atualização, pois assim você pode atualizar apenas os campos que deseja
    @PutMapping("/{id}")
    public void atualizarProntuario(@PathVariable Long id, @RequestBody ProntuarioDto dto) {
        prontuarioService.atualizarProntuario(id, dto);
    }

}
