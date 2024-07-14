package com.cydeo.dto.response;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CurrencyData {

    private String currencyName;
    private String currencyCode;
    private String currencySymbol;
    private BigDecimal usdExchangeRate;
}