package com.devlapa.o_pai_o.service;

import com.devlapa.o_pai_o.domain.formasPagamentos.FormasPagamentos;
import com.devlapa.o_pai_o.domain.formasPagamentos.FormasPagamentosRequestDTO;
import com.devlapa.o_pai_o.repositories.FormasPagamentosRopository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormasPagamentoService {

    @Autowired
    FormasPagamentosRopository formasPagamentosRopository;
    @Autowired
    GeradordeIdServices geradordeIdServices;

    public FormasPagamentos createFormaPagament(FormasPagamentosRequestDTO body){
        FormasPagamentos newFormaPagamento = new FormasPagamentos();
        newFormaPagamento.setId(geradordeIdServices.geradorDeId(formasPagamentosRopository));
        newFormaPagamento.setNome(body.nome());
        newFormaPagamento.setDescricao(body.descricao());
        newFormaPagamento.setTipo(body.tipo());
        newFormaPagamento.PrePersist();
        formasPagamentosRopository.save(newFormaPagamento);
        return newFormaPagamento;
    }
}
