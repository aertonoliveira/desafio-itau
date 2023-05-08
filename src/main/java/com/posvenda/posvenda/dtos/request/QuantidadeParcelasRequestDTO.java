package com.posvenda.posvenda.dtos.request;

import com.posvenda.posvenda.models.AdiantamentoQuantidadeParcela;
import com.posvenda.posvenda.models.Contrato;
import com.posvenda.posvenda.models.Parcelas;

import java.io.Serializable;
import java.util.List;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuantidadeParcelasRequestDTO implements Serializable {

    private Contrato contrato;
    private List<Parcelas> financeiro;
    private AdiantamentoQuantidadeParcela adiantamento;


}
