/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.juliac.FastFuriousAPI.domain.service;

import br.com.juliac.FastFuriousAPI.domain.model.Produto;
import br.com.juliac.FastFuriousAPI.domain.repository.ProdutoRepository;
import br.com.juliac.FastFuriousAPI.dto.ProdutoRequestDTO;
import br.com.juliac.FastFuriousAPI.dto.ProdutoResponseDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sesi3dia
 */
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    // Converte o DTO que o usuário mandou para a Entidade e salva
    public ProdutoResponseDTO salvar(ProdutoRequestDTO dto) {
        Produto produto = new Produto();
        produto.setNome(dto.nome());
        produto.setDescricao(dto.descricao());
        produto.setPreco(dto.preco());
        produto.setCategoria(dto.categoria());

        Produto salvo = repository.save(produto);

        // Retorna a resposta formatada usando o construtor que criamos no Record
        return new ProdutoResponseDTO(salvo);
    }

    // Busca todos e transforma cada um em DTO
    public List<ProdutoResponseDTO> listarTodos() {
        return repository.findAll().stream()
                .map(ProdutoResponseDTO::new)
                .toList();
    }

    // UPDATE: Atualiza os dados de um produto existente
public ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO dto) {
    Produto produto = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    
    produto.setNome(dto.nome());
    produto.setDescricao(dto.descricao());
    produto.setPreco(dto.preco());
    produto.setCategoria(dto.categoria());
    
    return new ProdutoResponseDTO(repository.save(produto));
}

// DELETE: Exclui o produto do banco
public void excluir(Long id) {
    if (!repository.existsById(id)) {
        throw new RuntimeException("Produto não encontrado");
    }
    repository.deleteById(id);
}

}
