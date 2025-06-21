package com.projeto.consultaiapi.controller;

import com.projeto.consultaiapi.dto.PagamentoDto;
import com.projeto.consultaiapi.dto.listagem.PagamentoListagemDto;
import com.projeto.consultaiapi.entity.Pagamento;
import com.projeto.consultaiapi.repository.PagamentoRepository;
import com.projeto.consultaiapi.service.PagamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping
    public void registrarPagamento(@RequestBody @Valid PagamentoDto pagamentoDto) {
        pagamentoService.registrarPagamento(pagamentoDto);
    }

    @DeleteMapping("/{id}")
    public void deletarPagamento(@PathVariable Long id) {
        pagamentoService.deletarPagamento(id);
    }

    @GetMapping
    public List<PagamentoListagemDto> listarPagamentos() {
        return pagamentoService.listarPagamentos();
    }

    @PutMapping("/{id}")
    public void atualizarPagamento(@PathVariable Long id, @RequestBody PagamentoDto dto) {
        pagamentoService.atualizarPagamento(id, dto);
    }
}
