package com.cydeo.client;

import com.cydeo.dto.AccountDTO;
import com.cydeo.dto.response.CurrencyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "http://cydeodev.com/api/v1", name = "CURRENCY-CLIENT")
public interface CurrencyClient {

    @GetMapping("/currency/all")
    CurrencyResponse getAllCurrencies();



}
