package com.devlapa.o_pai_o.repositories;

import com.devlapa.o_pai_o.domain.usuarios.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {

}
