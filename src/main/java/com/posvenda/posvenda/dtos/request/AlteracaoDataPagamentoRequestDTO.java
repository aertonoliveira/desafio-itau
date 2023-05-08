package com.posvenda.posvenda.dtos.request;

import com.posvenda.posvenda.models.AdiantamentoAlteracaoData;
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
public class AlteracaoDataPagamentoRequestDTO implements Serializable {

    private Contrato contrato;
    private List<Parcelas> financeiro;
    private AdiantamentoAlteracaoData adiantamento;
}
