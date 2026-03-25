package com.devlapa.o_pai_o.controllers;

import com.devlapa.o_pai_o.domain.formasPagamentos.FormasPagamentos;
import com.devlapa.o_pai_o.domain.formasPagamentos.FormasPagamentosRequestDTO;
import com.devlapa.o_pai_o.service.FormasPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/formasdepagamemento")
public class FormasPagamentoController {

    @Autowired
    FormasPagamentoService formasPagamentoService;

    @PostMapping
    public ResponseEntity<FormasPagamentos> create(@RequestBody FormasPagamentosRequestDTO body){
        FormasPagamentos newFormaPagament = this.formasPagamentoService.createFormaPagament(body);
        return ResponseEntity.ok(newFormaPagament);
    }
}
