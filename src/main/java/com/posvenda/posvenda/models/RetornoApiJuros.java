package com.posvenda.posvenda.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RetornoApiJuros {

    @JsonProperty("percentual_juros")
    private double percentualJuros;

    @JsonProperty("valor_total")
    private double valorTotal;
}
