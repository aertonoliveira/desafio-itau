package com.posvenda.posvenda.utils;

import com.posvenda.posvenda.exception.PagamentoException;
import com.posvenda.posvenda.models.Parcelas;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utils {

   public static void validaDataPagamento(Date data){

        LocalDate hoje =  LocalDate.now();
        LocalDate diaDePagamento = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        long diasDeDiferenca = ChronoUnit.DAYS.between(hoje, diaDePagamento);
        if (diasDeDiferenca > 10) {
            throw new PagamentoException("O dia de pagamento não pode estar mais que 10 dias adiante do dia atual de pagamento");
        }
    }

    public static void validaQuantidadeParcelas(int parcelaAtual, int parcelaContrato){


        if (parcelaContrato < parcelaAtual) {
            throw new PagamentoException("A parcela não pode ser menor do que a inferior");
        }
    }

    public static void validaContratoAtivo(Boolean ativo){
       if(ativo.equals(false)){
           throw new PagamentoException("O seu contrato precisa está ativo para esse tipo de recurso");
       }
    }

    public static void validaParcelaAtraso(Boolean parcelaEmAtraso){
       if(parcelaEmAtraso.equals(true)){
           throw new PagamentoException("O seu contrato possuí parcelas em atraso");
       }
    }

    public static List<Parcelas>  atualizarDiaPagamento(List<Parcelas> parcelasList,int diaPagamento) {
        List<Parcelas> lista = new ArrayList<>();
        for(int i = 0; i < parcelasList.size(); i++){
            Parcelas parcela = parcelasList.get(i);
            parcela.setDiaPagamento(diaPagamento);
            lista.add(parcela);
        }
        return lista;


    }
}
