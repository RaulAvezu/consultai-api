package com.projeto.consultaiapi.repository;

import com.projeto.consultaiapi.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    // Aqui você pode adicionar métodos personalizados, se necessário
    // Por exemplo, encontrar pagamentos por status ou por paciente
}
