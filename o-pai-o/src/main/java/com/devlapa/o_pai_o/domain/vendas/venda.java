package com.devlapa.o_pai_o.domain.vendas;

import com.devlapa.o_pai_o.domain.formasPagamentos.FormasPagamentos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "vendas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "formas_pagamentos_id",nullable = false)
    private FormasPagamentos formasPagamentos;

    @Column(nullable = false)
    private Double valor_total;

    @Enumerated(EnumType.STRING)
    private StatusVenda status = StatusVenda.ABERTA;


}