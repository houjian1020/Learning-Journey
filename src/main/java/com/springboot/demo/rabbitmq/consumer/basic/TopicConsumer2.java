package com.springboot.demo.rabbitmq.consumer.basic;

import com.rabbitmq.client.*;

import java.io.UnsupportedEncodingException;

/**
 * 步骤：创建连接工厂————设置连接参数————创建连接————创建管道————声明队列————接收消息————创建建回调————关闭资源
 */
public class TopicConsumer2 {
    // 队列名称
    private final static String QUEUE_NAME2 = "topic_queue2";

    public static void main(String[] args) throws Exception {
        // 1.创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 2.设置连接参数
        factory.setHost("localhost"); // 设置RabbitMQ服务器地址
        factory.setPort(5672);// 设置RabbitMQ服务端口，默认为5672
        factory.setVirtualHost("/"); // 设置RabbitMQ虚拟主机，默认为"/"
        factory.setUsername("guest");// 设置RabbitMQ用户名，默认为"guest"
        factory.setPassword("guest");// 设置RabbitMQ密码，默认为"guest"
        // 3.创建连接
        Connection connection = factory.newConnection();
        // 4.创建管道
        Channel channel = connection.createChannel();
        try {
            // 5.声明队列（如果不存在则创建）
            /**
             * queueDeclare(String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments)
             * queued：队列名称
             * durable：是否持久化
             * exclusive：是否排他
             * autoDelete：是否自动删除
             * arguments：队列配置参数：存活时间、最大消息量等
             */

            channel.queueDeclare(QUEUE_NAME2, true, false, false, null);

            // 6.接收消息

            // 回调函数：处理接收到的消息
            DeliverCallback deliverCallback = new DeliverCallback() {
                @Override
                public void handle(String consumerTag, Delivery delivery) throws UnsupportedEncodingException {
                    String message = new String(delivery.getBody(), "UTF-8");
                    System.out.println(" topic_queue2 Received '" + message + "'");
                }
            };

            /**
             * basicConsume(String queue, boolean autoAck, DeliverCallback deliverCallback, CancelCallback cancelCallback)
             * queue:队列的名称
             * autoAck:是否自动确认消息
             * deliverCallback:当消息投递给消费者时触发的回调接口
             * cancelCallback:当消费者被取消时触发的回调接口
             */
            channel.basicConsume(QUEUE_NAME2, true, deliverCallback, consumerTag -> { });

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            // 7.无需关闭资源（关闭后无法接收消息）

        }
    }
}
