package com.peony.microcloudstockhystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.peony.entity.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/product")
public class ProductController {

    @RequestMapping("/list")
    public String aopTest(){
        System.out.println("进入方法ProductController.aopTest");
        return "aopTest";
    }

    @RequestMapping("/get/{productId}")
    @HystrixCommand(fallbackMethod = "defaultProduct")
    public Product getProduct(@PathVariable String productId){
        if ("888".equals(productId)) {
            throw new RuntimeException("888产品是测试服务熔断的产品");
        }
        Product product = new Product();
        Random random = new Random();
        System.out.println(".............8001");
        product.setId(productId).setProductName("来自8001库存服务 --> 专卖产品-"+productId).setStockQty(Double.parseDouble(random.nextInt(1000000)+""));
        return product;
    }

    public Product defaultProduct( String productId) {
        Product product = new Product();
        product.setId(productId).setProductName("4444-原服务熔断-这是默认值.........").setStockQty(-1000d);
        return product;
    }
}
