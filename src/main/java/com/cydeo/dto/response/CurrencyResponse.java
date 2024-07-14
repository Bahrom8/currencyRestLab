package com.cydeo.dto.response;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CurrencyResponse {

    private LocalDateTime dateTime;
    private Boolean success;
    private String httpStatus;
    private String message;
    private List<CurrencyData> data;
}