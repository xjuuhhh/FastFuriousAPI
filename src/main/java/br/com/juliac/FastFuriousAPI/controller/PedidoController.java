/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.juliac.FastFuriousAPI.controller;

import br.com.juliac.FastFuriousAPI.domain.model.Pedido;
import br.com.juliac.FastFuriousAPI.domain.repository.PedidoRepository;
import br.com.juliac.FastFuriousAPI.domain.service.PedidoService;
import br.com.juliac.FastFuriousAPI.dto.PedidoRequestDTO;
import br.com.juliac.FastFuriousAPI.dto.PedidoResponseDTO;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sesi3dia
 */
@RestController // Define que a classe é um controlador REST
@RequestMapping("/pedidos") // Define a rota principal como http://localhost:8080/pedidos
public class PedidoController {
    
    @Autowired
    private PedidoService service;

    @GetMapping // Método para listar todos os pedidos (Verbo GET)
    public List<PedidoResponseDTO> listar() {
        return service.listarTodos();// O service já devolve a lista bonitinha (DTO)
    }

    @PostMapping // Método para criar um novo pedido (Verbo POST)
    @ResponseStatus(org.springframework.http.HttpStatus.CREATED)
    public PedidoResponseDTO cadastrar(@Valid @RequestBody PedidoRequestDTO dto) {
        return service.salvar(dto); 
    }
    
}
