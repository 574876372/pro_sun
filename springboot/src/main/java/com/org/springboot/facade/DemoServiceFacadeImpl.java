package com.org.springboot.facade;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by paopaobing on 2017/11/24.
 */
@Slf4j
@Service
public class DemoServiceFacadeImpl implements DemoServiceFacade{
    @Override
    public String queryNameById(String id) {
        log.info("facadeTest");
        return "chenlei";
    }
}
