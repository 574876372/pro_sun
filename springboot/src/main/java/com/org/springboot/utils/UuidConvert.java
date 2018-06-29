package com.org.springboot.utils;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * Created by paopaobing on 2017/8/30.
 */
public class UuidConvert extends ClassicConverter {
    @Override
    public String convert(ILoggingEvent event) {
        return LogUtil.getLogId();
    }

}
