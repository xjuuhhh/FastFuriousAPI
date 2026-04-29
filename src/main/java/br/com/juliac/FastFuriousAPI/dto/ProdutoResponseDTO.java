/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package br.com.juliac.FastFuriousAPI.dto;

import br.com.juliac.FastFuriousAPI.domain.model.CategoriaProduto;
import br.com.juliac.FastFuriousAPI.domain.model.Produto;

/**
 *
 * @author sesi3dia
 */
//O que a API devolve para o usuário
public record ProdutoResponseDTO(
        Long id,
        String nome,
        Double preco,
        CategoriaProduto categoria) {
    // Esse construtor serve para transformar um Produto (Entidade) em um ResponseDTO rapidinho
    public ProdutoResponseDTO(Produto produto) {
        this(produto.getId(), produto.getNome(), produto.getPreco(), produto.getCategoria());
    }

}
