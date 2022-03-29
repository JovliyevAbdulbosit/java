package com.payment.test.urls;

import entity.AccountCardUser;
import com.payment.test.service.AccountCardUsderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountCardUserControler {
    private final AccountCardUsderService accountCardUsderService;

    public AccountCardUserControler(AccountCardUsderService accountCardUsderService) {
        this.accountCardUsderService = accountCardUsderService;
    }
    @PostMapping("/create")
    public ResponseEntity create(@RequestBody AccountCardUser accountCardUser){
        return ResponseEntity.ok(accountCardUsderService.create(accountCardUser));
    }
    @GetMapping("/getall")
    public ResponseEntity getAll(){
        return ResponseEntity.ok(accountCardUsderService.getAll());
    }
}
