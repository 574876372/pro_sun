package com.org.springboot.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by paopaolong on 2017/8/30.
 */
@AllArgsConstructor
@Getter
public enum ErrorMsgEnum {
    ERROR_CODE_0001("0001", "系统异常"),
    ERROR_CODE_0002("0002", "请求参数有误"),
    ;
    private String code;
    private String desc;

}
