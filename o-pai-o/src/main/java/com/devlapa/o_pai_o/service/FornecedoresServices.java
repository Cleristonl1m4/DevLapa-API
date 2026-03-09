package com.devlapa.o_pai_o.service;

import com.devlapa.o_pai_o.domain.fornecedores.Fornecedores;
import com.devlapa.o_pai_o.domain.fornecedores.FornecedoresRequestDTO;
import com.devlapa.o_pai_o.domain.fornecedores.FornecedoresResponseDTO;
import com.devlapa.o_pai_o.repositories.FornecedoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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


    public List<FornecedoresResponseDTO> getFornecedores(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<Fornecedores> fornecedoresPage = this.fornecedores.findAll(pageable);
        return fornecedoresPage.map(event -> new FornecedoresResponseDTO(event.getId(), event.getNome(),
                event.getCnpj(),event.getTelefone(), event.getEmail(), event.getEndereco(), event.isAtivo(),
                event.getData_cadrastro()))
                .stream().toList();
    }
}
