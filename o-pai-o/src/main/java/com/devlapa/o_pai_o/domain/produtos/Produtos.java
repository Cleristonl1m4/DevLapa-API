package com.devlapa.o_pai_o.domain.produtos;

import com.devlapa.o_pai_o.domain.categorias.Categorias;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "produtos")
@Getter
@Setter
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private String unidade;

    @ManyToOne
    @JoinColumn(name = "Categorias_id", nullable = false)
    private Categorias categoria;

    @Column(nullable = false)
    private boolean ativo;

    @Column(nullable = false, updatable = false)
    private LocalDateTime datacriacao;

    @prePersist
    public void prePersist(){
        this.datacriacao = LocalDateTime.now();
        if (this.ativo == null) this.ativo = true;
    }
}
