package com.springboot.demo.rabbitmq.producer.spring;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSpringProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    /**
     * 3. 发布订阅模式 Publish/subscribe:设置类型为 fanout 的交换机
     */
    public void pusSubFanoutTest(){
        String body ="发布订阅模式 Publish/subscribe 》hello world spring-rabbitmq";
        rabbitTemplate.convertAndSend("spring_pub_sub_fanout_exchange","",body);
    }
}
