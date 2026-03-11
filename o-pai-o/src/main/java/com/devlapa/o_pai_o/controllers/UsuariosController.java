package com.devlapa.o_pai_o.controllers;

import com.devlapa.o_pai_o.domain.usuarios.Usuarios;
import com.devlapa.o_pai_o.repositories.UsuarioRepository;
import com.devlapa.o_pai_o.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuarios")
public class UsuariosController {


    private final UsuarioService usuarioService;

    public UsuariosController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<String> getusuarios (){

        return ResponseEntity.ok("Usuario Logado");
    }


    @PostMapping
    public ResponseEntity<Usuarios> cadastrar(@RequestBody Usuarios usuario) {
        Usuarios novoUsuario = usuarioService.salvar(usuario);
        return ResponseEntity.ok(novoUsuario);
    }

}
