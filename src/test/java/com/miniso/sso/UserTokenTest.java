package com.miniso.sso;

import com.miniso.sso.service.IRedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import redis.clients.jedis.ShardedJedis;

import java.util.Set;

/**
 * 题库接口测试类
 * Created by liujiecong on 2017-9-15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = App.class)// 指定spring-boot的启动类
@ActiveProfiles(value = "dev")
public class UserTokenTest {

    @Autowired
    private IRedisService redisService;

    @Autowired
    ShardedJedis jedis;

    @Test
    public void test() {
        String s = redisService.get("9529");
        System.out.println(s);
    }

    @Test
    public void test2() {
        //jedis.sadd("10000","aaaa","bbb");
        //jedis.zadd("10001",100,"aaa");
        //jedis.zadd("10001",101,"bbb");
        jedis.lpush("user:0001", "9");
        jedis.lpush("user:0001", "8");
        jedis.lpush("user:0001", "7");
        jedis.lpush("user:0001", "6");
        //jedis.lpop("user:0001");
    }

    @Test
    public void test3() {
        Set<String> smembers = jedis.smembers("10000");
        System.out.println(smembers);
    }

}
