package com.udemy.projetomc.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.udemy.projetomc.domain.enums.EstadoPagamento;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PagamentoComBoleto extends Pagamento {
    private static final long serialVersionUID = 1L;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dataVencimento;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dataPagmamento;

    public PagamentoComBoleto() {
    }

    public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagmamento) {
        super(id, estado, pedido);
        this.dataVencimento = dataVencimento;
        this.dataPagmamento = dataPagmamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagmamento() {
        return dataPagmamento;
    }

    public void setDataPagmamento(Date dataPagmamento) {
        this.dataPagmamento = dataPagmamento;
    }
}
