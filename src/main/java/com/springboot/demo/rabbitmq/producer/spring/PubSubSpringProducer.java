package com.springboot.demo.rabbitmq.producer.spring;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PubSubSpringProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    /**
     * 5.通配符；设置类型为 topic 的交换机; *匹配一个单词，#匹配多个单词
     */
    public void topicTest(){
        //队列1：订单日志输出,队列2：商品日志输出
        //队列3：购物车日志输出,队列4：所有日志输出
        String bodyOrder ="通配符 》hello world spring-rabbitmq,========order";
        rabbitTemplate.convertAndSend("spring_topic_exchange","order.log",bodyOrder);

        String bodyGood ="通配符 》hello world spring-rabbitmq,========good";
        rabbitTemplate.convertAndSend("spring_topic_exchange","good.info",bodyGood);

        String bodyCar ="通配符 》hello world spring-rabbitmq,========car";
        rabbitTemplate.convertAndSend("spring_topic_exchange","car.log",bodyCar);
//
//        String bodyAll ="通配符 》hello world spring-rabbitmq,========all";
//        rabbitTemplate.convertAndSend("spring_topic_exchange","order.log",bodyAll);
    }
}
