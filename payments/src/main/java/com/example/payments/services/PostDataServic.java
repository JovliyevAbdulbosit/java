package com.example.payments.services;

import com.example.payments.Repasitory.PostDataRepository;
import com.example.payments.entity.PostData;
import com.example.payments.entity.enums.PostHttp;
import org.apache.tomcat.util.digester.ArrayStack;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostDataServic {
    private final PostDataRepository postDataRepository;

    public PostDataServic(PostDataRepository postDataRepository) {
        this.postDataRepository = postDataRepository;
    }
    public PostData save(PostData postData){
        return postDataRepository.save(postData);
    }

    public List<PostData> saveAll(PostHttp [] postHttps){
        List<PostData> postDatas=new ArrayList<>();
        for (PostHttp postHttp:postHttps) {
            PostData  postData = new PostData();
            postData.setPostId(postHttp.getId());
            postData.setBody(postHttp.getBody());
            postData.setTitle(postHttp.getTitle());
            postData.setUserId(postHttp.getUserId());
            postDatas.add(postData);
        }
        return postDataRepository.saveAll(postDatas);
    }
    @Transactional(readOnly = true)
    public Page<PostData>  findAll(Pageable pageable){
        return postDataRepository.findAll(pageable);
    }
}
