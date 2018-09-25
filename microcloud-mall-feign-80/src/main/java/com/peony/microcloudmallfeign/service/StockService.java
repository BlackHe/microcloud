package com.peony.microcloudmallfeign.service;

import com.peony.entity.Product;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient("http://MICROCLOUD-STOCK")
public interface StockService {


    @RequestMapping(value = "/get",method = RequestMethod.GET)
    Product getProduct(@RequestParam("productId") String productId);
}
