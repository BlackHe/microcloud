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

<<<<<<< HEAD
import java.util.HashMap;
=======
import javax.validation.constraints.NotNull;
import java.util.Map;
>>>>>>> 3774be13ffb016b58265c2043199f9ede032bd21

@Controller
@RequestMapping("/jdMall")
public class JdMallController {

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger log = LoggerFactory.getLogger(JdMallController.class);


    @RequestMapping("/page/home")
    public String showHomePage(){
        return "home";
    }
<<<<<<< HEAD
    @RequestMapping("/page/{productId}")
    public String showHomePage(@PathVariable String productId, HashMap<String,Object> map){
        Product product = restTemplate.getForObject("http://localhost:8001/product/get/"+productId, Product.class);
        map.put("product",product);
        return "product";
    }
=======




    @RequestMapping("/page/{productId}")
    public String showHomePage(@PathVariable @NotNull String productId, Map<String,Object>  attributeMap){
//        Product product =  restTemplate.getForObject("http://localhost:8001/product/get/"+productId,Product.class,productId);
        /** http://MICROCLOUD-STOCK/ 是微服务提供者注册在eureka上的服务名，可能是集群环境，但注册在eureka上的服务名是一个*/
        Product product =  restTemplate.getForObject("http://MICROCLOUD-STOCK/product/get/"+productId,Product.class,productId);
        log.info("从库存微服务 http://MICROCLOUD-STOCK/ 获取到的商品信息 = {}",product.toString());
        attributeMap.put("product",product);
        return "product";
    }

>>>>>>> 3774be13ffb016b58265c2043199f9ede032bd21
}
