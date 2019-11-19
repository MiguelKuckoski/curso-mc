package com.udemy.projetomc.domain.enums;

public enum TipoCliente {

    PESSOAFISICA(1, "Pessoa Física"),
    PESSOAJURIDICA(2, "Pessoa Jurífica");


    private final int cod;
    private final String descricao;

    TipoCliente(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoCliente toEnum(Integer id) {
        if(id == null)
            return null;

        for (TipoCliente tipoCliente: TipoCliente.values()) {
                if(tipoCliente.getCod() == id)
                    return tipoCliente;
        }

        throw new IllegalArgumentException("Id inválido: "+ id);
    }
}
