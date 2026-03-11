package com.devlapa.o_pai_o.service;

import com.devlapa.o_pai_o.domain.usuarios.Usuarios;
import com.devlapa.o_pai_o.repositories.UsuarioRepository;

public class UsuarioService {

    private  final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuarios salvar (Usuarios usuario){
        return usuarioRepository.save(usuario);

    }
}
