package com.spriti.Banking_App.service;

import com.spriti.Banking_App.dto.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccByUsername(String email);

    AccountDto depositeInAccountById(int id, double amount);

    AccountDto withdrawFromAccountById(int id, double amount);

    List<AccountDto> getAllAccounts();

}
