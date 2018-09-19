# springcloud之路

### 分布式+微服务,spirngcloud

*   REST API
    
    ````
    springcloud的REST方式调用远程服务，天生支持http REST ful风格，虽然数据传输效率略低，
    但是，极大的降低了服务提供者与服务消费者之间的耦合性，使得远程服务调用完全与代码无关。
    而dubbo是采用RPC过程式调用，恰好与REST调用相反。

    ````
    
*   eureka
    
    ``````
     注册中心，跟zookeeper最大的区别就是eureka采取了AP原则（高可用、分区容错性）
      而zoopeeker采取的是CP原则（强一致性，分区容错性）
    ``````
   
*   ribbon
    ``````
    基于客户端的负载均衡插件，内置7中负载算法，默认是RoundRibbonRule（轮询算法）,可通过
    服务提供方（集群）注册进eureka（集群）的服务名找到主机并分发调用
    ``````
   
*  feign

    ```
    feign是的http客户端调用更加简洁，方便
    ```