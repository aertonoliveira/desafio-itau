package com.posvenda.posvenda.services;

import com.posvenda.posvenda.dtos.request.AlteracaoDataPagamentoRequestDTO;
import com.posvenda.posvenda.dtos.request.QuantidadeParcelasRequestDTO;
import com.posvenda.posvenda.dtos.response.AlteracaoDataPagamentoResponseDTO;
import com.posvenda.posvenda.dtos.response.QuantidadeParcelasResponseDTO;
import com.posvenda.posvenda.exception.PagamentoException;
import com.posvenda.posvenda.models.Contrato;
import com.posvenda.posvenda.models.Parcelas;
import com.posvenda.posvenda.models.RetornoApiJuros;
import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Service;

@Service
public class OperacoesService {

    public AlteracaoDataPagamentoResponseDTO alteracaoDataPagamento(AlteracaoDataPagamentoRequestDTO requestDTO) throws PagamentoException {
        try{
            RegrasService.validaDataPagamento(requestDTO.getFinanceiro().get(0).getDataCalculo());
            RegrasService.validaContratoAtivo(requestDTO.getContrato().getAtivo());
            RegrasService.validaParcelaAtraso(requestDTO.getContrato().getParcelasEmAtraso());

            var response = new AlteracaoDataPagamentoResponseDTO();
            BeanUtils.copyProperties(requestDTO,response);
            Parcelas parcelasList = RegrasService.atualizarDiaPagamento(requestDTO.getFinanceiro().get(requestDTO.getFinanceiro().size() - 1), requestDTO.getAdiantamento().getNovaDataPagamento());
            response.getFinanceiro().add(parcelasList);
            return response;

        }catch (PagamentoException e){
            throw new PagamentoException(e.getMessage());
        }

    }
    public QuantidadeParcelasResponseDTO quantidadeParcelas(QuantidadeParcelasRequestDTO parcelas) throws PagamentoException {

        try{
            RegrasService.validaContratoAtivo(parcelas.getContrato().getAtivo());
            RegrasService.validaQuantidadeParcelas(parcelas.getFinanceiro().get(parcelas.getFinanceiro().size() - 1).getQuantidadeParcelas()
                    ,parcelas.getAdiantamento().getNovaQuantidadeParcelas());

            RetornoApiJuros retornoApiJuros = requestApiJuros(parcelas.getContrato(),parcelas.getFinanceiro().get(parcelas.getFinanceiro().size() - 1));
            double valorParcelaAtualizado = RegrasService.recalculaValor(retornoApiJuros.getValorTotal(), parcelas.getAdiantamento().getNovaQuantidadeParcelas());

            Parcelas novaParcela = RegrasService.novaParcela(valorParcelaAtualizado,retornoApiJuros,parcelas.getAdiantamento().getNovaQuantidadeParcelas());

            var response = new QuantidadeParcelasResponseDTO();
            BeanUtils.copyProperties(parcelas,response);
            response.getFinanceiro().add(novaParcela);
            return response;
        }catch (PagamentoException e){
            throw new PagamentoException(e.getMessage());
        }

    }

    private RetornoApiJuros requestApiJuros(Contrato contrato, Parcelas parcelas)throws PagamentoException {
        /*RestTemplate restTemplate = new RestTemplate();

        String url = "https://itautestes.juros.com/calculo-juros";

        ApiJuros apiJuros = new ApiJuros();

        apiJuros.setDefinirDataContratacao(contrato.getDataContratacao());
        apiJuros.setDefinirCriterioCalculo(parcelas.getTipoCalculo());
        apiJuros.setDefinirQuantidadeParcelas(parcelas.getQuantidadeParcelas());
        apiJuros.setDefinirValorContratacao(parcelas.getValorTotal());

        HttpEntity<ApiJuros> requestEntity = new HttpEntity<ApiJuros>(apiJuros);

        ResponseEntity<RetornoApiJuros> response = restTemplate.exchange(url, HttpMethod.POST,requestEntity, RetornoApiJuros.class);

        if(response.getStatusCode().is2xxSuccessful()){
            RetornoApiJuros retornoApiJuros = response.getBody();
            retornoApiJuros.setPercentualJuros(1.93);
            retornoApiJuros.setValorTotal(52000.00);
            return retornoApiJuros;
        }else{
            RetornoApiJuros retornoApiJuros = new RetornoApiJuros();
            retornoApiJuros.setPercentualJuros(1.93);
            retornoApiJuros.setValorTotal(52000.00);
            return retornoApiJuros;
        }*/
        RetornoApiJuros retornoApiJuros = new RetornoApiJuros();
        retornoApiJuros.setPercentualJuros(1.93);
        retornoApiJuros.setValorTotal(52000.00);
        return retornoApiJuros;


    }









}
