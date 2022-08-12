package com.example.seckill.rabbitmq;

import org.springframework.amqp.core.MessageProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MQSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Object msg){
        log.info("send message" + msg);
        rabbitTemplate.convertAndSend("fanoutExchange", "", msg);
    }

    public void send01(Object msg){
        log.info("send red message" + msg);
        rabbitTemplate.convertAndSend("directExchange", "queue.red", msg);
    }

    public void send02(Object msg){
        log.info("send red message" + msg);
        rabbitTemplate.convertAndSend("directExchange", "queue.green", msg);
    }

    public void send03(Object msg){
        log.info("send message(QUEUE1 receive)" + msg);
        rabbitTemplate.convertAndSend("topicExchange", "queue.red.message", msg);
    }

    public void send04(Object msg){
        log.info("send message(QUEUE1 and QUEUE2 receive)" + msg);
        rabbitTemplate.convertAndSend("topicExchange", "message.queue.green.abc", msg);
    }

    public void send05(String msg){
        log.info("send message(QUEUE1 and QUEUE2 receive): " + msg);
        MessageProperties properties = new MessageProperties();
        properties.setHeader("color", "red");
        properties.setHeader("speed", "fast");
        Message message = new Message(msg.getBytes(), properties);
        rabbitTemplate.convertAndSend("headersExchange", "", message);
    }

    public void send06(String msg){
        log.info("send message(QUEUE1 receive): " + msg);
        MessageProperties properties = new MessageProperties();
        properties.setHeader("color", "red");
        properties.setHeader("speed", "normal");
        Message message = new Message(msg.getBytes(), properties);
        rabbitTemplate.convertAndSend("headersExchange", "", message);
    }
}
