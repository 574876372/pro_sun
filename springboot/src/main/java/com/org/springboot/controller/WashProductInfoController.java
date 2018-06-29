package com.org.springboot.controller;

import com.org.springboot.enums.ErrorMsgEnum;
import com.org.springboot.model.db.WashProductInfoDO;
import com.org.springboot.model.dto.UserDTO;
import com.org.springboot.services.WashProductInfoServices;
import com.org.springboot.services.redis.RedisServices;
import com.org.springboot.utils.BusinessServiceException;
import com.org.springboot.utils.LogUtil;
import com.org.springboot.utils.Result;
import com.org.springboot.utils.VerifyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by BF100395 on 2017/8/18.
 */
@Slf4j
@RestController
@RequestMapping("/wash")
public class WashProductInfoController {

    @Autowired
    private WashProductInfoServices washProductInfoServices;

    @Autowired
    private RedisServices  redisServices;

    @ResponseBody
    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public Result<WashProductInfoDO> view(UserDTO userDTO) {
        LogUtil.updateLogId(UUID.randomUUID().toString());
        log.info("请求参数{}",userDTO);
        Result<WashProductInfoDO>    result   = null;
        try {
            VerifyUtil.validateObject(userDTO);
            WashProductInfoDO washProductInfoDO  =washProductInfoServices.queryWashProductInfo();
            result  = new Result<WashProductInfoDO>(washProductInfoDO);
        }catch (BusinessServiceException e){
            result  = new Result<WashProductInfoDO>(e.getCode(),e.getMessage());
        }catch (Exception e){
            result  = new Result<WashProductInfoDO>(ErrorMsgEnum.ERROR_CODE_0001.getCode(),ErrorMsgEnum.ERROR_CODE_0001.getDesc());
        }
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/testRedis",method = RequestMethod.GET)
    public String testRedis() {
        try {
            redisServices.setString("myname","chenlei");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/getKey",method = RequestMethod.GET)
    public String getKey() {
        return redisServices.getByKey("myname");
    }
}
