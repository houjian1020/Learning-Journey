package com.springboot.demo.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * springboot整合rabbitmq配置： 交换机声明   队列声明    交换机与队列进行绑定
 */
@Configuration
public class RabbitMQConfig {
    public static final String QUEUE_NAME = "springboot_topic_queue";
    public static final String EXCHANGE_NAME = "springboot_topic_exchange";
    public static final String ROUTING_KEY = "info.#";


    // 交换机  durable：交换机持久化
    @Bean("bootExchange")
    public Exchange bootExchange() {
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME).durable(true).build();
    }

/*    public TopicExchange topicExchange() {
        return new TopicExchange(EXCHANGE_NAME, true, false);
    }*/

    // 队列: 创建多个队列需声明多了方法   durable：队列持久化
    @Bean("bootQueue")
    public Queue bootQueue() {
        return QueueBuilder.durable(QUEUE_NAME).build();
    }

/*    @Bean("bootQueue2")
    public Queue bootQueue2() {
        return QueueBuilder.durable(QUEUE_NAME2).build();
    }*/


    // 交换机与队列绑定： 创建多个绑定需声明多个方法进行
    public Binding bootBinding(@Qualifier("bootQueue") Queue queue, @Qualifier("bootExchange")Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY).noargs();
    }

/*
    public Binding bootBinding2(@Qualifier("bootQueue2") Queue queue2, @Qualifier("bootExchange")Exchange exchange) {
        return BindingBuilder.bind(queue2).to(exchange).with(ROUTING_KEY2).noargs();
    }
*/

}
