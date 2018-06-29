package com.org.springboot.services;

import com.org.springboot.mapper.WashProductInfoDOMapper;
import com.org.springboot.model.db.WashProductInfoDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by BF100395 on 2017/8/18.
 */
@Service
public class WashProductInfoServices {

    @Autowired
    private WashProductInfoDOMapper washProductInfoDOMapper;


    public WashProductInfoDO queryWashProductInfo(){
        WashProductInfoDO washProductInfoDO  = washProductInfoDOMapper.selectByPrimaryKey(27L);
        return washProductInfoDO;
    }

    @Transactional(rollbackFor = Exception.class)
    public  void insetObje(){
        WashProductInfoDO washProductInfoDO  = buildDO();
        washProductInfoDOMapper.insertSelective(washProductInfoDO);
    }

    public WashProductInfoDO buildDO(){
        WashProductInfoDO  washProductInfoDO  =new WashProductInfoDO();
        washProductInfoDO.setMemberId("9999");
        washProductInfoDO.setMemberTransDate(new Date());
        washProductInfoDO.setTerminalId("999999");
        washProductInfoDO.setProductId("xx");
        washProductInfoDO.setFunctionId("xx");
        washProductInfoDO.setMemberOrderId("xx");
        washProductInfoDO.setIndustryType("xxx");
        washProductInfoDO.setIdCardNo("xx");
        washProductInfoDO.setIdHolder("xxx");
        washProductInfoDO.setIdCardType("I");

        washProductInfoDO.setMaxMoney("xx");
        washProductInfoDO.setCntGoodMember(2);
        washProductInfoDO.setCntBadMember(6);
        washProductInfoDO.setAbnormal(8);
        washProductInfoDO.setActive("9");
        washProductInfoDO.setCreateTime(new Date());
        washProductInfoDO.setUpdateTime(new Date());
        washProductInfoDO.setTag("t");
        washProductInfoDO.setTagDesc("dsc");
        washProductInfoDO.setTradeNo("555");
        washProductInfoDO.setCode("c");
        washProductInfoDO.setMessage("S");
        washProductInfoDO.setTransId("SS");
        washProductInfoDO.setTradeNo("XX");
        washProductInfoDO.setMaxDays("XXX");
        boolean fee = true;
        if(fee==false){
            washProductInfoDO.setIsFee("F");
        }else {
            washProductInfoDO.setIsFee("T");
        }
        return  washProductInfoDO;
    }

}
