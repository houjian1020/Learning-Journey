package com.springboot.demo.rabbitmq.producer.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 */
@ContextConfiguration(locations = "classpath:spring_rabbitmq.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ProducerTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 1.简单模式 HelloWorld:一个生产者、一个消费者，不需要设置交换机（使用默认的交换机）
     */
    @Test
    public void helloWorldTest(){
        String body ="简单模式 HelloWorld 》hello world spring-rabbitmq";
        rabbitTemplate.convertAndSend("spring_hello_word",body);
    }

    /**
     * 2.工作队列模式 Work Queue:一个生产者、多个消费者（竞争关系），不需要设置交换机（使用默认的交换机）
     */
    @Test
    public void workQueueTest(){
        String body ="工作队列模式 Work Queue 》hello world spring-rabbitmq";
        for(int i = 0;i <= 10;i++){
            rabbitTemplate.convertAndSend("spring_work_queue",String.valueOf(i)+"==============>"+body);
        }
    }

    /**
     * 3. 发布订阅模式 Publish/subscribe:设置类型为 fanout 的交换机
     */
    @Test
    public void pusSubFanoutTest(){
        String body ="发布订阅模式 Publish/subscribe 》hello world spring-rabbitmq";
        rabbitTemplate.convertAndSend("spring_pub_sub_fanout_exchange","",body);
    }

    /**
     * 4.路由模式 Routing:设置类型为 direct 的交换机,并且指定 routing key
     */
    @Test
    public void routingTest(){
        //info  error  warning,
        // 队列1绑定 info  error  warning,需要打印控制台
        //队列2绑定  error,需要保存数据库
        String bodyInfo ="路由模式 Routing 》hello world spring-rabbitmq,测试级别：info";
        rabbitTemplate.convertAndSend("spring_routing_direct_exchange","info",bodyInfo);

        String bodyWarning ="路由模式 Routing 》hello world spring-rabbitmq,测试级别：warning";
        rabbitTemplate.convertAndSend("spring_routing_direct_exchange","warning",bodyWarning);

        String bodyError ="路由模式 Routing 》hello world spring-rabbitmq,测试级别：error";
        rabbitTemplate.convertAndSend("spring_routing_direct_exchange","error",bodyError);
    }

    /**
     * 5.通配符；设置类型为 topic 的交换机; *匹配一个单词，#匹配多个单词
     */
    @Test
    public void topicTest(){
        //队列1：订单日志输出,队列2：商品日志输出
        //队列3：购物车日志输出,队列4：所有日志输出
        String bodyOrder ="通配符 》hello world spring-rabbitmq,========order";
        rabbitTemplate.convertAndSend("spring_topic_exchange","order.log",bodyOrder);

        String bodyGood ="通配符 》hello world spring-rabbitmq,========good";
        rabbitTemplate.convertAndSend("spring_topic_exchange","good.info",bodyGood);

        String bodyCar ="通配符 》hello world spring-rabbitmq,========car";
        rabbitTemplate.convertAndSend("spring_topic_exchange","car.log",bodyCar);

        String bodyAll ="通配符 》hello world spring-rabbitmq,========all";
        //rabbitTemplate.convertAndSend("spring_topic_exchange","order.log",bodyAll);
    }

}

