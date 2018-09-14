package com.peony.microcloudmall.controller;

import com.peony.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Controller
@RequestMapping("/jdMall")
public class JdMallController {

    @Autowired
    private RestTemplate restTemplate;



    @RequestMapping("/page/home")
    public String showHomePage(){
        return "home";
    }
    @RequestMapping("/page/{productId}")
    public String showHomePage(@PathVariable String productId, HashMap<String,Object> map){
        Product product = restTemplate.getForObject("http://localhost:8001/product/get/"+productId, Product.class);
        map.put("product",product);
        return "product";
    }
}
