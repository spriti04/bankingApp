package com.spriti.Banking_App.mapper;

import com.spriti.Banking_App.dto.AccountDto;
import com.spriti.Banking_App.entity.Account;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto){
        Account account = new Account(
                accountDto.getId(),
                accountDto.getName(),
                accountDto.getEmail(),
                accountDto.getPassword(),
                accountDto.getAmount(),
                accountDto.getRole()
        );

        return account;
    }

    public static AccountDto mapToAccountDto(Account account){
        AccountDto accountDto = new AccountDto(
                account.getId(),
                account.getName(),
                account.getEmail(),
                account.getPassword(),
                account.getAmount(),
                account.getRole()
        );

        return accountDto;
    }
}
