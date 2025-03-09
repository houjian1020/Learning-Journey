package com.springboot.demo.rabbitmq.producer.springboot;

import com.springboot.demo.rabbitmq.config.RabbitMQConfig;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 保证消息可靠性投递：
 *  1.生产者开启 Confirm确认模式: publisher-confirm-type: correlated
 *  2.生产者开启 return退回模式:  publisher-returns: true
 *  3.生产者发送消息时 持久化消息到磁盘
 */
@Component
public class ConfirmProducerSpringboot {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void confirmAndReturnMessage() {
        // 确认模式回调函数：没有到达交换机
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {

            /**
             *
             * @param correlationData : 相关配置信息
             * @param ack : 是否成功接收信息  ture 成功  false 失败
             * @param cause: 失败原因
             */
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                if (!ack) {
                    System.out.println("消息发送失败，原因: {}"+cause);
                    // 可以在这里实现重试逻辑
                } else {
                    System.out.println("消息发送成功");
                }
            }
        });

        // 退回模式回调函数： 没有到达队列
        rabbitTemplate.setReturnsCallback(new RabbitTemplate.ReturnsCallback() {

            @Override
            public void returnedMessage(ReturnedMessage returnedMessage) {
                System.out.println("消息未能到队列，返回信息: {}"+ returnedMessage);
                // 可以在这里处理消息未能路由到队列的情况
            }
        });

        /**
         * 发送消息并开启: 消息持久化
         * 交换机持久化：交换机声明时durable(true)
         * 队列持久化： 队列声明时durable(true)
         */
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME,"info.confirm","开启确认模式和退回模式保证生产者消息可达。。。。。",new MessagePostProcessor() {

            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                // 开启持久化：MessageDeliveryMode.PERSISTENT
                message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                return message;
            }
        });




    }
}
