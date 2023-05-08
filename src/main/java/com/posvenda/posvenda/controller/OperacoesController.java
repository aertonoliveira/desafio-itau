package com.posvenda.posvenda.controller;

import com.posvenda.posvenda.dtos.request.AlteracaoDataPagamentoRequestDTO;
import com.posvenda.posvenda.dtos.request.QuantidadeParcelasRequestDTO;
import com.posvenda.posvenda.dtos.response.AlteracaoDataPagamentoResponseDTO;
import com.posvenda.posvenda.dtos.response.QuantidadeParcelasResponseDTO;
import com.posvenda.posvenda.exception.PagamentoException;
import com.posvenda.posvenda.services.AlteracaoDataPagamentoService;
import com.posvenda.posvenda.services.QuantidadeParcelasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OperacoesController {

    @Autowired
    private QuantidadeParcelasService parcelasService;

    @Autowired
    private AlteracaoDataPagamentoService alteracaoDataPagamentoService;

    @ExceptionHandler(PagamentoException.class)
    @RequestMapping(value =  "/quantidade/parcelas", method = RequestMethod.POST)
    public ResponseEntity<QuantidadeParcelasResponseDTO> quantidadeParcela(@RequestBody QuantidadeParcelasRequestDTO pagamento){
        return ResponseEntity.ok().body(parcelasService.quantidadeParcelas(pagamento));
    }

    @ExceptionHandler(PagamentoException.class)
    @RequestMapping(value =  "/alteracao/data", method = RequestMethod.POST)
    public ResponseEntity<AlteracaoDataPagamentoResponseDTO> alteracaoData(@RequestBody AlteracaoDataPagamentoRequestDTO pagamento){
        return ResponseEntity.ok().body(alteracaoDataPagamentoService.alteracaoDataPagamento(pagamento));
    }
}
