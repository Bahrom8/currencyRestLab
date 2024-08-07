package com.cydeo.service;

import com.cydeo.dto.AccountDTO;

import java.util.List;

public interface AccountService {

    List<AccountDTO> findAllByUsername(String username);

    AccountDTO create (AccountDTO accountDTO);

    List<AccountDTO> findAllByUsernameAndCurrencyList(String username, List<String> currencyList);

}