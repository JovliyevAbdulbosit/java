package uz.demo.demo.urls;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.demo.demo.entity.Account;
import uz.demo.demo.service.AccountService;

@RestController
@RequestMapping("/api")
public class UrlAccount {
    private final AccountService accountService;

    public UrlAccount(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/account")
    public ResponseEntity creat(@RequestBody Account account){
        Account result=accountService.saqlash(account);
         return ResponseEntity.ok(result) ;

    }
    @GetMapping("/account")
    public ResponseEntity getAll(){
        return ResponseEntity.ok(accountService.getAll());
    }

}
