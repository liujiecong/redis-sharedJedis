package com.miniso.sso.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujiecong
 * @date 2018/6/11
 * <p/>
 * 描述: Jedis配置类
 */
@Configuration
@Slf4j
public class JedisConfiguration {

    @Autowired
    RedisConfig redisConfig;

    @Bean
    public ShardedJedisPool convertJedisPool() {

        log.info("init ShardedJedisPool ... ");
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(redisConfig.getMaxTotal());
        jedisPoolConfig.setMaxIdle(redisConfig.getMaxIdle());
        jedisPoolConfig.setMaxWaitMillis(redisConfig.getMaxWaitMillis());
        jedisPoolConfig.setTestOnBorrow(redisConfig.getTestOnBorrow());
        jedisPoolConfig.setTestOnReturn(redisConfig.getTestOnReturn());
        List<JedisShardInfo> jedisShardInfoList = new ArrayList<>();
        jedisShardInfoList.add(new JedisShardInfo(redisConfig.getUrl()));
        return new ShardedJedisPool(jedisPoolConfig, jedisShardInfoList);
    }

    @Bean
    public ShardedJedis getShardedJedis() {
        return convertJedisPool().getResource();
    }

}
