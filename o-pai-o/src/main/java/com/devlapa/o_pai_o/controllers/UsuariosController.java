package com.devlapa.o_pai_o.controllers;

import com.devlapa.o_pai_o.domain.usuarios.Usuarios;
import com.devlapa.o_pai_o.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<String> getusuarios (){
        return ResponseEntity.ok("Usuario Logado");
    }


    @PostMapping
    public ResponseEntity<Usuarios> cadastrar(@RequestBody Usuarios usuario) {
        usuarioRepository.save(usuario);
        return ResponseEntity.ok(usuario);
    }

}
