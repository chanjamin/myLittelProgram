package com.example;

import com.example.jedis.JedisTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
@EnableConfigurationProperties(RedisProperties.class)
@ConditionalOnClass(Jedis.class)
public class RedisAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean(Jedis.class)
    public Jedis jedis(final RedisProperties redisProperties) {
        Jedis jedis = new JedisTemplate(redisProperties.getHost(), redisProperties.getPort());
        String auth = jedis.auth(redisProperties.getPassword());
        return jedis;
    }
}
