package com.devlapa.o_pai_o.service;

import com.devlapa.o_pai_o.domain.fornecedores.Fornecedores;
import com.devlapa.o_pai_o.domain.fornecedores.FornecedoresRequestDTO;
import com.devlapa.o_pai_o.repositories.FornecedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class FornecedoresServices {

    @Autowired
    FornecedoresRepository fornecedores;

    public Fornecedores createFornecedores(FornecedoresRequestDTO data){
        Fornecedores newFornecedores = new Fornecedores();

        newFornecedores.setNome(data.nome());
        newFornecedores.setCnpj(data.cnpj());
        newFornecedores.setTelefone(data.telefone());
        newFornecedores.setEmail(data.email());
        newFornecedores.setEndereco(data.endereco());
        newFornecedores.PrePersist();
        fornecedores.save(newFornecedores);
        return newFornecedores;

    }


}
