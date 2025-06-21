package com.projeto.consultaiapi.service;

import com.projeto.consultaiapi.dto.ProntuarioDto;
import com.projeto.consultaiapi.dto.listagem.ProntuarioListagemDto;
import com.projeto.consultaiapi.entity.Paciente;
import com.projeto.consultaiapi.entity.Profissional;
import com.projeto.consultaiapi.entity.Prontuario;
import com.projeto.consultaiapi.repository.PacienteRepository;
import com.projeto.consultaiapi.repository.ProfissionalRepository;
import com.projeto.consultaiapi.repository.ProntuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProntuarioService {
    @Autowired
    private ProntuarioRepository prontuarioRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Transactional
    public void registrarProntuario(ProntuarioDto dto) {
        var paciente = pacienteRepository.findById(dto.pacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        var profissional = profissionalRepository.findById(dto.profissionalId())
                .orElseThrow(() -> new RuntimeException("Profissional não encontrado"));

        prontuarioRepository.save(new Prontuario(dto, paciente, profissional));
    }

    @Transactional
    public void deletarProntuario(Long id) {
        if (!prontuarioRepository.existsById(id)) {
            throw new RuntimeException("Prontuário não encontrado");
        }

        prontuarioRepository.deleteById(id);
    }

    public List<ProntuarioListagemDto> listarProntuarios() {
        return prontuarioRepository.findAll()
                .stream()
                .map(ProntuarioListagemDto::new)
                .toList();
    }

    @Transactional
    public void atualizarProntuario(Long id, ProntuarioDto dto) {
        Prontuario prontuario = prontuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prontuário não encontrado"));

        prontuario.setDataRegistro(dto.dataRegistro());
        prontuario.setDescricao(dto.descricao());

        // Buscar paciente e profissional no banco
        Paciente paciente = pacienteRepository.findById(dto.pacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        Profissional profissional = profissionalRepository.findById(dto.profissionalId())
                .orElseThrow(() -> new RuntimeException("Profissional não encontrado"));

        prontuario.setPaciente(paciente);
        prontuario.setProfissional(profissional);

        prontuarioRepository.save(prontuario);
    }


}
