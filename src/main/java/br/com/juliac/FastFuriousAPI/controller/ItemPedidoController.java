/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.juliac.FastFuriousAPI.controller;

import br.com.juliac.FastFuriousAPI.domain.model.ItemPedido;
import br.com.juliac.FastFuriousAPI.domain.repository.ItemPedidoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sesi3dia
 */

@RestController // Transforma a classe em um componente que entende requisições web
@RequestMapping("/itens") // Rota para gerenciar os itens: http://localhost:8080/itens
public class ItemPedidoController {
    @Autowired // Conecta com o repositório de itens do pedido
    private ItemPedidoRepository repository;

    @GetMapping // Quando o usuário faz um GET em /itens, este método responde
    public List<ItemPedido> listar() {
        // Busca todos os itens cadastrados
        return repository.findAll();
    }

    @PostMapping // Quando o usuário faz um POST em /itens com um JSON no Body
    public ItemPedido cadastrar(@RequestBody ItemPedido item) {
        // O JPA salva o item e já faz o vínculo com o ID do Pedido e do Produto que vierem no JSON
        return repository.save(item);
    }
    
}
