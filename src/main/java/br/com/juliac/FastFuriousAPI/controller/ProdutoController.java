/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.juliac.FastFuriousAPI.controller;

import br.com.juliac.FastFuriousAPI.domain.model.Produto;
import br.com.juliac.FastFuriousAPI.domain.repository.ProdutoRepository;
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
@RestController //Avisa ao Spring que essa classe responde requisições HTTP.
@RequestMapping("/produtos") //Endereço , Define que toda vez que alguém digitar /produtos, o código virá para cá.
public class ProdutoController {
    
    @Autowired //É a "Injeção de Dependência". O Spring entrega o Repository pronto para o Controller usar, sem você precisar dar new
    private ProdutoRepository repository;
    
    @GetMapping //Diz que, se alguém fizer uma busca (GET), ele deve retornar a lista de todos os produtos do banco
    public List <Produto> listar() {
        return repository.findAll();
    }
    
    
    @PostMapping //Define que este método será acionado quando alguém enviar dados para /produtos
    public Produto cadastrar(@RequestBody Produto produto) { //Diz ao Spring para pegar o JSON que vier do Postman e transformar em um objeto Produto
        return repository.save(produto); //repository.save: Comando do JpaRepository que insere o novo registro no banco de dados
    }
}
