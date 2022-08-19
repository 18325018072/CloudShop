package com.kevin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.*;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

/**
 * @author Kevin2
 */
public class Con2 {
    public static void main(String[] args) throws IOException, TimeoutException {
        // 1.建立连接
        ConnectionFactory factory = new ConnectionFactory();
        // 1.1.设置连接参数，分别是：主机名、端口号、vhost、用户名、密码
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("root");
        factory.setPassword("root");
        // 1.2.建立连接
        Connection connection = factory.newConnection();

        // 2.创建通道Channel
        Channel channel = connection.createChannel();
        // 3.创建队列
        String queueName = "SellQueue";
        channel.queueDeclare(queueName, false, false, false, null);
        // 4.订阅消息
        channel.basicConsume(queueName, true, new DefaultConsumer(channel) {
            @SneakyThrows
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) {
                // 5.处理消息
                ObjectMapper objectMapper = new ObjectMapper();
                HashMap<String, Object> map = objectMapper.readValue(body, HashMap.class);
                //Long userId,String goods,Integer num
                System.out.println("map.get(\"userId\") = " + map.get("userId"));
                System.out.println(map.get("userId").getClass());
                System.out.println("map.get(\"storeId\") = " + map.get("storeId"));
                System.out.println(map.get("storeId").getClass());
                System.out.println("map.get(\"num\") = " + map.get("num"));
                System.out.println(map.get("num").getClass());
                Long userId = (Long)(long)(int) map.get("userId");
                Long storeId= (Long)(long)(int) map.get("storeId");
                Integer num= (Integer) map.get("num");
                System.out.println("接收到消息：【" + map + "】");
            }
        });
        System.out.println("我准备好了");
    }
}
