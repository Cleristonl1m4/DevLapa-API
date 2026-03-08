package com.devlapa.o_pai_o.domain.fornecedores;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "fornecedores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fornecedores {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String nome;

    private String cnpj;

    @Column(nullable = false)
    private String telefone;

    private String email;

    private String endereco;

    private boolean ativo;

    private LocalDateTime data_cadrastro;

    @PrePersist
    public void PrePersist(){
        ativo = true;
        data_cadrastro = LocalDateTime.now();
    }
}
