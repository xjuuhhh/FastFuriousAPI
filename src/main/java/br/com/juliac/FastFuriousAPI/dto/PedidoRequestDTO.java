/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package br.com.juliac.FastFuriousAPI.dto;

import java.util.List;

/**
 *
 * @author sesi3dia
 */
public record PedidoRequestDTO(
        String cpf,
        String cliente,
        List<ItemPedidoRequestDTO> itens // Uma lista de itens com suas quantidades
        ) {

}
