package com.example.seckill.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        // key serialization
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // value serialization
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        // hash type key serialization
        redisTemplate.setHashKeySerializer((new StringRedisSerializer()));
        // hash type value  serialization
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        // inject connectionFactory
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
}
