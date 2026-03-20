package com.devlapa.o_pai_o.service;

import com.devlapa.o_pai_o.domain.contas.*;
import com.devlapa.o_pai_o.repositories.ContaPagarRepository;
import com.devlapa.o_pai_o.repositories.ContasPagarRepository;
import com.devlapa.o_pai_o.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContasPagarService {

    @Autowired
    private ContasPagarRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<ContaPagar> listarTodas() {
        return repository.findAll();
    }

    @Transactional
    public ContaPagar salvar(DadosCadastroContaPagar dados) {
        var usuario = usuarioRepository.findById(dados.usuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        var conta = new ContaPagar();
        conta.setDescricao(dados.descricao());
        conta.setValor(dados.valor());
        conta.setDataVencimento(dados.dataVencimento());
        conta.setUsuario(usuario);
        conta.setStatus(StatusConta.PENDENTE);

        return repository.save(conta);
    }

    @Transactional
    public ContaPagar atualizar(Long id, DadosCadastroContaPagar dados) {
        var conta = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));

        conta.setDescricao(dados.descricao());
        conta.setValor(dados.valor());
        conta.setDataVencimento(dados.dataVencimento());

        return repository.save(conta);
    }

    @Transactional
    public void marcarComoPaga(Long id) {
        var conta = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
        conta.setStatus(StatusConta.PAGO);
        repository.save(conta);
    }

    @Transactional
    public void deletar(Long id) {
        var conta = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada"));
        repository.delete(conta);
    }
}