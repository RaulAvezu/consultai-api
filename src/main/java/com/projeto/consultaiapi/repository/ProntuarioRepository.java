package com.projeto.consultaiapi.repository;

import com.projeto.consultaiapi.entity.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProntuarioRepository extends JpaRepository<Prontuario, Long> {

    // Aqui você pode adicionar métodos personalizados, se necessário
    // Por exemplo, encontrar prontuários por paciente ou por profissional
}
