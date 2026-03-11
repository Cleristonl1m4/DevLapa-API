package com.devlapa.o_pai_o.service;

import com.devlapa.o_pai_o.domain.usuarios.Usuarios;
import com.devlapa.o_pai_o.domain.usuarios.UsuariosRequestDTO;
import com.devlapa.o_pai_o.domain.usuarios.UsuariosResponseDTO;
import com.devlapa.o_pai_o.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuariosResponseDTO> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(u -> new UsuariosResponseDTO(
                        u.getId(), u.getNome(), u.getLogin(),
                        u.getPerfil(), u.getAtivo(), u.getDataCadastro()
                ))
                .toList();
    }

    public UsuariosResponseDTO salvar(UsuariosRequestDTO dto) {
        Usuarios usuario = new Usuarios();
        usuario.setNome(dto.nome());
        usuario.setLogin(dto.login());
        usuario.setHash(dto.senha());
        Usuarios salvo = usuarioRepository.save(usuario);
        return new UsuariosResponseDTO(
                salvo.getId(), salvo.getNome(), salvo.getLogin(),
                salvo.getPerfil(), salvo.getAtivo(), salvo.getDataCadastro()
        );
    }

    public UsuariosResponseDTO atualizar(Long id, UsuariosRequestDTO dto) {
        Usuarios usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usuario.setNome(dto.nome());
        usuario.setLogin(dto.login());
        usuario.setHash(dto.senha());
        usuario.setDataModificacao(LocalDateTime.now());
        Usuarios atualizado = usuarioRepository.save(usuario);
        return new UsuariosResponseDTO(
                atualizado.getId(), atualizado.getNome(), atualizado.getLogin(),
                atualizado.getPerfil(), atualizado.getAtivo(), atualizado.getDataCadastro()
        );
    }

    public void inativar(Long id) {
        Usuarios usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usuario.setAtivo(false);
        usuario.setDataModificacao(LocalDateTime.now());
        usuarioRepository.save(usuario);
    }
}