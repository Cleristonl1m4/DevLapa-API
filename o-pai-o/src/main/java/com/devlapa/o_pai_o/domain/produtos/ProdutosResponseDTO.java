package com.devlapa.o_pai_o.domain.produtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ProdutosResponseDTO(
        UUID id,
        String nome,
        BigDecimal preco,
        String unidade,
        String categoria,
        Boolean ativo,
        LocalDateTime datacricao
) { }
