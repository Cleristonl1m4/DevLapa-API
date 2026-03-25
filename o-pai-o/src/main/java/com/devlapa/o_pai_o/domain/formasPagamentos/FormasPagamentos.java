package com.devlapa.o_pai_o.domain.formasPagamentos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "formas_de_pagamentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FormasPagamentos {
    @Id
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String tipo;

    private boolean permitirParcelamento;

    private boolean ativo;

    private LocalDateTime data_criacao;

    private LocalDateTime data_modificacao;


    public void PrePersist(){
        this.ativo = true;
        this.data_criacao = LocalDateTime.now();
        this.data_modificacao = LocalDateTime.now();
    }
}
