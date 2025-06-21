package com.projeto.consultaiapi.controller;

import com.projeto.consultaiapi.dto.ConsultaDto;
import com.projeto.consultaiapi.dto.listagem.ConsultaListagemDto;
import com.projeto.consultaiapi.entity.Consulta;
import com.projeto.consultaiapi.repository.ConsultaRepository;
import com.projeto.consultaiapi.service.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public void agendarConsulta(@RequestBody @Valid ConsultaDto consultaDto) {
        consultaService.agendarConsulta(consultaDto);
    }

    @DeleteMapping("/{id}")
    public void deletarConsulta(@PathVariable Long id) {
        consultaService.deletarConsulta(id);
    }

    @GetMapping
    public List<ConsultaListagemDto> listarConsultas() {
        return consultaService.listarConsultas();
    }

    @PutMapping("/{id}")
    public void atualizarConsulta(@PathVariable Long id, @RequestBody ConsultaDto dto) {
        consultaService.atualizarConsulta(id, dto);
    }
}
