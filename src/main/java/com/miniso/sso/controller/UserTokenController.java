package com.miniso.sso.controller;

import com.miniso.sso.exception.SSOException;
import com.miniso.sso.service.IRedisService;
import com.miniso.sso.util.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liujiecong
 * @date 2018/6/11
 * <p/>
 * 描述: 获取/保存用户token
 */
@RestController
@Slf4j
@RequestMapping("/userToken")
public class UserTokenController {

    @Autowired
    private IRedisService redisService;

    /**
     * 保存用户的Token信息
     *
     * @return 返回保存状态
     */
    @RequestMapping("/putToken")
    public AjaxResult setUserToken(String userId, String token, int expireTime) {
        log.info("用户id:{}, 过期时间:{}", userId, expireTime);
        AjaxResult result = new AjaxResult();
        try {
            redisService.set(userId, token, expireTime);
            result.successResult("generate token successfully", null, null);
        } catch (SSOException e) {
            result.failedResult(e.getErrorCode(), e.getErrorMessage());
        }
        return result;
    }

    /**
     * 获取用户的Token信息
     *
     * @param appId  调用接口应用id
     * @param appKey 调用接口应用key
     * @param userId 用户Id
     * @return 返回用户登录token
     */
    @RequestMapping("/getToken")
    public AjaxResult getUserToken(String userId, String appId, String appKey) {
        AjaxResult result = new AjaxResult();
        log.info("用户id:{}", userId);
        try {
            //获取用户token
            String token = redisService.get(userId);
            result.successResult("get user token successfully", token, null);
        } catch (SSOException e) {
            log.error("get user token error, userId:{}", userId);
            result.failedResult(e.getErrorCode(), e.getErrorMessage());
        }
        return result;
    }


}
