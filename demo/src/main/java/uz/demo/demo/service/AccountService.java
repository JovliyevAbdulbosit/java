package uz.demo.demo.service;

import org.springframework.stereotype.Service;
import uz.demo.demo.entity.Account;
import uz.demo.demo.repository.AccountRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService  {
    private final AccountRepository accountRepository;


    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    public Account saqlash(Account account){
        Account result = accountRepository.save(account);
        return result;
    }
    public List<Account> getAll(){
        return accountRepository.findAll();
    }
    public Optional<Account> getOne(Long id){
        return accountRepository.findById(id);
    }
    public void uchirish(Long id){
        accountRepository.deleteById(id);
    }
}
