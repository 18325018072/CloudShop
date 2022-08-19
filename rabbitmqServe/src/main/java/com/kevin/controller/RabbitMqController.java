package com.kevin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kevin.client.OrderClient;
import com.kevin.client.StoreClient;
import com.kevin.client.UserClient;
import com.rabbitmq.client.*;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

/**
 * @author Kevin2
 */
@Controller
public class RabbitMqController {
    private Connection connection = null;
    private Channel channel = null;

    @Autowired
    OrderClient orderClient;

    @Autowired
    StoreClient storeClient;

    @Autowired
    UserClient userClient;

    public RabbitMqController() {
        // 1.建立连接
        ConnectionFactory factory = new ConnectionFactory();
        // 1.1.设置连接参数，分别是：主机名、端口号、vhost、用户名、密码
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("root");
        factory.setPassword("root");
        try {
            // 1.2.建立连接
            connection = factory.newConnection();
            // 2.创建通道Channel
            channel = connection.createChannel();

        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
//        run();
    }

    @SneakyThrows
    public void run() {
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
                Long userId =  (Long)(long)(int) map.get("userId") ;
                Long storeId= (Long)(long)(int) map.get("storeId");
                Integer num= (Integer) map.get("num");
                System.out.println("接收到消息：【" + map + "】");

                Assert.assertNotNull(storeClient);
                Assert.assertNotNull(userClient);
                //store
                System.out.println(storeClient.updateStore(storeId, -num));
                //user
                //TODO 这里让所有商品统统50元了，数据库设计失误
                System.out.println(userClient.addUserConsume(userId, num * 50));
                //order
                System.out.println(orderClient.addOrder(userId, storeId, num));
            }
        });
        System.out.println("我准备好了");
    }

    @SneakyThrows
    public void close(){
        channel.close();
        connection.close();
    }

}
