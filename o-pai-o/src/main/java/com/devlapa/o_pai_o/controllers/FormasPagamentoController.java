package com.devlapa.o_pai_o.controllers;

import com.devlapa.o_pai_o.domain.formasPagamentos.FormasPagamentoResponseDTO;
import com.devlapa.o_pai_o.domain.formasPagamentos.FormasPagamentos;
import com.devlapa.o_pai_o.domain.formasPagamentos.FormasPagamentosRequestDTO;
import com.devlapa.o_pai_o.service.FormasPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formasdepagamemento")
public class FormasPagamentoController {

    @Autowired
    FormasPagamentoService formasPagamentoService;

    @PostMapping
    public ResponseEntity<FormasPagamentos> create(@RequestBody FormasPagamentosRequestDTO body){
        FormasPagamentos newFormaPagament = this.formasPagamentoService.createFormaPagament(body);
        return ResponseEntity.ok(newFormaPagament);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        formasPagamentoService.deleteFormaDePagamento(id);
        return ResponseEntity.ok("Forma de Pagamento deletada!");
    }
    @GetMapping
    public ResponseEntity<List<FormasPagamentoResponseDTO>> getFormasDePagamento(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        List<FormasPagamentoResponseDTO> allFormasDePagamento = this.formasPagamentoService.getFormasDePagamento(page,size);
        return ResponseEntity.ok(allFormasDePagamento);
    }

}
