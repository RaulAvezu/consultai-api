package com.projeto.consultaiapi.service;

import com.projeto.consultaiapi.dto.PacienteDto;
import com.projeto.consultaiapi.dto.listagem.PacienteListagemDto;
import com.projeto.consultaiapi.entity.Paciente;
import com.projeto.consultaiapi.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Transactional
    public void cadastrarPaciente(PacienteDto dto) {
        pacienteRepository.save(new Paciente(dto));
    }

    @Transactional
    public void deletarPaciente(Long id) {
        if (!pacienteRepository.existsById(id)) {
            throw new RuntimeException("Paciente não encontrado");
        }
        pacienteRepository.deleteById(id);
    }

    public List<PacienteListagemDto> listarPacientes() {
        return pacienteRepository.findAll()
                .stream()
                .map(PacienteListagemDto::new)
                .toList();
    }

    @Transactional
    public void atualizarPaciente(Long id, PacienteDto dto) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        paciente.setNome(dto.nome());
        paciente.setTelefone(dto.telefone());
        paciente.setEmail(dto.email());
        paciente.setAtivo(dto.ativo());
        pacienteRepository.save(paciente);
    }
}
