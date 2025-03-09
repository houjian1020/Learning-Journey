package com.springboot.demo.rabbitmq.consumer.springboot;

import com.springboot.demo.rabbitmq.config.RabbitMQConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicConsumerSpringBootListener {

    @RabbitListener(queues = "springboot_topic_queue")
    public void listenQueue(Message msg) {

        System.out.println("Received message from queue: " + msg.getBody());
    }

/*    @RabbitListener(queues = "springboot_topic_queue2")
    public void listenQueue2(String msg) {

    }*/
}
