package com.spriti.Banking_App.service;

import com.spriti.Banking_App.dto.AccountDto;
import com.spriti.Banking_App.entity.Account;
import com.spriti.Banking_App.mapper.AccountMapper;
import com.spriti.Banking_App.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        accountDto.setPassword(passwordEncoder.encode(accountDto.getPassword()));

        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAcc = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAcc);
    }

    @Override
    public AccountDto getAccByUsername(String email) {
        Optional<Account> optAcc = accountRepository.findByEmail(email);

        if(optAcc.isPresent()){
            Account account = optAcc.get();

            return AccountMapper.mapToAccountDto(account);
        }else {
            throw new RuntimeException("Account doesn't exist");
        }
    }

    @Override
    public AccountDto depositeInAccountById(int id, double amount) {

        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        double total = account.getAmount() + amount;
        account.setAmount(total);
        Account account1 = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(account1);
    }

    @Override
    public AccountDto withdrawFromAccountById(int id, double amount) {


        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if(amount > account.getAmount()){
            throw new RuntimeException("Insufficient Balance");
        }

        double total = account.getAmount() - amount;
        account.setAmount(total);
        Account account1 = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(account1);
    }

    @Override
    public List<AccountDto> getAllAccounts() {

        List<Account> accountList = accountRepository.findAll();
        return accountList.stream().map(
                (account) -> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
    }

}
