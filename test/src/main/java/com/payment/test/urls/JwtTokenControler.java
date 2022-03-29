package com.payment.test.urls;

import com.payment.test.Repository.UserEntityRepository;
import entity.UserEntity;
import com.payment.test.security.JwtTokenProvayder;
import com.payment.test.urls.vm.LoginVm;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
// login url
@RestController
@RequestMapping("/user")
public class JwtTokenControler {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvayder jwtTokenProvayder ;
    private final UserEntityRepository userEntityRepository;

    public JwtTokenControler(AuthenticationManager authenticationManager, JwtTokenProvayder jwtTokenProvayder, UserEntityRepository userEntityRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvayder = jwtTokenProvayder;
        this.userEntityRepository = userEntityRepository;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginVm loginVm ){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginVm.getUsername(),loginVm.getPassword()));
        UserEntity userEntity = userEntityRepository.findByUsername(loginVm.getUsername());
        if(userEntity == null){
            throw new UsernameNotFoundException("bunday foydalanuvchi mavjud emas");
        }
        String token = jwtTokenProvayder.createToke(userEntity.getUsername() ,userEntity.getRoles());
        Map<Object,Object> map = new HashMap<>();
        map.put("username" , userEntity.getUsername());
        map.put("token" , token);
        return ResponseEntity.ok(map);
    }

}
