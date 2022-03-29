package com.example.payments.services;

import com.example.payments.entity.PostData;
import com.example.payments.entity.enums.PostHttp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.*;
@Service
public class PostHttpServic {
    private final RestTemplate restTemplate;
    private final PostDataServic postDataServic;
    @Value("${url.jsonplachoder}")
    private String url;
    public PostHttpServic(RestTemplate restTemplate, PostDataServic postDataServic) {
        this.restTemplate = restTemplate;
        this.postDataServic = postDataServic;
    }
    public List<PostHttp> findAll1(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<List<PostHttp>> entity = new HttpEntity<>(headers);
        List<PostHttp> result = restTemplate.exchange(this.url+"/posts", HttpMethod.GET ,entity,List.class).getBody();
        return result;
    }
    public PostHttp findOne(Long id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<PostHttp> entity = new HttpEntity<>(headers);
        PostHttp result =  restTemplate.exchange(this.url+"/posts/"+id, HttpMethod.GET ,entity,PostHttp.class).getBody();
        return result;
    }
    public PostHttp postOne(PostHttp postHttp){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<PostHttp> entity = new HttpEntity<>(postHttp,headers);
        PostHttp result =  restTemplate.exchange(this.url+"/posts/", HttpMethod.POST ,entity,PostHttp.class).getBody();
        return result;
    }
    public PostHttp putOne(Long id,PostHttp postHttp){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<PostHttp> entity = new HttpEntity<>(postHttp,headers);
        PostHttp result =  restTemplate.exchange(this.url+"posts/"+id, HttpMethod.PUT ,entity,PostHttp.class).getBody();
        return result;
    }
    public Object findAll(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<PostHttp[]> entity = new HttpEntity<>(headers);
        PostHttp[] result = restTemplate.exchange(this.url+"/posts", HttpMethod.GET ,entity,PostHttp[].class).getBody();
        postDataServic.saveAll(result);
        return result;}
    public Page<PostData> findAll1(Pageable pageable){
        return postDataServic.findAll(pageable);
    }
// auth boshqa appdan tekshirish
    public LinkedHashMap test(LinkedHashMap object){
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<LinkedHashMap> entity = new HttpEntity<>(object,headers);
        LinkedHashMap result =  restTemplate.exchange("http://localhost:8083/user/login/", HttpMethod.POST ,entity,LinkedHashMap.class).getBody();



        System.out.println(result.get("token"));
        return result;

    }

}
