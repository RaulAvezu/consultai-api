package com.projeto.consultaiapi.repository;

import com.projeto.consultaiapi.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
