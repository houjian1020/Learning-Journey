package com.springboot.demo.rabbitmq.producer.spring;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoutingSpringProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    /**
     * 4.路由模式 Routing:设置类型为 direct 的交换机,并且指定 routing key
     */
    public void routingTest(){
        //info  error  warning,
        // 队列1绑定 info  error  warning,需要打印控制台
        //队列2绑定  error,需要保存数据库
        String bodyInfo ="路由模式 Routing 》hello world spring-rabbitmq,测试级别：info";
        rabbitTemplate.convertAndSend("spring_routing_direct_exchange","info",bodyInfo);

        String bodyWarning ="路由模式 Routing 》hello world spring-rabbitmq,测试级别：warning";
        rabbitTemplate.convertAndSend("spring_routing_direct_exchange","warning",bodyWarning);

        String bodyError ="路由模式 Routing 》hello world spring-rabbitmq,测试级别：error";
        rabbitTemplate.convertAndSend("spring_routing_direct_exchange","error",bodyError);
    }
}
