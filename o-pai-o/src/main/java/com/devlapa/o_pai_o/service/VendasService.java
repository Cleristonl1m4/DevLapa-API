package com.devlapa.o_pai_o.service;

import com.devlapa.o_pai_o.domain.formasPagamentos.FormasPagamentos;
import com.devlapa.o_pai_o.domain.usuarios.UsuarioResumoDTO;
import com.devlapa.o_pai_o.domain.usuarios.Usuarios;
import com.devlapa.o_pai_o.domain.vendas.Vendas;
import com.devlapa.o_pai_o.domain.vendas.VendasRequestDTO;
import com.devlapa.o_pai_o.domain.vendas.VendasResponseDTO;
import com.devlapa.o_pai_o.mapper.UsuarioMapper;
import com.devlapa.o_pai_o.repositories.FormasPagamentosRopository;
import com.devlapa.o_pai_o.repositories.UsuarioRepository;
import com.devlapa.o_pai_o.repositories.VendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendasService {
    @Autowired
    VendasRepository vendasRepository;
    @Autowired
    FormasPagamentosRopository formasPagamentosRopository;

    public VendasResponseDTO createVenda(VendasRequestDTO body, Usuarios usuarios) {
        FormasPagamentos formasPagamentos = formasPagamentosRopository.findById(body.formasPagamentosId())
                .orElseThrow(()-> new RuntimeException("Forma de pagamento não encontrada"));
        Vendas newVenda = new Vendas();
        Usuarios usuarios1 = new Usuarios();
        usuarios1.setId(usuarios.getId());
        usuarios1.setNome(usuarios.getNome());
        usuarios1.setLogin(usuarios.getLogin());
        usuarios1.setPerfil(usuarios.getPerfil());
        usuarios1.setAtivo(usuarios.getAtivo());
        usuarios1.setDataCadastro(usuarios.getDataCadastro());
        newVenda.setFormasPagamentos(formasPagamentos);
        newVenda.setStatus(body.statusVenda());
        newVenda.setValor_total(body.valor_total());
        newVenda.setUsuarioCriacao(usuarios1);
        newVenda.PrePersist();

        Vendas vendasSalva = vendasRepository.save(newVenda);


        return new VendasResponseDTO(
                vendasSalva.getId(),
                vendasSalva.getFormasPagamentos(),
                vendasSalva.getValor_total(),
                vendasSalva.getStatus(),
                vendasSalva.getData_criacao(),
                UsuarioMapper.toDTO(vendasSalva.getUsuarioCriacao())
        );
    }

    public List<VendasResponseDTO> getVendas(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Vendas> vendasPage =this.vendasRepository.findAll(pageable);
        return vendasPage.map(event ->{

            return new VendasResponseDTO(
                    event.getId(),
                    event.getFormasPagamentos(),
                    event.getValor_total(),
                    event.getStatus(),
                    event.getData_criacao(),
                    UsuarioMapper.toDTO(event.getUsuarioCriacao())
            );
        }).toList();

    }

    public VendasResponseDTO getVendaById(Long id) {
        Vendas vendas = vendasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException ("Venda não encontrada!"));
        return new VendasResponseDTO(
                vendas.getId(),
                vendas.getFormasPagamentos(),
                vendas.getValor_total(),
                vendas.getStatus(),
                vendas.getData_criacao(),
                UsuarioMapper.toDTO(vendas.getUsuarioCriacao())
        );
    }
}
