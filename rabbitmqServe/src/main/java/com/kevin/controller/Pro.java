package com.kevin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kevin.cloudshop.domain.ResultPac;
import com.kevin.cloudshop.domain.ResultState;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/**
 * @author Kevin2
 */
public class Pro {
    public static void main(String[] args) {
        // 1.建立连接
        ConnectionFactory factory = new ConnectionFactory();
        // 1.1.设置连接参数，分别是：主机名、端口号、vhost、用户名、密码
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("root");
        factory.setPassword("root");
        // 2.建立连接\创建通道Channel
        try(Connection connection = factory.newConnection();
            Channel channel = connection.createChannel()) {
            // 3.创建队列
            String queueName = "SellQueue";
            channel.queueDeclare(queueName, false, false, false, null);

            // 4.发送消息
            HashMap<String, Object> map = new HashMap<>(3);
            map.put("userId",88111);
            map.put("goods","fsdf");
            map.put("num",434);
            ObjectMapper objectMapper = new ObjectMapper();
            String data = objectMapper.writeValueAsString(map);
            channel.basicPublish("", queueName, null, data.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
