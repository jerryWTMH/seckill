package com.example.seckill.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * Message Consumer
 */
@Service
@Slf4j
public class MQReceiver {
    @RabbitListener(queues = "queue")
    public void receive(Object msg){
        log.info("receive message" + msg);
    }

    @RabbitListener(queues="queue_fanout01")
    public void receive01(Object msg){
        log.info("QUEUE01 receive message: " + msg);
    }

    @RabbitListener(queues="queue_fanout02")
    public void receive02(Object msg){
        log.info("QUEUE02 receive message: " + msg);
    }

    @RabbitListener(queues="queue_direct01")
    public void receive03(Object msg){
        log.info("QUEUE01 receive message: " + msg);
    }

    @RabbitListener(queues="queue_direct02")
    public void receive04(Object msg){
        log.info("QUEUE02 receive message: " + msg);
    }

    @RabbitListener(queues="queue_topic01")
    public void receive05(Object msg){
        log.info("QUEUE01 receive message: " + msg);
    }

    @RabbitListener(queues="queue_topic02")
    public void receive06(Object msg){
        log.info("QUEUE02 receive message: " + msg);
    }

    @RabbitListener(queues="queue_header01")
    public void receive07(Message message){
        log.info("QUEUE01 receive Message Object: " + message);
        log.info("QUEUE01 receive message: " + new String(message.getBody()));
    }

    @RabbitListener(queues="queue_header02")
    public void receive08(Message message){
        log.info("QUEUE02 receive Message Object: " + message);
        log.info("QUEUE02 receive message: " + new String(message.getBody()));
    }


}
