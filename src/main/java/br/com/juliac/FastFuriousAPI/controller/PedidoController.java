/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.juliac.FastFuriousAPI.controller;

import br.com.juliac.FastFuriousAPI.domain.model.Pedido;
import br.com.juliac.FastFuriousAPI.domain.repository.PedidoRepository;
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
@RestController // Define que a classe é um controlador REST
@RequestMapping("/pedidos") // Define a rota principal como http://localhost:8080/pedidos
public class PedidoController {
    
    @Autowired // Injeta o repositório para acessar o banco de dados de Pedidos
    private PedidoRepository repository;

    @GetMapping // Método para listar todos os pedidos (Verbo GET)
    public List<Pedido> listar() {
        return repository.findAll();// Retorna todos os registros da tabela pedido
    }

    @PostMapping // Método para criar um novo pedido (Verbo POST)
    public Pedido cadastrar(@RequestBody Pedido pedido) {
        return repository.save(pedido); // Salva o pedido enviado no corpo da requisição (JSON) no banco
    }
    
}
