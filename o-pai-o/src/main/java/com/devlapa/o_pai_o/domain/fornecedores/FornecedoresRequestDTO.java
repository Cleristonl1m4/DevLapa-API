package com.devlapa.o_pai_o.domain.fornecedores;

import javax.xml.crypto.Data;
import java.util.Date;

public record FornecedoresRequestDTO(
        String nome,
        String cnpj,
        String telefone,
        String email,
        String endereco) {
}
