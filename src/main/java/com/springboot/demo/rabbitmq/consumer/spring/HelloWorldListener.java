package com.springboot.demo.rabbitmq.consumer.spring;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * 1.简单模式 HelloWorld
 */
public class HelloWorldListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("body:" + new String(message.getBody()));
    }
}

