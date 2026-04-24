/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.juliac.FastFuriousAPI.domain.repository;

import br.com.juliac.FastFuriousAPI.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author sesi3dia
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
