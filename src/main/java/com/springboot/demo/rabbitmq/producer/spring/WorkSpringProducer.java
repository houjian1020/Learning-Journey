package com.springboot.demo.rabbitmq.producer.spring;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkSpringProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    /**
     * 2.工作队列模式 Work Queue:一个生产者、多个消费者（竞争关系），不需要设置交换机（使用默认的交换机）
     */
    public void workQueueTest(){
        String body ="工作队列模式 Work Queue 》hello world spring-rabbitmq";
        for(int i = 0;i <= 10;i++){
            rabbitTemplate.convertAndSend("spring_work_queue",String.valueOf(i)+"==============>"+body);
        }
    }
}
