package com.projeto.consultaiapi.controller;

import com.projeto.consultaiapi.dto.ConsultaDto;
import com.projeto.consultaiapi.entity.Consulta;
import com.projeto.consultaiapi.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;

    @PostMapping
    public void agendarConsulta(@RequestBody ConsultaDto consultaDto) {
        consultaRepository.save(new Consulta(consultaDto));
    }

    @DeleteMapping("/{id}")
    public void deletarConsulta(@PathVariable Long id) {
        consultaRepository.deleteById(id);
    }
}
