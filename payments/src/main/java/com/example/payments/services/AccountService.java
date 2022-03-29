package com.example.payments.services;

import com.example.payments.Repasitory.AccountRepository;
import com.example.payments.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    public List<Account> getAll(){return accountRepository.findAll();}
    public Account create(Account account){
       Account result = accountRepository.save(account);
       return result;
    }
}
