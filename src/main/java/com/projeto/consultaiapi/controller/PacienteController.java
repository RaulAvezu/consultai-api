package com.projeto.consultaiapi.controller;

import com.projeto.consultaiapi.dto.PacienteDto;
import com.projeto.consultaiapi.entity.Paciente;
import com.projeto.consultaiapi.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    public void cadastrarPaciente(@RequestBody PacienteDto pacienteDto) {
        pacienteRepository.save(new Paciente(pacienteDto));
    }

    @DeleteMapping("/{id}")
    public void deletarPaciente(@PathVariable Long id) {
        pacienteRepository.deleteById(id);
    }
}
