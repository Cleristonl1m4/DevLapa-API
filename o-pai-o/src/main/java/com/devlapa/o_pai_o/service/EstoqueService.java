package com.devlapa.o_pai_o.service;

import com.devlapa.o_pai_o.domain.estoque.DadosCadastroEstoque;
import com.devlapa.o_pai_o.domain.estoque.DadosDetalhamentoEstoque;
import com.devlapa.o_pai_o.domain.estoque.Estoque;
import com.devlapa.o_pai_o.domain.estoque.StatusEstoque;
import com.devlapa.o_pai_o.repositories.EstoqueRepository;
import com.devlapa.o_pai_o.repositories.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository repository;

    @Autowired
    private ProdutosRepository produtosRepository;

    @Transactional
    public void cadastrar(DadosCadastroEstoque dados){
        var produto = produtosRepository.getReferenceById(dados.produtoId());


        var estoque = new Estoque(
                null,
                produto,
                dados.quantidade(),
                dados.minimo(),
                StatusEstoque.NORMAL,
                LocalDateTime.now(),
                null
        );

        estoque.verificarStatus();
        repository.save(estoque);
    }

    public List<DadosDetalhamentoEstoque> listarTodos() {
        return repository.findAll().stream()
                .map(DadosDetalhamentoEstoque::new)
                .toList();
    }

    @Transactional
    public void registrarEntrada(Long id, Integer quantidade) {
        var estoque = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro de estoque não encontrado"));

        estoque.setQuantidade(estoque.getQuantidade() + quantidade);
        estoque.verificarStatus();
        repository.save(estoque);
    }

    @Transactional
    public void excluir(Long id) {
        var estoque = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro de estoque não encontrado"));
        repository.delete(estoque);
    }
}