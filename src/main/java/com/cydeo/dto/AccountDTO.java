package com.cydeo.dto;

import com.cydeo.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Map;

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

    @NotNull(message = "Account Type is a required field")
    private AccountType accountType;

    @NotBlank(message = "Base Currency is a required field")
    private String baseCurrency;

    @NotNull(message = "Balance is a required field")
    @DecimalMin(value = "0.0", inclusive = false, message = "Balance must be greater than zero")
    private BigDecimal balance;

    @NotBlank(message = "Username is a required field")
    private String username;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Map<String, BigDecimal> otherCurrencies;
}