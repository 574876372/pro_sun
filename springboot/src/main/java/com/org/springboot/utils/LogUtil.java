package com.org.springboot.utils;

import org.apache.commons.lang.StringUtils;
import org.slf4j.MDC;

import java.util.UUID;

/**
 * log日志辅助类
 * Created by Lijing on 2016/11/11.
 */
public class LogUtil {

    private static final String LOG_UUID = "LOG_UUID";

    /**
     * 更新日志跟踪id
     * @param logID 日志跟踪id(为空时创建新日志跟踪id)
     */
    public static void  updateLogId(String logID){
        if(StringUtils.isBlank(logID)){
            MDC.put(LOG_UUID,createLogId());
        }else {
            MDC.put(LOG_UUID, logID);
        }
    }

    /**
     * 创建日志跟踪id
     * @return 日志跟踪id
     */
    public static String createLogId(){
        return UUID.randomUUID().toString();
    }

    /**
     * 获取日志跟踪id
     * @return 日志跟踪id
     */
    public static String getLogId(){
        Object object =  MDC.get(LOG_UUID);
        if(object==null){
            return null;
        }else {
            return object.toString();
        }
    }

}
