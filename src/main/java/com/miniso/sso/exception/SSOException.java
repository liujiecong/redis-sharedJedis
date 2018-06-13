/**
 *
 */
package com.miniso.sso.exception;

/**
 * SSO访问Exception
 *
 * @author liujiecong
 * @date 2018-06-11
 */
public class SSOException extends ServiceException {

    /**
     *
     */
    private static final long serialVersionUID = -1024283150815199537L;

    /**
     * @param errorCode
     */
    public SSOException(String errorCode) {
        super(errorCode);
    }

    /**
     * @param errorCode
     * @param errorMessage
     */
    public SSOException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public SSOException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }

}
