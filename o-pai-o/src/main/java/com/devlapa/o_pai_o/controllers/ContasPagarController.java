package com.devlapa.o_pai_o.controllers;

import com.devlapa.o_pai_o.domain.contas.DadosCadastroContaPagar;
import com.devlapa.o_pai_o.service.ContasPagarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contasPagar")
public class ContasPagarController {

    @Autowired
    private ContasPagarService service;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'GERENTE')")
    public ResponseEntity listar() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity cadastrar(@RequestBody DadosCadastroContaPagar dados){
        var conta = service.cadastrar(dados);
        return ResponseEntity.ok(conta);
    }
}
