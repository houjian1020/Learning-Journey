package com.springboot.demo.rabbitmq.producer.basic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

/**
 * 工作模式：一个生产者=====>一个队列=======>多个消费者（轮流消费）
 * 作用：提高处理速度（代码其实和简单模式一样，只是创建了多个消费者）
 * 步骤：创建连接工厂————设置连接参数————创建连接————创建管道————声明队列————发送消息————关闭资源
 *
 */
public class WorkProducer {
    // 队列名称
    private final static String QUEUE_NAME = "work_queue";

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

            channel.queueDeclare(QUEUE_NAME, true, false, false, null);

            // 6.发送消息
            /**
             * basicPublish(String exchange, String routingKey, AMQP.BasicProperties props, byte[] body)
             * exchange: 交换机名称, 简单模式和工作模式为空
             * routingKey： 路由名称
             * props：配置信息
             * body：发送给消费者的消息
             */
            for (int i = 0; i < 10; i++) {
                String message = "Work, RabbitMQ!";
                channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            // 7.关闭资源
            try {
                if (channel != null) {
                    channel.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
