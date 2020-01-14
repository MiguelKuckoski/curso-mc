package com.udemy.projetomc.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamento;

    @ManyToOne
    @JoinColumn(name = "endereco_de_entrega_id")
    private Endereco enderecoEntrega;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> itemPedido = new HashSet<>();

    public Pedido() {
    }

    public Pedido(Integer id, Date date, Cliente cliente, Endereco enderecoEntrega) {
        this.id = id;
        this.date = date;
        this.cliente = cliente;
        this.enderecoEntrega = enderecoEntrega;
    }

    public List<Pedido> getPedidos() {
        List<Pedido> pedidoList = new ArrayList<>();
        for (ItemPedido itemPedido: itemPedido) {
            pedidoList.add(itemPedido.getPedido());
        }
        return pedidoList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Set<ItemPedido> getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(Set<ItemPedido> itemPedido) {
        this.itemPedido = itemPedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pedido)) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(getId(), pedido.getId());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


}
