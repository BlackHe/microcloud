# springcloud之路

### 分布式+微服务,spirngcloud


*   REST API
    
    ````
    springcloud的REST方式调用远程服务,是基于http协议的，虽然数据传输效率略低，
    但是，极大的降低了服务提供者与服务消费者之间的耦合性，使得远程服务调用完全与代码无关。
    而dubbo是采用RPC过程式调用，恰好与REST调用相反。
    ````
    
*   RestTemplate

    ```
    RestTemplate是springcloud远程调用的具体实现方式,只要在容器启动的时候初始化即可使用
    ```

*   eureka
    
    ``````
     注册中心，分为服务发现服务器和待注册客户端，可以将单个eureka设置为高可用性的，也可以部署eureka集群，
     将已注册的服务复制到集群的每个点。
     跟zookeeper最大的区别就是eureka采取了AP原则（高可用、分区容错性），
     是spring家族netflix的产品,而zoopeeker采取的是CP原则（强一致性，分区容错性）
    ``````
   
*   ribbon
    ``````
    基于客户端的负载均衡组件，内置7中负载算法，默认是RoundRibbonRule（轮询算法）,可通过
    服务提供方（集群）注册进eureka（集群）的服务名找到主机并分发调用
    ``````
   
*  feign

    ```
    feign是对rebbon的上层封装，用controller-->service-->dao的风格调用远程服务，极大简化了不同服务之间的方法调用
    ```
