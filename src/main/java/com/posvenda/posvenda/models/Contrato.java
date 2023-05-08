package com.posvenda.posvenda.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contrato {

    @JsonProperty("id_contrato")
    private String idContrato;

    @JsonProperty("ultimo_digito_contrato")
    private String ultimoDigitoContrato;

    @JsonProperty("numero_cpf_cnpj_cliente")
    private String numeroCpfCnpjCliente;

    @JsonProperty("data_contratacao")
    private String dataContratacao;

    @JsonProperty("ativo")
    private Boolean ativo;

    @JsonProperty("parcelas_em_atraso")
    private Boolean parcelasEmAtraso;

}
