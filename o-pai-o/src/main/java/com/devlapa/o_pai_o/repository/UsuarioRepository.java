package com.devlapa.o_pai_o.repository;

import com.devlapa.o_pai_o.models.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {

}
