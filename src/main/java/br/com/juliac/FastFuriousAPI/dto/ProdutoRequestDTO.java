/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package br.com.juliac.FastFuriousAPI.dto;

import br.com.juliac.FastFuriousAPI.domain.model.CategoriaProduto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 *
 * @author sesi3dia
 */
//O que o usuário envia para cadastrar
public record ProdutoRequestDTO(
    @NotBlank(message="Obrigatório")
    String nome, 
        
    @NotBlank(message="Obrigatório")    
    String descricao, 
    
    @NotNull(message="Não pode ser nulo")
    @Positive(message = "Preço deve ser maior que zero")
    Double preco, 
    
    @NotNull(message="Obrigatória")
    CategoriaProduto categoria    ) {

}
