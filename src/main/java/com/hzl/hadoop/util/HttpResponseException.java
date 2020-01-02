package com.hzl.hadoop.util;

/**
 * HttpResponseException
 *
 * @author huifei.liu@hand-chian.com
 * Date: 2018/11/2
 * Description: http 响应异常
 */

public class HttpResponseException extends Exception  {

    /**
     * 响应状态
     */
    private int responseCode;

    /**
     * 响应body
     */
    private String responseBody;

    public HttpResponseException(int responseCode, String message) {
        this(responseCode, null, message);
    }

    public HttpResponseException(int responseCode, String responseBody, String message) {
        super(message);
        this.responseCode = responseCode;
        this.responseBody = responseBody;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getResponseBody() {
        return responseBody;
    }
}
