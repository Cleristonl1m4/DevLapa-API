package com.devlapa.o_pai_o.controllers;

import com.devlapa.o_pai_o.domain.usuarios.Usuarios;
import com.devlapa.o_pai_o.domain.usuarios.UsuariosResponseDTO;
import com.devlapa.o_pai_o.domain.vendas.Vendas;
import com.devlapa.o_pai_o.domain.vendas.VendasRequestDTO;
import com.devlapa.o_pai_o.domain.vendas.VendasResponseDTO;
import com.devlapa.o_pai_o.repositories.UsuarioRepository;
import com.devlapa.o_pai_o.service.VendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendas")
public class VendasController {

    @Autowired
    VendasService vendasService;
    @Autowired
    UsuarioRepository userRepository;

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','GERENTE')")
    public ResponseEntity<VendasResponseDTO> postVendas(@RequestBody @Validated VendasRequestDTO body, @AuthenticationPrincipal Usuarios usuarios){
        VendasResponseDTO newVenda = this.vendasService.createVenda(body,usuarios);
        return ResponseEntity.ok(newVenda);
    }
}
