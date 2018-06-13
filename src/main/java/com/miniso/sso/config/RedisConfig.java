package com.miniso.sso.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author liujiecong
 * @date 2018/6/11
 * <p/>
 * 描述: Reids配置类
 */
@Component
@ConfigurationProperties(prefix = "spring.redis")
@Setter
@Getter
public class RedisConfig implements Serializable {
    private static final long serialVersionUID = -6981403180151897631L;

    /** 最大活动数 */
    private Integer maxActive;
    /** 最大空闲数*/
    private Integer maxIdle;
    /** 最小空闲数*/
    private Integer minIdle;
    /** 最大等待时间*/
    private Long maxWaitMillis;
    /** 借用时测试是否可用*/
    private Boolean testOnBorrow;
    /** 返回时测试是否可用*/
    private Boolean testOnReturn;
    /** */
    private Integer maxTotal;

    /** */
    private String url;
}
