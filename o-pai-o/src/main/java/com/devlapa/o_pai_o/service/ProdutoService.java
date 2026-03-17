package com.devlapa.o_pai_o.service;

import com.devlapa.o_pai_o.domain.categorias.Categorias;
import com.devlapa.o_pai_o.domain.fornecedores.Fornecedores;
import com.devlapa.o_pai_o.domain.produtos.Produtos;
import com.devlapa.o_pai_o.domain.produtos.ProdutosRequestDTO;
import com.devlapa.o_pai_o.domain.produtos.ProdutosResponseDTO;
import com.devlapa.o_pai_o.repositories.CategoriasRepository;
import com.devlapa.o_pai_o.repositories.FornecedoresRepository;
import com.devlapa.o_pai_o.repositories.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutosRepository produtosRepository;

    @Autowired
    CategoriasRepository categoriasRepository;

    @Autowired
    private FornecedoresRepository fornecedoresRepository;

    @Autowired
    GeradordeIdServices geradordeIdServices;


    public Produtos createproduto( ProdutosRequestDTO body) {
        Categorias categorias = categoriasRepository.findById(body.categoriaId())
                .orElseThrow(() -> new RuntimeException ("Categoria não encontrado"));
        Fornecedores fornecedores = fornecedoresRepository.findById(body.fornecedoresId())
                .orElseThrow(() -> new RuntimeException ("Fornecedor não encontrado"));

        Produtos newProdutos = new Produtos();
        newProdutos.setId(geradordeIdServices.geradorDeId(produtosRepository));
        newProdutos.setNome(body.nome());
        newProdutos.setPreco(body.preco());
        newProdutos.setUnidade(body.unidade());
        newProdutos.setFornecedor(fornecedores);
        newProdutos.setCategoria(categorias);
        newProdutos.PrePersist();
        produtosRepository.save(newProdutos);
        return newProdutos;
    }

    public List<ProdutosResponseDTO> getProdutos(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Produtos> produtosPage = this.produtosRepository.findAll(pageable);
        return produtosPage.map(event -> new ProdutosResponseDTO((long)Math.toIntExact(event.getId()), event.getNome(),
                event.getPreco(), event.getUnidade(),event.getCategoria(),event.getFornecedor(),event.getAtivo(), event.getDataCriacao()))
                .stream()
                .toList();
    }

    public void deleteProduto(Long id) {
        Produtos produto = produtosRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Produto não encontrado"));
        produtosRepository.delete(produto);
    }
}
