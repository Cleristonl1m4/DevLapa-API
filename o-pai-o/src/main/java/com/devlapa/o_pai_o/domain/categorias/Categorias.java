package com.devlapa.o_pai_o.domain.categorias;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "categoria")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Categorias {
    @Id
    @GeneratedValue
    private UUID id;

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
