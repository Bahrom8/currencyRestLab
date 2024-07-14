package com.cydeo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CurrencyData {

    private String currencyName;
    private String currencyCode;
    private String currencySymbol;
    private BigDecimal usdExchangeRate;



}
