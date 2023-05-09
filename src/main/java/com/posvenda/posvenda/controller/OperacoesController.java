package com.posvenda.posvenda.controller;

import com.posvenda.posvenda.dtos.request.AlteracaoDataPagamentoRequestDTO;
import com.posvenda.posvenda.dtos.request.QuantidadeParcelasRequestDTO;
import com.posvenda.posvenda.dtos.response.AlteracaoDataPagamentoResponseDTO;
import com.posvenda.posvenda.dtos.response.QuantidadeParcelasResponseDTO;
import com.posvenda.posvenda.exception.PagamentoException;
import com.posvenda.posvenda.services.OperacoesService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class OperacoesController {

    @Autowired
    private OperacoesService operacoesService;



    @RequestMapping(value =  "/quantidade/parcelas", method = RequestMethod.POST)
    public ResponseEntity<QuantidadeParcelasResponseDTO> quantidadeParcela(HttpServletRequest request, HttpServletResponse response, @RequestBody QuantidadeParcelasRequestDTO pagamento) throws PagamentoException{
        String itauPosVendaTesteHeader = request.getHeader("itau-pos-venda-teste");
        // Validação do header
        if (itauPosVendaTesteHeader == null || !itauPosVendaTesteHeader.matches("[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")) {
            throw new PagamentoException("Header 'itau-pos-venda-teste' inválido.");
        }
        response.addHeader("itau-pos-venda-teste", itauPosVendaTesteHeader);
        return ResponseEntity.ok().body(operacoesService.quantidadeParcelas(pagamento));
    }


    @RequestMapping(value =  "/alteracao/data", method = RequestMethod.POST)
    public ResponseEntity<AlteracaoDataPagamentoResponseDTO> alteracaoData(HttpServletRequest request,HttpServletResponse response, @RequestBody AlteracaoDataPagamentoRequestDTO pagamento) throws PagamentoException{
        String itauPosVendaTesteHeader = request.getHeader("itau-pos-venda-teste");
        // Validação do header
        if (itauPosVendaTesteHeader == null || !itauPosVendaTesteHeader.matches("[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")) {
            throw new PagamentoException("Header 'itau-pos-venda-teste' inválido.");
        }
        response.addHeader("itau-pos-venda-teste", itauPosVendaTesteHeader);
        return ResponseEntity.ok().body(operacoesService.alteracaoDataPagamento(pagamento));
    }
}
