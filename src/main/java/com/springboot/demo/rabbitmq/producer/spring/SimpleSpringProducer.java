package com.springboot.demo.rabbitmq.producer.spring;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleSpringProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    /**
     * 1.简单模式 HelloWorld:一个生产者、一个消费者，不需要设置交换机（使用默认的交换机）
     */
    public void helloWorldTest(){
        String body ="简单模式 HelloWorld 》hello world spring-rabbitmq";
        rabbitTemplate.convertAndSend("spring_hello_word",body);
    }
}
