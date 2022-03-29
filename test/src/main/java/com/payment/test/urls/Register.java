package com.payment.test.urls;

import entity.UserEntity;
import com.payment.test.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Register {
    private final UserService userService;

    public Register(UserService userEntityService) {
        this.userService = userEntityService;
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody UserEntity user){
        if(!checkPassword(user.getPassword())){
            return new ResponseEntity("parol uzunligi 4 tadan kam kiritdingiz", HttpStatus.BAD_REQUEST);
        }
        if(userService.checkUser(user.getUsername())){
            return new ResponseEntity("Bu user oldin ro'yxatdan o'tgan", HttpStatus.BAD_REQUEST) ;
        }
        return ResponseEntity.ok(userService.creat(user));


    }
    private boolean checkPassword(String password){

            return (password.length() >= 4 );

    }
    @GetMapping("/all")
    public ResponseEntity getAll(){
        return ResponseEntity.ok(userService.getAll());
    }
}