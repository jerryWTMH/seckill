package com.example.seckill.rabbitmq;

import com.example.seckill.pojo.SeckillMessage;
import com.example.seckill.pojo.SeckillOrder;
import com.example.seckill.pojo.User;
import com.example.seckill.service.IGoodsService;
import com.example.seckill.service.IOrderService;
import com.example.seckill.utils.JsonUtil;
import com.example.seckill.vo.GoodsVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Message Consumer
 */
@Service
@Slf4j
public class MQReceiver {
//    @RabbitListener(queues = "queue")
//    public void receive(Object msg){
//        log.info("receive message" + msg);
//    }
//
//    @RabbitListener(queues="queue_fanout01")
//    public void receive01(Object msg){
//        log.info("QUEUE01 receive message: " + msg);
//    }
//
//    @RabbitListener(queues="queue_fanout02")
//    public void receive02(Object msg){
//        log.info("QUEUE02 receive message: " + msg);
//    }
//
//    @RabbitListener(queues="queue_direct01")
//    public void receive03(Object msg){
//        log.info("QUEUE01 receive message: " + msg);
//    }
//
//    @RabbitListener(queues="queue_direct02")
//    public void receive04(Object msg){
//        log.info("QUEUE02 receive message: " + msg);
//    }
//
//    @RabbitListener(queues="queue_topic01")
//    public void receive05(Object msg){
//        log.info("QUEUE01 receive message: " + msg);
//    }
//
//    @RabbitListener(queues="queue_topic02")
//    public void receive06(Object msg){
//        log.info("QUEUE02 receive message: " + msg);
//    }
//
//    @RabbitListener(queues="queue_header01")
//    public void receive07(Message message){
//        log.info("QUEUE01 receive Message Object: " + message);
//        log.info("QUEUE01 receive message: " + new String(message.getBody()));
//    }
//
//    @RabbitListener(queues="queue_header02")
//    public void receive08(Message message){
//        log.info("QUEUE02 receive Message Object: " + message);
//        log.info("QUEUE02 receive message: " + new String(message.getBody()));
//    }

    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private IOrderService orderService;
    /**
     * operation for order
     */
    @RabbitListener(queues = "seckillQueue")
    public void receive(String message){
    log.info("receiving message: " + message);
        SeckillMessage seckillMessage = JsonUtil.jsonStr2Object(message, SeckillMessage.class);
        Long goodId = seckillMessage.getGoodId();
        User user = seckillMessage.getUser();
        // Determine whether number in stock is enough
        GoodsVo goodsVo = goodsService.findGoodsVoByGoodsId(goodId);
        if(goodsVo.getStockCount() < 1){
            return;
        }
        // determine whether buy twice
        SeckillOrder seckillOrder = (SeckillOrder) redisTemplate.opsForValue().get("order:" + user.getId() + ":" + goodId);
        if(seckillOrder != null){
            return;
        }
        // make an order
        orderService.seckill(user, goodsVo);
    }

}
