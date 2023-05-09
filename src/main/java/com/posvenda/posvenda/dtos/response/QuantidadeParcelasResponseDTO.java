package com.posvenda.posvenda.dtos.response;

import com.posvenda.posvenda.models.AdiantamentoQuantidadeParcela;
import com.posvenda.posvenda.models.Contrato;
import com.posvenda.posvenda.models.Parcelas;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuantidadeParcelasResponseDTO implements Serializable {

    private Contrato contrato;
    private List<Parcelas> financeiro;
}
