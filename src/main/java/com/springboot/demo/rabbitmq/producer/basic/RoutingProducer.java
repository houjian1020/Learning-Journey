package com.springboot.demo.rabbitmq.producer.basic;

import com.rabbitmq.client.*;

/**
 * 路由模式：一个生产者=====>多个队列（根据key匹配）=======>多个消费者
 * 特点：根据key的不同发送到不同的队列
 * 步骤：创建连接工厂————设置连接参数————创建连接————创建管道————声明交换机————声明队列————交换机与队列绑定————发送消息————关闭资源
 */
public class RoutingProducer {
    // 队列名称
    private final static String QUEUE_NAME1 = "routing_queue1";
    private final static String QUEUE_NAME2 = "routing_queue2";
    // 交换机名称
    private final static String EXCHANGE_NAME = "routing_exchange";

    public static void main(String[] args) throws Exception {
        // 1.创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 2.设置连接参数
//        factory.setHost("localhost"); // 设置RabbitMQ服务器地址
//        factory.setPort(5672);// 设置RabbitMQ服务端口，默认为5672
//        factory.setVirtualHost("/"); // 设置RabbitMQ虚拟主机，默认为"/"
//        factory.setUsername("guest");// 设置RabbitMQ用户名，默认为"guest"
//        factory.setPassword("guest");// 设置RabbitMQ密码，默认为"guest"
        // 3.创建连接
        Connection connection = factory.newConnection();
        // 4.创建管道
        Channel channel = connection.createChannel();
        try {
            // 5.声明交换机
            /**
             * exchangeDeclare(String exchange, BuiltinExchangeType type, boolean durable, boolean autoDelete, boolean internal, Map<String, Object> arguments)
             * exchange:交换器的名称
             * type:交换器的类型
             *          fanout: 扇形交换 发送消息到每一个绑定队列
             *          direct: 直接交换 定向匹配
             *          topic:  主题交换 通配符匹配 *代表一个单词  #代表0或多个
             * durable：是否持久化
             * autoDelete:是否自动删除
             * internal:是否内部
             * arguments：配置参数
             */
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT,true,false,false,null);
            // 6.声明队列（如果不存在则创建）
            /**
             * queueDeclare(String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments)
             * queued：队列名称
             * durable：是否持久化
             * exclusive：是否排他
             * autoDelete：是否自动删除
             * arguments：队列配置参数：存活时间、最大消息量等
             */

            channel.queueDeclare(QUEUE_NAME1, true, false, false, null);
            channel.queueDeclare(QUEUE_NAME2, true, false, false, null);

            // 7.交换机与队列绑定
            /**
             * queueBind(String queue, String exchange, String routingKey)
             * queue：队列名称
             * exchange：交换机名称
             * routingKey: 绑定key 交换机类型为fanout时，key无需绑定 发送给所有队列
             */
            String routingKey1 = "info";
            String routingKey2 = "error";
            String routingKey3 = "warning";
            // 一个队列绑定多了key
            channel.queueBind(QUEUE_NAME1,EXCHANGE_NAME,routingKey1);
            channel.queueBind(QUEUE_NAME1,EXCHANGE_NAME,routingKey2);
            channel.queueBind(QUEUE_NAME1,EXCHANGE_NAME,routingKey3);

            channel.queueBind(QUEUE_NAME2,EXCHANGE_NAME,routingKey2);

            // 8.发送消息
            /**
             * basicPublish(String exchange, String routingKey, AMQP.BasicProperties props, byte[] body)
             * exchange: 交换机名称, 简单模式和工作模式为空
             * routingKey： 路由名称
             * props：配置信息
             * body：发送给消费者的消息
             */
            String message1 = "routing-info RabbitMQ!";
            channel.basicPublish(EXCHANGE_NAME, routingKey1, MessageProperties.PERSISTENT_TEXT_PLAIN, message1.getBytes());
            String message2 = "routing-error RabbitMQ!";
            channel.basicPublish(EXCHANGE_NAME, routingKey2, MessageProperties.PERSISTENT_TEXT_PLAIN, message2.getBytes());


        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            // 9.关闭资源
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
