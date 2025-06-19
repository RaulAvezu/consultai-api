package com.projeto.consultaiapi.repository;

import com.projeto.consultaiapi.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    // Aqui você pode adicionar métodos personalizados, se necessário
    // Por exemplo, encontrar consultas por status ou por paciente
}
