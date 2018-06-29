package com.org.springboot.utils;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by paopaolong on 16/9/6.
 */
@Setter
@Getter
@ToString
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 8350327877975282483L;

    private boolean success;  //表示调用是否成功 ,如果为true,则可以调用getResult,如果为false,则调用errorCode来获取出错信息

    private T data;  //获取调用返回值

    private String errorCode; //获取错误码

    private String errorMsg;

    public Result() {

    }

    public Result(T data) {
        this.success = true;
        this.data = data;
    }

    public Result(String errorCode, String errorMsg) {
        this.success = false;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Result(String errorCode, String errorMsg, T data) {
        this.success = false;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.data = data;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setResult(T result) {
        success = true;
        this.data = result;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.success = false;
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public void setErrorResult(String errorCode, String errorMsg) {
        this.success = false;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Result response = (Result) o;

        if (success != response.success) {
            return false;
        }
        if (!errorCode.equals(response.errorCode)) {
            return false;
        }
        if (!data.equals(response.data)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result1 = (success ? 1 : 0);
        result1 = 31 * result1 + data.hashCode();
        result1 = 31 * result1 + errorCode.hashCode();
        return result1;
    }
}
