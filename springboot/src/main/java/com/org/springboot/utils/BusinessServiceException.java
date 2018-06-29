package com.org.springboot.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by paopaobing on 2017/8/30.
 */
@Setter
@Getter
@ToString
public class BusinessServiceException extends RuntimeException {

    private String code;

    public BusinessServiceException(String code) {
        this.code = code;
    }

    public BusinessServiceException(String code, Throwable throwable) {
        super(throwable);
        this.code = code;
    }

    public BusinessServiceException(String code, String message) {
        super(message);
        this.code = code;

    }

    public BusinessServiceException(String code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
    }
}
