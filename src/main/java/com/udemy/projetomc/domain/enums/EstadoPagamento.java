package com.udemy.projetomc.domain.enums;

public enum EstadoPagamento {

    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private int cod;
    private String descricao;

    private EstadoPagamento(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static EstadoPagamento toEnum(Integer id) {
        if(id == null)
            return null;

        for (EstadoPagamento estadoPagamento: EstadoPagamento.values()) {
            if(estadoPagamento.getCod() == id)
                return estadoPagamento;
        }

        throw new IllegalArgumentException("Id inválido: "+ id);
    }
}
