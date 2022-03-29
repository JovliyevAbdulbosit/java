package com.example.payments.urls;

import com.example.payments.entity.enums.PostHttp;
import com.example.payments.services.PostHttpServic;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/server")
public class PostHttpUrl {
    private final PostHttpServic postHttpServic;;

    public PostHttpUrl(PostHttpServic postHttpServic) {
        this.postHttpServic = postHttpServic;
    }

    @GetMapping("/getAll")
    public ResponseEntity getAll(){
        return ResponseEntity.ok(postHttpServic.findAll());
    }


    @GetMapping("/getOne/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        return ResponseEntity.ok(postHttpServic.findOne(id));
    }


    @PostMapping("/post")
    public ResponseEntity postServer(@RequestBody PostHttp postHttp){
      PostHttp result = postHttpServic.postOne(postHttp);
      return ResponseEntity.ok(result);
    }


    @PutMapping("/post/{id}")
    public ResponseEntity postServer(@PathVariable Long id,@RequestBody PostHttp postHttp){
        PostHttp result = postHttpServic.putOne(id, postHttp);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/getpage")
    public ResponseEntity getpage(Pageable pageable){

        return ResponseEntity.ok(postHttpServic.findAll1(pageable));
    }
    @PostMapping("/ss")
    public ResponseEntity test(@RequestBody LinkedHashMap object){
       return ResponseEntity.ok(postHttpServic.test(object));
    }
}
