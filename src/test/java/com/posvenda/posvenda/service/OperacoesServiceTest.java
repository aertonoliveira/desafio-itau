package com.posvenda.posvenda.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.posvenda.posvenda.dtos.request.AlteracaoDataPagamentoRequestDTO;
import com.posvenda.posvenda.dtos.response.AlteracaoDataPagamentoResponseDTO;
import com.posvenda.posvenda.exception.PagamentoException;
import com.posvenda.posvenda.models.AdiantamentoAlteracaoData;
import com.posvenda.posvenda.models.Contrato;
import com.posvenda.posvenda.models.Parcelas;
import com.posvenda.posvenda.services.OperacoesService;
import com.posvenda.posvenda.services.RegrasService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class OperacoesServiceTest {

    @Autowired
    private OperacoesService operacoesService;



    @Test
    void testAlteracaoDataPagamento() throws PagamentoException {
        // criação de objetos para teste
        Contrato contrato = new Contrato();
        contrato.setAtivo(true);
        contrato.setParcelasEmAtraso(false);

        Parcelas parcela = new Parcelas();
        Date data = new Date();
        parcela.setDataCalculo(data);
        parcela.setDiaPagamento(2);
        parcela.setValorTotal(1000);

        AdiantamentoAlteracaoData adiantamento = new AdiantamentoAlteracaoData();
        adiantamento.setNovaDataPagamento(2);

        List<Parcelas> financeiro = new ArrayList<>();
        financeiro.add(parcela);

        AlteracaoDataPagamentoRequestDTO requestDTO = new AlteracaoDataPagamentoRequestDTO();
        requestDTO.setContrato(contrato);
        requestDTO.setFinanceiro(financeiro);
        requestDTO.setAdiantamento(adiantamento);

        // execução da função que será testada
        AlteracaoDataPagamentoResponseDTO responseDTO = operacoesService.alteracaoDataPagamento(requestDTO);

        // verificação do resultado
        assertNotNull(responseDTO);
        assertEquals(2, responseDTO.getFinanceiro().get(0).getDiaPagamento());

    }






}
