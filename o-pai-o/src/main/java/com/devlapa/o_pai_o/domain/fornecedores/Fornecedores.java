package com.devlapa.o_pai_o.domain.fornecedores;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "fornecedores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fornecedores {
    @Id
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String cnpj;

    @Column(nullable = false)
    private String telefone;

    private String email;

    private String endereco;

    private boolean ativo;

    private LocalDateTime data_cadastro;

    @PrePersist
    public void PrePersist(){
        this.ativo = true;
        this.data_cadastro = LocalDateTime.now();
    }


}
