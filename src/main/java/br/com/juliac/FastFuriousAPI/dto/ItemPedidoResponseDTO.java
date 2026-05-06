/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package br.com.juliac.FastFuriousAPI.dto;

/**
 *
 * @author sesi3dia
 */
public record ItemPedidoResponseDTO(
        String produtoNome, //Ao invés do id, mostra o nome
        Double qtd,
        Double vunit,
        Double vtotal
        ) {}
        
