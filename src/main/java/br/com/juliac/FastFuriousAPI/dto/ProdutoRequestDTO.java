/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package br.com.juliac.FastFuriousAPI.dto;

import br.com.juliac.FastFuriousAPI.domain.model.CategoriaProduto;

/**
 *
 * @author sesi3dia
 */
//O que o usuário envia para cadastrar
public record ProdutoRequestDTO(
    String nome, 
    String descricao, 
    Double preco, 
    CategoriaProduto categoria    ) {

}
