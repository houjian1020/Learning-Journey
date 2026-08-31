package com.springboot.demo.rabbitmq.consumer.springboot;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class AckConsumerSpringBoot {

    /**
     *  开启手动签收：acknowledge-mode: manual
     * @param message
     */
    @RabbitListener(queues = "springboot_topic_queue")
    public void receive(Message message, Channel channel) throws Exception {
        try {
            // 处理消息逻辑
            System.out.println("接收到消息: {}"+ message);

            // 消息处理成功后确认消息
            /**
             * 确认消息
             * deliveryTag：消息唯一标识标签
             * multiple:是否批量确认
             */
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            System.out.println("消息处理失败: {}"+ e.getMessage());

            // 消息处理失败时，可以选择重新入队或其他处理方式
            /**
             * 拒绝消息
             * deliveryTag：消息唯一标识标签
             * multiple:true 时，否定确认直到 deliveryTag 为止的所有未确认消息；false 时，否定确认deliveryTag 的单条消息
             * requeue：true 重新排队；   false  消息会被丢弃或根据消息的属性（如是否设置了死信交换/队列）被发送到死信队列
             */
             channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
        }
    }

}
