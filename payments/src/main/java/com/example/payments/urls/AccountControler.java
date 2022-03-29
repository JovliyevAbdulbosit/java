package com.example.payments.urls;

import com.example.payments.entity.Account;
import com.example.payments.services.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cards")
public class AccountControler {
    private final AccountService   accountService;

    public AccountControler(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/all")
    public ResponseEntity getAll(){
        return ResponseEntity.ok(accountService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity create(@RequestBody Account account){
        return ResponseEntity.ok( accountService.create(account));
    }
}
