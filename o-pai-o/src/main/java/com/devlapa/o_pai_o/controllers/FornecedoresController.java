package com.devlapa.o_pai_o.controllers;

import com.devlapa.o_pai_o.domain.fornecedores.Fornecedores;
import com.devlapa.o_pai_o.domain.fornecedores.FornecedoresRequestDTO;
import com.devlapa.o_pai_o.domain.fornecedores.FornecedoresResponseDTO;
import com.devlapa.o_pai_o.service.FornecedoresServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fornecedor")
public class FornecedoresController {

    @Autowired
    private FornecedoresServices fornecedoresServices;

    @PostMapping
    public ResponseEntity<Fornecedores> create(@RequestBody FornecedoresRequestDTO body){
        Fornecedores newFornecedor = this.fornecedoresServices.createFornecedores(body);
        return ResponseEntity.ok(newFornecedor);
    }

    @GetMapping
    public ResponseEntity<List<FornecedoresResponseDTO>> getFornecedores(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size){
        List<FornecedoresResponseDTO> allFornecedores = this.fornecedoresServices.getFornecedores(page,size);
        return ResponseEntity.ok(allFornecedores);
    }



}
