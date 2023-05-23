package io.github.cHenrique0.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pedido {

    private int id;
    private Cliente cliente;
    private LocalDate dataPedido;
    private BigDecimal total;

    public Pedido() {
    }

    public Pedido(Cliente cliente, LocalDate dataPedido, BigDecimal total) {
        this.cliente = cliente;
        this.dataPedido = dataPedido;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
