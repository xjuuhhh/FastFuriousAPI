/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.juliac.FastFuriousAPI.domain.service;

import br.com.juliac.FastFuriousAPI.domain.model.ItemPedido;
import br.com.juliac.FastFuriousAPI.domain.model.Pedido;
import br.com.juliac.FastFuriousAPI.domain.model.Produto;
import br.com.juliac.FastFuriousAPI.domain.model.StatusPedido;
import br.com.juliac.FastFuriousAPI.domain.repository.PedidoRepository;
import br.com.juliac.FastFuriousAPI.domain.repository.ProdutoRepository;
import br.com.juliac.FastFuriousAPI.dto.ItemPedidoResponseDTO;
import br.com.juliac.FastFuriousAPI.dto.PedidoRequestDTO;
import br.com.juliac.FastFuriousAPI.dto.PedidoResponseDTO;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sesi3dia
 */
@Service // Avisa ao Spring que esta é a classe de lógica de negócio
public class PedidoService {
    
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    // Método para Salvar o Pedido (Resolve os NULLs do seu teste!)
    public PedidoResponseDTO salvar(PedidoRequestDTO dto) {
        Pedido pedido = new Pedido();
        pedido.setCliente(dto.cliente());
        pedido.setCpf(dto.cpf());
        pedido.setStatus(StatusPedido.RECEBIDO); // Define o status inicial (não é mais null!)
        pedido.setDtAberto(LocalDateTime.now()); // Define a data atual (não é mais null!)

        // Transforma os itens do DTO em entidades ItemPedido
        List<ItemPedido> itens = dto.itens().stream().map(itemDto -> {
            ItemPedido item = new ItemPedido();
            // Busca o produto no banco para saber o preço real (Segurança!)
            Produto p = produtoRepository.findById(itemDto.produtoId())
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
            
            item.setProduto(p);
            item.setQtd(itemDto.qtd());
            item.setObs(itemDto.obs());
            item.setVunit(p.getPreco()); // Copia o preço do produto para o item
            item.setPedido(pedido); // Faz o vínculo bidirecional
            return item;
        }).toList();

        pedido.setItens(itens);
        Pedido pedidoSalvo = pedidoRepository.save(pedido);

        // Retorna o DTO de resposta para o Controller
        return transformarParaDTO(pedidoSalvo);
    }

    // Método para Listar (Resolve o [] vazio do seu teste!)
    public List<PedidoResponseDTO> listarTodos() {
        return pedidoRepository.findAll().stream()
                .map(this::transformarParaDTO)
                .toList();
    }

    // Função auxiliar para converter Entidade em DTO
    private PedidoResponseDTO transformarParaDTO(Pedido p) {
        List<ItemPedidoResponseDTO> itensDTO = p.getItens().stream()
                .map(i -> new ItemPedidoResponseDTO(
                        i.getProduto().getNome(),
                        i.getQtd(),
                        i.getVunit(),
                        i.getVtotal()
                )).toList();

        return new PedidoResponseDTO(p.getId(), p.getCliente(), p.getStatus(), itensDTO);
    }
    
    public void cancelar(Long id) {
    Pedido pedido = pedidoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    
    // Altera o status em vez de apagar
    pedido.setStatus(StatusPedido.CANCELADO); 
    pedidoRepository.save(pedido);
}
    
}
