package com.springboot.demo.rabbitmq.consumer.spring;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * 3. 发布订阅模式 Publish/subscribe,广播；所有队列都能收到消息
 * @author: xxxx
 * @DateTime: 2023/9/1 15:23
 */
public class PubSubFanoutListenerTwo implements MessageListener {
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

