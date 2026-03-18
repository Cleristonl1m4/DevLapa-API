package com.devlapa.o_pai_o.domain.contas;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosCadastroContaPagar(
        Long fornecedorId,
        String descricao,
        BigDecimal valor,
        LocalDate dataVencimento,
        String categoria
) { }
