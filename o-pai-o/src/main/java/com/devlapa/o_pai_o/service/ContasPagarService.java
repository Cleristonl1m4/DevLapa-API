package com.devlapa.o_pai_o.service;

import com.devlapa.o_pai_o.domain.contas.ContaPagar;
import com.devlapa.o_pai_o.domain.contas.DadosCadastroContaPagar;
import com.devlapa.o_pai_o.domain.contas.StatusConta;
import com.devlapa.o_pai_o.domain.fornecedores.Fornecedores;
import com.devlapa.o_pai_o.repositories.ContasPagarRepository;
import com.devlapa.o_pai_o.repositories.FornecedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class ContasPagarService {

    @Autowired
    private ContasPagarRepository repository;

    @Autowired
    private FornecedoresRepository fornecedorRepository;

    public List<ContaPagar> listarTodas() {
        return repository.findAll();
    }

    @Transactional
    public ContaPagar salvar(DadosCadastroContaPagar dados) {
        if (dados.fornecedorId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "fornecedorId e obrigatorio");
        }

        var conta = new ContaPagar();
        conta.setDescricao(dados.descricao());
        conta.setValor(dados.valor());
        conta.setDataVencimento(dados.dataVencimento());
        conta.setCategoria(dados.categoria());
        conta.setFornecedor(buscarFornecedor(dados.fornecedorId()));
        conta.setStatus(StatusConta.PENDENTE);

        return repository.save(conta);
    }

    @Transactional
    public ContaPagar atualizar(Long id, DadosCadastroContaPagar dados) {
        var conta = buscarConta(id);

        conta.setDescricao(dados.descricao());
        conta.setValor(dados.valor());
        conta.setDataVencimento(dados.dataVencimento());
        conta.setCategoria(dados.categoria());

        if (dados.fornecedorId() != null) {
            conta.setFornecedor(buscarFornecedor(dados.fornecedorId()));
        }

        return repository.save(conta);
    }

    @Transactional
    public void marcarComoPaga(Long id) {
        var conta = buscarConta(id);
        conta.setStatus(StatusConta.PAGA);
        conta.setDataPagamento(LocalDate.now());
        repository.save(conta);
    }

    @Transactional
    public void deletar(Long id) {
        repository.delete(buscarConta(id));
    }

    private ContaPagar buscarConta(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta nao encontrada"));
    }

    private Fornecedores buscarFornecedor(Long fornecedorId) {
        return fornecedorRepository.findById(fornecedorId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fornecedor nao encontrado"));
    }
}
