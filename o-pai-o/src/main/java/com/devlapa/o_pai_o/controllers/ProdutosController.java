package com.devlapa.o_pai_o.controllers;

import com.devlapa.o_pai_o.domain.categorias.Categorias;
import com.devlapa.o_pai_o.domain.produtos.Produtos;
import com.devlapa.o_pai_o.domain.produtos.ProdutosRequestDTO;
import com.devlapa.o_pai_o.domain.produtos.ProdutosResponseDTO;
import com.devlapa.o_pai_o.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produtos> create(@RequestBody @Validated ProdutosRequestDTO body){
            Produtos newProduto = this.produtoService.createproduto(body);
            return ResponseEntity.ok(newProduto);
    }

    @GetMapping
    public ResponseEntity<List<ProdutosResponseDTO>> getProdutosList(@RequestParam(defaultValue = "0") int page, @RequestParam (defaultValue = "10") int size){
        List<ProdutosResponseDTO> allProdutos = this.produtoService.getProdutos(page,size);
        return ResponseEntity.ok(allProdutos);
    }

}
