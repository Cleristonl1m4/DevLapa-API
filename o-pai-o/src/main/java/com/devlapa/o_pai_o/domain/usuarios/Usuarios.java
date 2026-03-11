package com.devlapa.o_pai_o.domain.usuarios;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private  Long id;

    @Column(nullable = false)
    private String nome;


    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String hash;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCadastro;

    @Column(columnDefinition = "VARCHAR(100) DEFAULT 'USUARIO'")
    private String perfil;

    private LocalDateTime dataModificacao;


    @Column(nullable = false)
    private Boolean ativo;

    @PrePersist
    public void prePersist() {
        this.dataCadastro = LocalDateTime.now();
        if (this.ativo == null) this.ativo = true;
        if (this.perfil == null) this.perfil = "USUARIO";
    }

}
