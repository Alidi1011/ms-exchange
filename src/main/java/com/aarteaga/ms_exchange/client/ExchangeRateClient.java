package com.aarteaga.ms_exchange.client;


import com.aarteaga.ms_exchange.model.Exchange;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "exchange", url = "https://open.er-api.com/v6/latest")
public interface ExchangeRateClient {

    @RequestMapping(method = RequestMethod.GET, value = "/{currency}", produces = "application/json")
    Exchange getExchangeByCurrency(@PathVariable("currency") String currency);
}
