package com.cydeo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CurrencyResponse {

    private LocalDateTime dateTime;
    private boolean success;
    private String httpStatus;
    private String message;

    private List<CurrencyData> data;



}
