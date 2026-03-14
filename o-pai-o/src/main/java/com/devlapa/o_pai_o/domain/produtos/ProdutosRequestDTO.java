package com.devlapa.o_pai_o.domain.produtos;

import java.math.BigDecimal;
import java.util.UUID;

public record ProdutosRequestDTO(
    String nome,
    BigDecimal preco,
    String unidade,
    UUID categoriaId
) { }


