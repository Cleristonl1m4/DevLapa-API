package com.devlapa.o_pai_o.domain.vendas;

import com.devlapa.o_pai_o.domain.formasPagamentos.FormasPagamentos;
import com.devlapa.o_pai_o.domain.usuarios.Usuarios;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "vendas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "formadepagamento_id",nullable = false)
    private FormasPagamentos formasPagamentos;

    @Column(nullable = false)
    private Double valor_total;

    @Enumerated(EnumType.STRING)
    private StatusVenda status = StatusVenda.ABERTA;

    private LocalDateTime data_criacao;

    @ManyToOne
    @JoinColumn(name = "usuario_id",nullable = false)
    private Usuarios usuarioCriacao;

    @PrePersist
    public void PrePersist(){
        this.data_criacao = LocalDateTime.now();
    }

}