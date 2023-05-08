package com.posvenda.posvenda.services;

import com.posvenda.posvenda.dtos.request.AlteracaoDataPagamentoRequestDTO;
import com.posvenda.posvenda.dtos.request.QuantidadeParcelasRequestDTO;
import com.posvenda.posvenda.dtos.response.AlteracaoDataPagamentoResponseDTO;
import com.posvenda.posvenda.dtos.response.QuantidadeParcelasResponseDTO;
import com.posvenda.posvenda.exception.PagamentoException;
import com.posvenda.posvenda.models.Parcelas;
import com.posvenda.posvenda.utils.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class QuantidadeParcelasService {

    private static String MOCK_ADITAMENTO = "ADITAMENTO";
    private static Double MOCK_NOVO_VALOR_PARCELA = 52000.00;
    private static Integer MOCK_NOVA_QUANTIDADE_PARCELAS = 54;
    private static Integer MOCK_NOVO_DIA_PAGAMENTO = 4;
    public QuantidadeParcelasResponseDTO quantidadeParcelas(QuantidadeParcelasRequestDTO parcelas) throws PagamentoException {

        try{
            Utils.validaContratoAtivo(parcelas.getContrato().getAtivo());
            Utils.validaQuantidadeParcelas(MOCK_NOVA_QUANTIDADE_PARCELAS,parcelas.getAdiantamento().getNovaQuantidadeParcelas());
        }catch (PagamentoException e){
            throw new PagamentoException(e.getMessage());
        }
        return null;
    }





}
