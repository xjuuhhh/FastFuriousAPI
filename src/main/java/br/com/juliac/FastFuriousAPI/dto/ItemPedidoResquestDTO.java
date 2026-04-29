/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package br.com.juliac.FastFuriousAPI.dto;

/**
 *
 * @author sesi3dia
 */
// Este DTO representa cada linha do pedido que o cliente está montando
public record ItemPedidoResquestDTO(
        Long produtoId, 
        Double qtd, 
        String obs) {


}
