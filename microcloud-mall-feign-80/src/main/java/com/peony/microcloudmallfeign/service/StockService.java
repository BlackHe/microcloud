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


/***
 *  http://MICROCLOUD-STOCK/ 也就是微服务名(spring.application.name)是服务提供者注册在eureka上的服务名，多个微服务使用同一个微服务名，就形成了集群环境，
 *  如果此时eureka server也是集群环境，则微服务集群+eureka集群，实现了高可用
 */
@Component
@FeignClient("http://MICROCLOUD-STOCK")
public interface StockService {


    /***
     * 开发者只需要按照约束编写接口，
     * feigh会自动到http://MICROCLOUD-STOCK上发现服务，找到/product/get/{productId} 这个服务的提供者并发送rest请求
     * 得到http响应并绑定到该接口的返回值
     * @param productId
     * @return
     */
    @RequestMapping(value = "/product/get/{productId}",method = RequestMethod.GET)
    Product getProduct(@PathVariable("productId") String productId);
}
