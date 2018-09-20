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
<<<<<<< HEAD
        return new Product(productId,"库存服务提供的产品-"+productId,800d);
=======
        Product product = new Product();
        Random random = new Random();
        System.out.println(".............8001");
        product.setId(productId).setProductName("来自8001库存服务 --> 京东专卖产品-"+productId).setStockQty(Double.parseDouble(random.nextInt(1000000)+""));
        return product;
>>>>>>> 3774be13ffb016b58265c2043199f9ede032bd21
    }
}
