package com.peony.microcloudmall.controller;

import com.peony.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/jdMall")
public class JdMallController {

    @Autowired
    private RestTemplate restTemplate;



    @RequestMapping("/home")
    public String showHomePage(){
        Product product = new Product();
        restTemplate.getForObject("http://localhost/8001/");
        return "home";
    }

}
