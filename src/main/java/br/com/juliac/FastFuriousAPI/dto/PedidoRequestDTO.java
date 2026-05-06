/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package br.com.juliac.FastFuriousAPI.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

/**
 *
 * @author sesi3dia
 */
public record PedidoRequestDTO(
        @NotBlank(message="Obrigatório")
        String cpf,
        
        @NotBlank(message="Obrigatório")
        String cliente,
        
        @NotEmpty(message="Deve ter pelo menos um item")
        List<ItemPedidoRequestDTO> itens // Uma lista de itens com suas quantidades
        ) {

}
