package com.devlapa.o_pai_o.domain.fornecedores;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.crypto.Data;
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
    private String nome;
    private String cnpj;
    private String telefone;
    private String email;
    private String endereco;
    private boolean ativo;
    private Data data_cadrastro;
}
