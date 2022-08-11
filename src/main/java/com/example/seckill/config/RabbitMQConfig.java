package com.example.seckill.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ Setting
 */
@Configuration
public class RabbitMQConfig {
    @Bean
    public Queue queue(){
        return new Queue("queue", true);
    }
}
