package com.spriti.Banking_App.controller;

import com.spriti.Banking_App.dto.AccountDto;
import com.spriti.Banking_App.dto.CheckDto;
import com.spriti.Banking_App.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    //Create New Account Rest API
    @PostMapping("/createAcc")
    public ResponseEntity<AccountDto> createNewAccount(@RequestBody AccountDto accountDto){
        AccountDto acDto = accountService.createAccount(accountDto);

        return new ResponseEntity<>(acDto, HttpStatus.CREATED);
    }

    //Get Account Rest API
    @GetMapping("/getAcc/{email}")
    public ResponseEntity<AccountDto> getAccDetails(@PathVariable("email") String username){
        AccountDto acDto = accountService.getAccByUsername(username);

        return new ResponseEntity<>(acDto, HttpStatus.OK);
    }

    //Deposit in Account Rest API
    @PutMapping("/deposit")
    public ResponseEntity<AccountDto> deposit(@RequestBody CheckDto check){
        AccountDto acDto = accountService.depositeInAccountById(check.getId(), check.getAmount());

        return new ResponseEntity<>(acDto, HttpStatus.ACCEPTED);
    }

    //Withdraw from Account Rest API
    @PutMapping("/withdraw")
    public ResponseEntity<AccountDto> withdraw(@RequestBody CheckDto check){
        AccountDto acDto = accountService.withdrawFromAccountById(check.getId(), check.getAmount());

        return new ResponseEntity<>(acDto, HttpStatus.ACCEPTED);
    }

    //Get All Accounts Rest API
    @GetMapping("/accounts")
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> list = accountService.getAllAccounts();

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/signIn")
    public ResponseEntity<String> signInforOper(Authentication auth){
        System.out.println(auth);

        AccountDto accDto = accountService.getAccByUsername(auth.getName());

        return ResponseEntity.ok(accDto.getName() + " Logged in Successfully");

    }
}
