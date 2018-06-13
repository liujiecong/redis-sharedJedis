/**
 *
 */
package com.miniso.sso.exception;

/**
 * 通用调用异常
 *
 * @author liujiecong
 * @date 2018-06-11
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = -1283639307723706238L;

    private String errorMessage;
    private String errorCode;
    private String requestId;
    private String hostId;

    /**
     * @param errorCode
     */
    public ServiceException(String errorCode) {
        super();
        this.errorCode = errorCode;
    }

    /**
     * @param errorMessage
     * @param errorCode
     */
    public ServiceException(String errorCode, String errorMessage) {
        super();
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    /**
     * 用异常消息和表示异常原因的对象构造新实例。
     *
     * @param errorMessage 异常信息。
     * @param cause        异常原因。
     */
    public ServiceException(String errorMessage, Throwable cause) {
        super(null, cause);
        this.errorMessage = errorMessage;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * @return the errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode the errorCode to set
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return the requestId
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * @param requestId the requestId to set
     */
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    /**
     * @return the hostId
     */
    public String getHostId() {
        return hostId;
    }

    /**
     * @param hostId the hostId to set
     */
    public void setHostId(String hostId) {
        this.hostId = hostId;
    }


}
