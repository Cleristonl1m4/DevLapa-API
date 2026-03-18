package com.devlapa.o_pai_o.service;

import com.devlapa.o_pai_o.domain.contas.ContaPagar;
import com.devlapa.o_pai_o.domain.contas.DadosCadastroContaPagar;
import com.devlapa.o_pai_o.repositories.ContasPagarRepository;
import com.devlapa.o_pai_o.repositories.FornecedoresRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContasPagarService {

    @Autowired
    private ContasPagarRepository contasPagarRepository;

    @Autowired
    private FornecedoresRepository fornecedoresRepository;

    @Transactional
    public ContaPagar cadastrar(DadosCadastroContaPagar dados) {
        var fornecedor = fornecedoresRepository.findById(dados.fornecedorId())
                .orElseThrow(() -> new RuntimeException("Forncedor não encontrado"));

        var conta = new ContaPagar();
        conta.setFornecedor(fornecedor);
        conta.setDescricao(dados.descricao());
        conta.setValor(dados.valor());
        conta.setDataVencimento(dados.dataVencimento());
        conta.setCategoria(dados.categoria());

        return contasPagarRepository.save(conta);

    }
}
