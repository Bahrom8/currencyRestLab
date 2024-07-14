package com.cydeo.client;

import com.cydeo.dto.response.CurrencyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(url = "http://cydeodev.com/api/v1", name = "currency-service")
public interface CurrencyClient {

    //http://cydeodev.com/api/v1 --> baseurl
    // /currency/all -endpoint

    @GetMapping("/currency/all")
    CurrencyResponse getAllCurrencies();

    //http://cydeodev.com/api/v1 --> baseurl
    // /currency/list --> endpoint
    // ?currencies=CAD&currencies=GBP --> Query Parameter
    @GetMapping("/currency/list")
    CurrencyResponse getListOfCurrencies(@RequestParam("currencies") List<String> currencies);


    //    http://cydeodev.com/api/v1 --> baseurl
//    /currency/secure/list --> endpoint
//    ?currencies=EUR&currencies=GBP --> Query parameter
//     Header --> app-id  Cydeo-123
    @GetMapping("/currency/secure/list")
    CurrencyResponse getListOfCurrenciesSecure(@RequestParam("currencies") List<String> currencies,
                                               @RequestHeader("app-id") String appId);
}