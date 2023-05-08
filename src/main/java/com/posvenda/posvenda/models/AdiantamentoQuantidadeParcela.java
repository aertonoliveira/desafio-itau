package com.posvenda.posvenda.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdiantamentoQuantidadeParcela {

    @JsonProperty("nova_quantidade_parcelas")
    private int novaQuantidadeParcelas;
}
