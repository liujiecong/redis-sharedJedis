package com.miniso.sso.service;

import com.miniso.sso.exception.SSOException;

/**
 * @author liujiecong
 * @date 2018/6/11
 * <p/>
 * 描述: Redis 业务接口
 */
public interface IRedisService {

    /**
     * 保存值
     *
     * @param key         key
     * @param value       值
     * @param expireMills 超时时间(毫秒) -1为永久
     * @throws SSOException
     */
    void set(String key, String value, int expireMills) throws SSOException;

    /**
     * 根据key获取值
     *
     * @param key key
     * @return 值
     * @throws SSOException
     */
    String get(String key) throws SSOException;
}
