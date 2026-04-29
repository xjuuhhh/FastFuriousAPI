/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.juliac.FastFuriousAPI.domain.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sesi3dia
 */
@Entity
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;
    private String cliente;

    // Aqui usaremos outro Enum: StatusPedido
    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    private LocalDateTime dtAberto;
    private LocalDateTime dtPronto;
    private LocalDateTime dtEntregue;
    
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedido> itens = new ArrayList<>();


    public Pedido() {
    }

    public Pedido(Long id, String cpf, String cliente, StatusPedido status, LocalDateTime dtAberto, LocalDateTime dtPronto, LocalDateTime dtEntregue) {
        this.id = id;
        this.cpf = cpf;
        this.cliente = cliente;
        this.status = status;
        this.dtAberto = dtAberto;
        this.dtPronto = dtPronto;
        this.dtEntregue = dtEntregue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public LocalDateTime getDtAberto() {
        return dtAberto;
    }

    public void setDtAberto(LocalDateTime dtAberto) {
        this.dtAberto = dtAberto;
    }

    public LocalDateTime getDtPronto() {
        return dtPronto;
    }

    public void setDtPronto(LocalDateTime dtPronto) {
        this.dtPronto = dtPronto;
    }

    public LocalDateTime getDtEntregue() {
        return dtEntregue;
    }

    public void setDtEntregue(LocalDateTime dtEntregue) {
        this.dtEntregue = dtEntregue;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
    
    @Override
    // equals: Compara se dois pedidos são iguais apenas pelo ID, o que é o padrão ouro para banco de dados.
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return java.util.Objects.equals(id, pedido.id);
    }

    @Override
    // hashCode: Gera um código único para o objeto baseado no ID, ajudando na performance de listas.
    public int hashCode() {
        return java.util.Objects.hash(id);
    }

}
