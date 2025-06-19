package com.projeto.consultaiapi.controller;

import com.projeto.consultaiapi.dto.PagamentoDto;
import com.projeto.consultaiapi.entity.Pagamento;
import com.projeto.consultaiapi.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @PostMapping
    public void registrarPagamento(@RequestBody PagamentoDto pagamentoDto) {
        pagamentoRepository.save(new Pagamento(pagamentoDto));
    }

    @DeleteMapping("/{id}")
    public void deletarPagamento(@PathVariable Long id) {
        pagamentoRepository.deleteById(id);
    }
}
