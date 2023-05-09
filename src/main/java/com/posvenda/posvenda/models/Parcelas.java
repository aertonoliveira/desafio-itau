package com.posvenda.posvenda.models;



import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Parcelas {


    @JsonProperty("data_calculo")
    private Date dataCalculo;

    @JsonProperty("tipo_calculo")
    private String tipoCalculo;

    @JsonProperty("valor_total")
    private double valorTotal;

    @JsonProperty("quantidade_parcelas")
    private int quantidadeParcelas;

    @JsonProperty("valor_parcelas")
    private double valorParcelas;

    @JsonProperty("dia_pagamento")
    private int diaPagamento;

    @JsonProperty("percentual_taxa_juro")
    private double percentualTaxaJuro;
}
