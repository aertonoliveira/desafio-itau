package com.posvenda.posvenda.services;

import com.posvenda.posvenda.exception.PagamentoException;
import com.posvenda.posvenda.models.AdiantamentoQuantidadeParcela;
import com.posvenda.posvenda.models.Parcelas;
import com.posvenda.posvenda.models.RetornoApiJuros;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RegrasService {

    private static String MOCK_ADITAMENTO = "ADITAMENTO";
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
            throw new PagamentoException("A parcela não pode ser menor do que a inferior  à atual");
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

    public static Parcelas atualizarDiaPagamento(Parcelas parcelas, int diaPagamento) {
        parcelas.setTipoCalculo(MOCK_ADITAMENTO);
        parcelas.setDiaPagamento(diaPagamento);
        return parcelas;
    }

    public static Parcelas novaParcela(double valorAtualizado, RetornoApiJuros retornoApiJuros, int adiantamento){
        Parcelas novaParcela = new Parcelas();
        Date dataAtual = new Date();
        novaParcela.setQuantidadeParcelas(adiantamento);
        novaParcela.setTipoCalculo(MOCK_ADITAMENTO);
        novaParcela.setDataCalculo(dataAtual);
        novaParcela.setValorParcelas(valorAtualizado);
        novaParcela.setValorTotal(retornoApiJuros.getValorTotal());
        novaParcela.setPercentualTaxaJuro(retornoApiJuros.getPercentualJuros());
        novaParcela.setDiaPagamento(01);
        return novaParcela;
    }

    public static Double recalculaValor(Double valorTotal, Integer qtdParcelas){
        return valorTotal / qtdParcelas;
    }
}
