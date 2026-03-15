package com.devlapa.o_pai_o.domain.produtos;

import com.devlapa.o_pai_o.domain.fornecedores.Fornecedores;

import java.math.BigDecimal;
import java.util.List;

public record ProdutosRequestDTO(
    String nome,
    BigDecimal preco,
    String unidade,
    Long categoriaId,
    Long fornecedoresId
) { }


