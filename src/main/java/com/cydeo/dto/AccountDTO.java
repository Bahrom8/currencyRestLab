package com.cydeo.dto;

import com.cydeo.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDTO {

    @JsonIgnore
    private Long id;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long accountNumber;
    private AccountType accountType;
    private String baseCurrency;
    private BigDecimal balance;

    private String username;

}
