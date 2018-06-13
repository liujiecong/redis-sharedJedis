package com.miniso.sso.util;

import lombok.Getter;
import lombok.Setter;

/**
 * 请求返回结果
 *
 * @author liujiecong
 */
@Setter
@Getter
public class AjaxResult {

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 状态码
     */
    private String code;

    /**
     * 消息
     */
    private String msg;
    /**
     * 数据
     */
    private Object data;

    /**
     * 返回对象
     */
    private String returnObject;

    /**
     * 默认为不成功
     */
    public AjaxResult() {
        this.success = false;
    }

    public void successResult(String msg, Object data, String returnObject) {
        this.success = true;
        this.msg = msg;
        this.data = data;
        this.returnObject = returnObject;
    }

    public void failedResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
