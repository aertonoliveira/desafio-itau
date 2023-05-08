package com.posvenda.posvenda.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdiantamentoAlteracaoData {

    @JsonProperty("nova_data_pagamento")
    private int novaDataPagamento;
}
