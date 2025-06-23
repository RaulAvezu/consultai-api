package com.projeto.consultaiapi.service;

import com.projeto.consultaiapi.dto.ConsultaDto;
import com.projeto.consultaiapi.dto.listagem.ConsultaListagemDto;
import com.projeto.consultaiapi.entity.Consulta;
import com.projeto.consultaiapi.entity.Paciente;
import com.projeto.consultaiapi.entity.Profissional;
import com.projeto.consultaiapi.entity.StatusConsulta;
import com.projeto.consultaiapi.repository.ConsultaRepository;
import com.projeto.consultaiapi.repository.PacienteRepository;
import com.projeto.consultaiapi.repository.ProfissionalRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Transactional
    public void agendarConsulta(ConsultaDto dto) {
        if (dto.dataHora() == null || dto.profissionalId() == null || dto.pacienteId() == null) {
            throw new EntityNotFoundException("Dados da consulta inválidos");
        }

        var profissional = profissionalRepository.findById(dto.profissionalId())
                .orElseThrow(() -> new EntityNotFoundException("Profissional não encontrado"));
        var paciente = pacienteRepository.findById(dto.pacienteId())
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));

        consultaRepository.save(new Consulta(dto, profissional, paciente));
    }

    @Transactional
    public void deletarConsulta(Long id) {
        if (!consultaRepository.existsById(id)) {
            throw new EntityNotFoundException("Consulta não encontrada");
        }
        consultaRepository.deleteById(id);
    }

    public List<ConsultaListagemDto> listarConsultas() {
        return consultaRepository.findAll()
                .stream()
                .map(ConsultaListagemDto::new)
                .toList();
    }

    @Transactional
    public void atualizarConsulta(Long id, ConsultaDto dto) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));

        consulta.setDataHora(dto.dataHora());

        consulta.setStatus(StatusConsulta.valueOf(dto.status().toUpperCase()));

        Paciente paciente = pacienteRepository.findById(dto.pacienteId())
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));
        Profissional profissional = profissionalRepository.findById(dto.profissionalId())
                .orElseThrow(() -> new EntityNotFoundException("Profissional não encontrado"));

        consulta.setPaciente(paciente);
        consulta.setProfissional(profissional);

        consultaRepository.save(consulta);
    }

}
