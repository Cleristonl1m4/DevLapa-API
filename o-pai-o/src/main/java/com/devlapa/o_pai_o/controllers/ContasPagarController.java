package com.devlapa.o_pai_o.controllers;

import com.devlapa.o_pai_o.domain.contas.DadosCadastroContaPagar;
import com.devlapa.o_pai_o.service.ContasPagarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contasPagar")
public class ContasPagarController {

    @Autowired
    private ContasPagarService service;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody DadosCadastroContaPagar dados){
        var conta = service.cadastrar(dados);
        return ResponseEntity.ok(conta);
    }
}
