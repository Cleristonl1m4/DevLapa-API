package com.devlapa.o_pai_o.controllers;

import com.devlapa.o_pai_o.domain.estoque.DadosCadastroEstoque;
import com.devlapa.o_pai_o.domain.estoque.DadosDetalhamentoEstoque;
import com.devlapa.o_pai_o.service.EstoqueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService service;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'GERENTE')")
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid DadosCadastroEstoque dados) {
        service.cadastrar(dados);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoEstoque>> listar() {
        var lista = service.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @PatchMapping("/{id}/entrada")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_GERENTE')")
    public ResponseEntity<Void> entrada(@PathVariable Long id, @RequestParam Integer qtd) {
        service.registrarEntrada(id, qtd);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}