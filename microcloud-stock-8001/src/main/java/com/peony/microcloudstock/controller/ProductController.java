package com.peony.microcloudstock.controller;

import com.peony.microcloudstock.common.aop.Ehcache;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @RequestMapping("/list")
    @Ehcache
    public String aopTest(){
        System.out.println("进入方法ProductController.aopTest");
        return "aopTest";
    }

    @RequestMapping("/get/{productId}")
    public String getProduct(@PathVariable String productId){
        return "aopTest";
    }
}
