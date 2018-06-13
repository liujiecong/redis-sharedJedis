package com.miniso.sso.service.impl;

import com.miniso.sso.exception.SSOException;
import com.miniso.sso.service.IRedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import redis.clients.jedis.ShardedJedis;

/**
 * @author liujiecong
 * @date 2018/6/11
 * <p/>
 * 描述: Redis业务层实现类
 */
@Service
@Slf4j
public class RedisServiceImpl implements IRedisService {

    @Autowired
    ShardedJedis jedis;

    @Override
    public void set(String key, String value, int expireTime) throws SSOException {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value)) {
            throw new SSOException("4008", "userId or token can not be empty");
        }

        try {
            jedis.set(key, value);
            if (expireTime != -1) {
                //设置超时时间
                jedis.expire(key, expireTime);
            }
            log.info("Redis set success - {}, value: {}", key, value);
        } catch (Exception e) {
            log.error("Redis set error: {}, key: {}", e.getMessage(), key);
            throw new SSOException("4007", "设置用户" + key + " token异常");
        } finally {
            jedis.resetState();
        }
    }

    @Override
    public String get(String key) throws SSOException {
        String result = null;
        try {
            result = jedis.get(key);
            log.info("Redis get success - {}, value: {}", key, result);

        } catch (Exception e) {
            log.error("Redis get error: {}, key: {}", e.getMessage(), key);
            throw new SSOException("4005", "获取用户" + key + " token异常");
        } finally {
            jedis.resetState();
        }

        if (StringUtils.isEmpty(result)) {
            throw new SSOException("4004", "找不到用户token信息");
        }
        return result;
    }
}
