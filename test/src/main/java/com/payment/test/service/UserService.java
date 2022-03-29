package com.payment.test.service;

import com.payment.test.Repository.UserEntityRepository;
import entity.UserEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserEntityRepository userEntityRepository;

    private final PasswordEncoder passwordEncoder ;

    public UserService(UserEntityRepository userEntityRepository, PasswordEncoder passwordEncoder) {
        this.userEntityRepository = userEntityRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity creat(UserEntity userEntity){
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userEntityRepository.save(userEntity);

    }

    public boolean checkUser( String user){
        return userEntityRepository.existsByUsername(user);
    }

    public List<UserEntity> getAll() {
        return userEntityRepository.findAll();
    }
}
