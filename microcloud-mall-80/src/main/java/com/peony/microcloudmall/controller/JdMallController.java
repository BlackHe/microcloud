package com.peony.microcloudmall.controller;

import com.peony.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Controller
@RequestMapping("/jdMall")
public class JdMallController {

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger log = LoggerFactory.getLogger(JdMallController.class);


    @RequestMapping("/home")
    public String showHomePage(){
        return "home";
    }




    @RequestMapping("/page/{productId}")
    public String showHomePage(@PathVariable @NotNull String productId, Map<String,Object>  attributeMap){
//        Product product =  restTemplate.getForObject("http://localhost:8001/product/get/"+productId,Product.class,productId);
        /** http://MICROCLOUD-STOCK/ 是微服务提供者的服务名，可能是集群环境，但注册在eureka上的服务名是相同的*/
        Product product =  restTemplate.getForObject("http://MICROCLOUD-STOCK/product/get/"+productId,Product.class,productId);
        log.info("从库存微服务 http://MICROCLOUD-STOCK/ 获取到的商品信息 = {}",product.toString());
        attributeMap.put("product",product);
        return "product";
    }

}
