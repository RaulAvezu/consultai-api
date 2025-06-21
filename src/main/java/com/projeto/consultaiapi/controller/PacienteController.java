package com.projeto.consultaiapi.controller;

import com.projeto.consultaiapi.dto.PacienteDto;
import com.projeto.consultaiapi.dto.listagem.PacienteListagemDto;
import com.projeto.consultaiapi.entity.Paciente;
import com.projeto.consultaiapi.repository.PacienteRepository;
import com.projeto.consultaiapi.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public void cadastrarPaciente(@RequestBody @Valid PacienteDto pacienteDto) {
        pacienteService.cadastrarPaciente(pacienteDto);
    }

    @DeleteMapping("/{id}")
    public void deletarPaciente(@PathVariable Long id) {
        pacienteService.deletarPaciente(id);
    }

    @GetMapping
    public List<PacienteListagemDto> listarPacientes() {
        return pacienteService.listarPacientes();
    }

    @PutMapping("/{id}")
    public void atualizarPaciente(@PathVariable Long id, @RequestBody PacienteDto dto) {
        pacienteService.atualizarPaciente(id, dto);
    }
}
