package com.springboot.demo.rabbitmq.consumer.spring;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class TopicListenerThree  implements MessageListener {
    @Override
    public void onMessage(Message message) {
        String clazzName = new Object() {
            public String getClassName() {
                String clazzName = this.getClass().getName();
                return clazzName.substring(0, clazzName.lastIndexOf('$'));
            }
        }.getClassName();

        System.out.println(clazzName+"body:" + new String(message.getBody()));
    }
}

