package com.devlapa.o_pai_o.repositories;

import com.devlapa.o_pai_o.domain.categorias.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface categoriasRepository extends JpaRepository<Categorias, UUID> {
}
