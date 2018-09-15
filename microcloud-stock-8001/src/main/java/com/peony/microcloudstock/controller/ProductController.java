package com.peony.microcloudstock.controller;

import com.peony.entity.Product;
import com.peony.microcloudstock.common.aop.Ehcache;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

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
    public Product getProduct(@PathVariable String productId){
        Product product = new Product();
        Random random = new Random();
        product.setId(productId).setProductName("京东专卖产品-"+productId).setStockQty(Math.abs(random.nextDouble()*100000));
        return product;
    }
}
