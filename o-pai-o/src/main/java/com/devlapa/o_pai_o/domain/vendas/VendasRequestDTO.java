package com.devlapa.o_pai_o.domain.vendas;

public record VendasRequestDTO(Long formasPagamentosId, Double valor_total, StatusVenda statusVenda) {
}
