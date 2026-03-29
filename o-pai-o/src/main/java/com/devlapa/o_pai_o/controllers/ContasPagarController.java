package com.devlapa.o_pai_o.controllers;

import com.devlapa.o_pai_o.domain.contas.ContaPagar;
import com.devlapa.o_pai_o.domain.contas.DadosCadastroContaPagar;
import com.devlapa.o_pai_o.service.ContasPagarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contas")
public class ContasPagarController {

    @Autowired
    private ContasPagarService service;

    @GetMapping
    public List<ContaPagar> listar() {
        return service.listarTodas();
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN', 'GERENTE')")
    public ResponseEntity<ContaPagar> cadastrar(@RequestBody DadosCadastroContaPagar dados) {
        return ResponseEntity.ok(service.salvar(dados));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN', 'GERENTE')")
    public ResponseEntity<ContaPagar> editar(@PathVariable Long id, @RequestBody DadosCadastroContaPagar dados) {
        return ResponseEntity.ok(service.atualizar(id, dados));
    }

    @PatchMapping("/{id}/pagar")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_GERENTE')")
    public ResponseEntity<Void> pagar(@PathVariable Long id) {
        service.marcarComoPaga(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN', 'GERENTE')")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}