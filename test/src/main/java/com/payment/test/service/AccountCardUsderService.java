package com.payment.test.service;


import com.payment.test.Repository.AccountCardUserRepository;

import entity.AccountCardUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountCardUsderService {
    private final AccountCardUserRepository accountCardUserRepository;

    public AccountCardUsderService(AccountCardUserRepository accountCardUserRepository) {
        this.accountCardUserRepository = accountCardUserRepository;
    }
    public AccountCardUser create(AccountCardUser accountCardUser){
      AccountCardUser result = accountCardUserRepository.save(accountCardUser);
      return result;
    }

    public List<AccountCardUser> getAll() {
        return accountCardUserRepository.findAll();
    }
}
