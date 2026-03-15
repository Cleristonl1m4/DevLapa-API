package com.devlapa.o_pai_o.domain.categorias;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "categorias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Categorias {
    @Id
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    private LocalDateTime data_criacao;

    @PrePersist
    public void PrePersist(){
        data_criacao = LocalDateTime.now();
    }

}
