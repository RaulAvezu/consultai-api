package com.projeto.consultaiapi.service;

import com.projeto.consultaiapi.dto.PagamentoDto;
import com.projeto.consultaiapi.dto.listagem.PagamentoListagemDto;
import com.projeto.consultaiapi.entity.Consulta;
import com.projeto.consultaiapi.entity.Pagamento;
import com.projeto.consultaiapi.entity.StatusConsulta;
import com.projeto.consultaiapi.entity.StatusPagamento;
import com.projeto.consultaiapi.repository.ConsultaRepository;
import com.projeto.consultaiapi.repository.PagamentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ConsultaRepository consultaRepository;


    @Transactional
    public void registrarPagamento(PagamentoDto dto) {
        var consulta = consultaRepository.findById(dto.consultaId())
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));

        pagamentoRepository.save(new Pagamento(dto, consulta));
    }

    @Transactional
    public void deletarPagamento(Long id) {
        if (!pagamentoRepository.existsById(id)) {
            throw new RuntimeException("Pagamento não encontrado");
        }
        pagamentoRepository.deleteById(id);
    }

    public List<PagamentoListagemDto> listarPagamentos() {
        return pagamentoRepository.findAll()
                .stream()
                .map(PagamentoListagemDto::new)
                .toList();
    }

    @Transactional
    public void atualizarPagamento(Long id, PagamentoDto dto) {
        Pagamento pagamento = pagamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));

        pagamento.setValor(dto.valor());
        pagamento.setStatus(StatusPagamento.valueOf(dto.status().toUpperCase()));
        pagamento.setDataPagamento(dto.dataPagamento());

        // Buscar a Consulta no banco e associar
        Consulta consulta = consultaRepository.findById(dto.consultaId())
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));

        pagamento.setConsulta(consulta);

        pagamentoRepository.save(pagamento);
    }

}
