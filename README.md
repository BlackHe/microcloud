## springcloud-基于微服务构建大型分布式系统

1. spring cloud netflix
2. spring cloud config



*   REST API
    
    ````
    springcloud的REST方式调用远程服务,是基于http协议的，虽然数据传输效率略低，
    但是，极大的降低了服务提供者与服务消费者之间的耦合性，使得远程服务调用完全与代码无关。
    而dubbo是采用RPC过程式调用，恰好与REST调用相反。
    ````
    
*   RestTemplate

    ```
    RestTemplate是springcloud远程调用的具体实现方式,只要在容器启动的时候初始化即可使用
    关键注解：@Configration, @Bean
    ```

*   eureka
    
    ``````
     注册中心，分为服务发现服务器和待注册客户端，可以将单个eureka设置为高可用性的，也可以部署eureka集群，
     将已注册的服务复制到集群的每个点。
     跟zookeeper最大的区别就是eureka采取了AP原则（高可用、分区容错性），
     是spring家族netflix的产品,而zoopeeker采取的是CP原则（强一致性，分区容错性）
     关键注解：@EnableEurekaServer,@EnableEurekaClient
     关键配置：注意server端不需要将自己注册进eureka。
    ``````
   
*   ribbon
    ``````
    基于客户端的负载均衡组件，内置7中负载算法，默认是RoundRibbonRule（轮询算法）,可通过
    服务提供方（集群）注册进eureka（集群）的服务名找到主机并分发调用。
    关键注解：@RibbonClient(name="微服务名称"),@Configration, @LoadBalanced,@Bean
    注：1、微服务名称是springboot应用的spring.application.name,如果是集群服务，则多个springboot的服务名设置为一个，
          共同注册进eureka
        2、ribbon的轮询策略有很大弊端，当集群中某个服务不可用时，会直接给调用者报错，并且轮询链上后面的服务都不会再去调用。
           如果瘫痪的是轮询链上的第一个服务节点。则整个服务提供者集群都不可用了。
    ``````
   
*  feign

    ```
    feign是对rebbon的上层封装，用controller-->service-->dao的风格调用远程服务，极大简化了不同服务之间的方法调用
    默认支持负载均衡，默认策略为轮询。也是基于客户端的负载均衡。
    关键注解：@EnableFeignClients,@FeignClient
    特点：当服务提供者集群中的某个单点出现故障，feign会自动去轮询下一个服务，而不会给调用者返回报错。当这个服务回归正常时，又可以
         正常调用了。同样是轮询的负载策略，rebbion就没有这么智能了，rebbion如果遇到某个服务不可用时，会直接给调用者
         跑出错误，这是个很大的弊端。从这一点上，feign的设计理念更符合spring cloud netfilx eureka高可用的初衷。也符合
         spring mvc的程序模型。
    ```

* hystrix

    ```
    hystrix是基于客户端的断路器
    ```