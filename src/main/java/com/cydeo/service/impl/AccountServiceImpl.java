package com.cydeo.service.impl;

import com.cydeo.dto.AccountDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.entity.Account;
import com.cydeo.entity.User;
import com.cydeo.repository.AccountRepository;
import com.cydeo.service.AccountService;
import com.cydeo.service.UserService;
import com.cydeo.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UserService userService;
    private final MapperUtil mapperUtil;

    public AccountServiceImpl(AccountRepository accountRepository, UserService userService, MapperUtil mapperUtil) {
        this.accountRepository = accountRepository;
        this.userService = userService;
        this.mapperUtil = mapperUtil;
    }

    /**
     * Retrieves all accounts for a user specified by the username.
     *
     * @param username The username of the user.
     * @return List of AccountDTO representing the user's accounts.
     */
    @Override
    public List<AccountDTO> findAllByUsername(String username) {
        // Fetch all accounts for the user by username and convert each to an AccountDTO.
        return accountRepository.findAllByUser_Username(username).stream()
                .map(account -> {
                    // Convert each Account to an AccountDTO and set the username.
                    AccountDTO accountDTO = mapperUtil.convert(account, new AccountDTO());
                    accountDTO.setUsername(username);
                    return accountDTO;
                })
                .collect(Collectors.toList());
    }

    /**
     * Generates a random account number.
     *
     * @return The randomly generated account number.
     */
    private Long generateAccountNumber() {
        return (long) (Math.random() * 1000000000000L);
    }

    /**
     * Creates a new account for the user specified in the accountDTO.
     *
     * @param accountDTO The AccountDTO containing account information.
     * @return The created AccountDTO.
     */
    @Override
    public AccountDTO create(AccountDTO accountDTO) {
        // Find the user by username using the UserService.
        UserDTO user = userService.findByUsername(accountDTO.getUsername());

        // Convert the AccountDTO to an Account entity for database storage.
        Account accountToSave = mapperUtil.convert(accountDTO, new Account());

        // Set the user of the account by converting the UserDTO to a User entity.
        accountToSave.setUser(mapperUtil.convert(user, new User()));

        // Generate a random account number for the new account.
        accountToSave.setAccountNumber(generateAccountNumber());

        // Save the newly created account to the database.
        Account newAccount = accountRepository.save(accountToSave);

        // Convert the saved Account entity back to an AccountDTO for response.
        AccountDTO accountToReturn = mapperUtil.convert(newAccount, new AccountDTO());

        // Set the username in the returned AccountDTO for consistency.
        accountToReturn.setUsername(user.getUsername());

        // Return the created AccountDTO.
        return accountToReturn;
    }


}
