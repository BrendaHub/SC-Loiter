## 学习Spring Cloud的笔记

- Ribbon是用来做不同资源负载均衡用的
RestTemplate就是调用在Eureka服务器上的资源方式之一， 如果资源是高可用的多实例的情况，就会自动实现资源均衡效果。 

默认是采用的不同实例间的轮询规则 ， 可以通过配置自定义不同的均衡实例规则 配置如下：

```yml
资源名：
  ribbon:
    NFLoadBalancerRuleClassName: com.netflix.loadbalancer.WeightedResponseTimeRule
# 注意， 需要配置类的全限定名
可以通过原码查看到不同的资源均衡实现类
``` 

- 除了RestTemplate实现服务间的通讯， 还可以使用Feign实现

需要在pom中引入Feign组件的依赖

需要要启动类的入口添加一个client的注解 。 @EnableFeignClients

需要定义一个可以调用的api接品， 在里而定上义可以调用的资源和方法

## Feign

- 声明式的Rest客户端（伪类RPC）
- 采用了基于接口的注解方式调用
- Feign内部也采用Ribbon作为资源调用的负载均衡服务
