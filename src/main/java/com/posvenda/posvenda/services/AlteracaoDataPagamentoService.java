package com.posvenda.posvenda.services;

import com.posvenda.posvenda.dtos.request.AlteracaoDataPagamentoRequestDTO;
import com.posvenda.posvenda.dtos.response.AlteracaoDataPagamentoResponseDTO;
import com.posvenda.posvenda.exception.PagamentoException;
import com.posvenda.posvenda.models.Parcelas;
import com.posvenda.posvenda.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlteracaoDataPagamentoService {

    public AlteracaoDataPagamentoResponseDTO alteracaoDataPagamento(AlteracaoDataPagamentoRequestDTO parcelas) throws PagamentoException {
        try{
            Utils.validaDataPagamento(parcelas.getFinanceiro().get(0).getDataCalculo());
            Utils.validaContratoAtivo(parcelas.getContrato().getAtivo());
            Utils.validaParcelaAtraso(parcelas.getContrato().getParcelasEmAtraso());

            var response = new AlteracaoDataPagamentoResponseDTO();
            BeanUtils.copyProperties(parcelas,response);
            List<Parcelas> parcelasList = Utils.atualizarDiaPagamento(parcelas.getFinanceiro(), parcelas.getAdiantamento().getNovaDataPagamento());
            response.setFinanceiro(parcelasList);
            return response;

        }catch (PagamentoException e){
            throw new PagamentoException(e.getMessage());
        }

    }
}
