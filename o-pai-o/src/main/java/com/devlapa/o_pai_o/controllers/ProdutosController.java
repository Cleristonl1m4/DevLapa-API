package com.devlapa.o_pai_o.controllers;

import com.devlapa.o_pai_o.domain.produtos.Produtos;
import com.devlapa.o_pai_o.domain.produtos.ProdutosRequestDTO;
import com.devlapa.o_pai_o.domain.produtos.ProdutosResponseDTO;
import com.devlapa.o_pai_o.repositories.ProdutosRepository;
import com.devlapa.o_pai_o.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    ProdutosRepository produtosRepository;

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

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produtos>> getProdutoId(@PathVariable Long id){
         Optional<Produtos> produto = produtosRepository.findById(id);
         return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduto(@PathVariable Long id){
        produtoService.deleteProduto(id);
        return ResponseEntity.ok("Produto deletado com sucesso");
    }

    @PatchMapping("/update/{id}")
    public Produtos updateProduto(@PathVariable Long id,@RequestBody Map<String,Object>fields){
        return produtoService.updateProdutos(id,fields);
    }


}