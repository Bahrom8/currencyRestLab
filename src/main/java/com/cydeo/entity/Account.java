package com.cydeo.entity;

import com.cydeo.enums.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounts")
public class Account extends BaseEntity {

    @Column(unique = true)
    private Long accountNumber;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private String baseCurrency;
    private BigDecimal balance;

    @ManyToOne
    private User user;


}
