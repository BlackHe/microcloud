package com.peony.microcloudmallfeign.controller;

import com.peony.entity.Product;
import com.peony.microcloudmallfeign.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Controller
@RequestMapping("/jdMall")
public class JdMallController {

    /***
     * 基于feign的service,将跨服务调用的过程，按照spring mvc的模式实现了
     */
    @Autowired
    private StockService stockService;

    private static final Logger log = LoggerFactory.getLogger(JdMallController.class);



    @RequestMapping("/page/{productId}")
    public String showHomePage(@PathVariable @NotNull String productId, Map<String,Object>  attributeMap){

//        Product product =  restTemplate.getForObject("http://MICROCLOUD-STOCK/product/get/"+productId,Product.class,productId);
        Product product =  stockService.getProduct(productId);
        log.info("通过feign，从 http://MICROCLOUD-STOCK/服务获取到的商品信息 = {}",product.toString());
        attributeMap.put("product",product);
        return "product";
    }

}
