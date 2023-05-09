package com.posvenda.posvenda.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiJuros {

    @JsonProperty("definir_data_contratacao")
    private String definirDataContratacao;

    @JsonProperty("definir_criterio_calculo")
    private String definirCriterioCalculo;

    @JsonProperty("definir_quantidade_parcelas")
    private int definirQuantidadeParcelas;

    @JsonProperty("definir_valor_contratacao")
    private BigDecimal definirValorContratacao;

}
