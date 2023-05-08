package com.posvenda.posvenda.models;



import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Data
@Setter
@Getter
public class Parcelas {

    @JsonProperty("data_calculo")
    private Date dataCalculo;

    @JsonProperty("tipo_calculo")
    private String tipoCalculo;

    @JsonProperty("valor_total")
    private BigDecimal valorTotal;

    @JsonProperty("quantidade_parcelas")
    private int quantidadeParcelas;

    @JsonProperty("valor_parcelas")
    private BigDecimal valorParcelas;

    @JsonProperty("dia_pagamento")
    private int diaPagamento;

    @JsonProperty("percentual_taxa_juro")
    private BigDecimal percentualTaxaJuro;
}
