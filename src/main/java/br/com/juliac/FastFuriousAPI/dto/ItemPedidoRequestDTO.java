/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package br.com.juliac.FastFuriousAPI.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;



/**
 *
 * @author sesi3dia
 */

// Este DTO representa cada linha do pedido que o cliente está montando
public record ItemPedidoRequestDTO(
        @NotNull(message="Obrigatória")
        Long produtoId, 
        
        @NotNull(message="Obrigatória")
        @Positive(message="qtd deve ser maior que zero") 
        Double qtd, 
        
        String obs) {


}