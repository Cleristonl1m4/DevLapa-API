package com.devlapa.o_pai_o.domain.vendas;

import com.devlapa.o_pai_o.domain.formasPagamentos.FormasPagamentos;
import com.devlapa.o_pai_o.domain.usuarios.UsuarioResumoDTO;
import com.devlapa.o_pai_o.domain.usuarios.Usuarios;

import java.time.LocalDateTime;

public record VendasResponseDTO(Long id, FormasPagamentos formasPagamento, Double valor_total, StatusVenda statusVenda, LocalDateTime data_criacao, UsuarioResumoDTO usuarioCriacao) {
}
