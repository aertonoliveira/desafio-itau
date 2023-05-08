package com.posvenda.posvenda.feign;

import com.posvenda.posvenda.models.ApiJuros;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "TaxaDeJurosApi", url = "https://itautestes.juros.com/")
public interface FeignJuros {

    @RequestMapping(method = RequestMethod.GET, value = "/juros")
    ApiJuros getPosts(@RequestParam int dias);
}
