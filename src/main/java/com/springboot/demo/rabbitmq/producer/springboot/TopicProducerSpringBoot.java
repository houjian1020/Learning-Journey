package com.springboot.demo.rabbitmq.producer.springboot;

import com.springboot.demo.rabbitmq.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicProducerSpringBoot {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    private static final String ROUTING_KEY = "springboot.topic.producer";
    private String message = "Hello Topic!";

    /**
     * 发送消息
     */
    public void sendMessage() {
        /**
         * convertAndSend(String exchange, String routingKey, Object object)
         * exchange: 交换机名称
         * routingKey： key
         * object: 携带的数据
         */
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME,ROUTING_KEY, message);
    }
}
